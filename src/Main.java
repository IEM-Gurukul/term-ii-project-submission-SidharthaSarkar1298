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

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Mark Attendance");
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
                    System.out.print("Enter Student ID: ");
                    String sid = sc.nextLine();
                    Student s = manager.findStudent(sid);

                    if (s != null) {
                        System.out.print("Present? (true/false): ");

                        boolean present;

                        // Safe input for boolean
                        while (true) {
                            String input = sc.nextLine().toLowerCase();

                            if (input.equals("true") || input.equals("false")) {
                                present = Boolean.parseBoolean(input);
                                break;
                            } else {
                                System.out.print("Enter only true or false: ");
                            }
                        }

                        s.markAttendance(present);
                    } else {
                        System.out.println("Student not found!");
                    }
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