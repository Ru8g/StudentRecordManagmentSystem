# StudentRecordManagmentSystem
Student Record Management System (SRMS)

A simple Java application designed to manage student records efficiently.

Features:

Manage Records: Add, update, and delete student information.
Data Persistence: Save and load student data from a text file.
Detailed Reports: Generate and sort reports based on GPA, Department, or Year.
Auto-saving: Background multithreading process to save data automatically.

Technologies Used:

Java
Encapsulation: Private attributes with public getters and setters in Student class.
Composition: StudentManager containing an ArrayList of Students.
Inheritance: GraduateStudent class extending the core Student class.
Polymorphism: Overriding the toString method in GraduateStudent.
File I/O and Exception Handling: Safe data streaming using try-catch blocks.
Multithreading: Dynamic background task execution.

How to Run:

1. Open the terminal or command prompt in the project folder.
2. Compile the code using the command: javac *.java
3. Run the program using the command: java Main

Team Members:

[Reema Alashrah] : Student Management & File I/O Operations.

[joud Alhajjaj] : Reporting, Menus & Multithreading.