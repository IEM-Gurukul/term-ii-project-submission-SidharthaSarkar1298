import java.util.*;

// Abstract Class
abstract class Person {
    protected String id;
    protected String name;

    Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract void displayRole();
}

// Student Class
class Student extends Person {
    private int totalClasses;
    private int attendedClasses;

    Student(String id, String name) {
        super(id, name);
        this.totalClasses = 0;
        this.attendedClasses = 0;
    }

    void markAttendance(boolean present) {
        totalClasses++;
        if (present) attendedClasses++;
    }

    double getAttendancePercentage() {
        if (totalClasses == 0) return 0;
        return (attendedClasses * 100.0) / totalClasses;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Student");
    }

    void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
        System.out.println("Attendance: " + getAttendancePercentage() + "%");
    }
}

// Teacher Class
class Teacher extends Person {
    Teacher(String id, String name) {
        super(id, name);
    }

    @Override
    void displayRole() {
        System.out.println("Role: Teacher");
    }
}

// Attendance Manager
class AttendanceManager {
    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
    }

    Student findStudent(String id) {
        for (Student s : students) {
            if (s.id.equals(id)) return s;
        }
        return null;
    }

    void showAllStudents() {
        for (Student s : students) {
            s.displayDetails();
            System.out.println("----------------");
        }
    }

    void showLowAttendance() {
        int noLowAttendance = 0;

        for (Student s : students) {
            if (s.getAttendancePercentage() < 75) {
                s.displayDetails();
                System.out.println("Low Attendance!");
                System.out.println("----------------");
                noLowAttendance++;
            }
        }

        if (noLowAttendance == 0) {
            System.out.println("No Low Attendance");
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager();

        int no_of_class_taken=0;

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Mark Attendance (Bulk)");
            System.out.println("3. View All Students");
            System.out.println("4. Show Low Attendance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice;

            // Safe input for menu
            while (true) {
                try {
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid input! Enter a number: ");
                    sc.nextLine();
                }
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    manager.addStudent(new Student(id, name));
                    break;

                case 2:
                    no_of_class_taken++;

                    System.out.println("Marking attendance for class " + no_of_class_taken);

                    System.out.print("Enter Student IDs (space-separated, present students): ");
                    String line = sc.nextLine();

                    String[] ids = line.split(" ");
                    ArrayList<String> presentIds = new ArrayList<>();

                    // Store entered IDs
                    for (String idInput : ids) {
                        presentIds.add(idInput);
                    }

                    int presentCount = 0;

                    // Loop through ALL students
                    for (Student s : manager.students) {
                        if (presentIds.contains(s.id)) {
                            s.markAttendance(true);
                            presentCount++;
                        } else {
                            s.markAttendance(false);
                        }
                    }

                    System.out.println("Attendance marked.");
                    System.out.println("Present students: " + presentCount);
                    System.out.println("Absent students: " + (manager.students.size() - presentCount));

                    break;

                case 3:
                    manager.showAllStudents();
                    break;

                case 4:
                    manager.showLowAttendance();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}