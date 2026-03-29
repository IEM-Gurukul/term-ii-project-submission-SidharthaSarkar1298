# PCCCS495 – Term II Project

## Project Title

Student Attendance Management System

---

## Problem Statement (max 150 words)

Managing student attendance manually is time-consuming and error-prone. Teachers often face difficulties in tracking attendance records, calculating attendance percentages, and identifying students with low attendance. This project aims to develop a simple Student Attendance Management System that automates these tasks. The system allows adding students, marking attendance for multiple students at once, calculating attendance percentages, and identifying students with attendance below 75%. It reduces manual effort and ensures accurate record keeping.

---

## Target User

- Teachers
- Educational Institutions (Schools/Colleges)

---

## Core Features

- Add student details (ID and Name)
- Mark attendance for multiple students in one step
- Automatic marking of absent students
- View all student attendance records
- Identify students with attendance below 75%

---

## OOP Concepts Used

- **Abstraction:**  
  The `Person` class is an abstract class that defines common attributes like id and name.

- **Inheritance:**  
  `Student` and `Teacher` classes inherit from the `Person` class.

- **Polymorphism:**  
  Method `displayRole()` is overridden in `Student` and `Teacher` classes.

- **Exception Handling:**  
  Used try-catch blocks to handle invalid user input in menu selection.

- **Collections / Threads:**  
  Used `ArrayList` to store and manage student data.

---

## Proposed Architecture Description

The system follows a simple modular design. The `Person` class acts as a base class for `Student` and `Teacher`. The `AttendanceManager` class handles all core operations such as adding students, marking attendance, and displaying reports. The `Main` class provides a menu-driven interface for user interaction. Data is stored using Java Collections (ArrayList), making the system lightweight and easy to manage.

---

## How to Run

1. Open terminal in the project folder  
2. Compile the program:
   ```
   javac Main.java
   ```
3. Run the program:
   ```
   java Main
   ```

---

## Git Discipline Notes

Minimum 10 meaningful commits required.
