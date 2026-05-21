import java.util.Scanner;

public class Main {

public static void main(String[] args) {

Scanner input = new Scanner(System.in);
StudentManager manager = new StudentManager();

manager.loadFromFile();

Thread autoSaveThread = new Thread(() -> {
while (true) {
try {
Thread.sleep(60000);
manager.saveToFile();
} catch (InterruptedException e) {
break;
}
}
});
autoSaveThread.setDaemon(true);
autoSaveThread.start();

boolean exit = false;
while (!exit) {
System.out.println("\n--- SRMS Menu ---");
System.out.println("1. Add Student");
System.out.println("2. Add Graduate Student");
System.out.println("3. Print All Students Reports");
System.out.println("4. Update Student");
System.out.println("5. Delete Student");
System.out.println("6. Exit & Save");
System.out.print("Enter your choice: ");

int choice = input.nextInt();
input.nextLine();

if (choice == 1) {
System.out.print("ID: ");
int id = input.nextInt();
input.nextLine();
System.out.print("Name: ");
String name = input.nextLine();
System.out.print("Department: ");
String dept = input.nextLine();
System.out.print("GPA: ");
double gpa = input.nextDouble();
System.out.print("Year: ");
int year = input.nextInt();

manager.addStudent(new Student(id, name, dept, gpa, year));
System.out.println("Student Added.");

} else if (choice == 2) {
System.out.print("ID: ");
int id = input.nextInt();
input.nextLine();
System.out.print("Name: ");
String name = input.nextLine();
System.out.print("Department: ");
String dept = input.nextLine();
System.out.print("GPA: ");
double gpa = input.nextDouble();
System.out.print("Year: ");
int year = input.nextInt();
input.nextLine();
System.out.print("Research Topic: ");
String topic = input.nextLine();
System.out.print("Supervisor Name: ");
String supervisor = input.nextLine();

manager.addStudent(new GraduateStudent(id, name, dept, gpa, year, topic, supervisor));
System.out.println("Graduate Student Added.");

} else if (choice == 3) {
    manager.printAllStudentsReports();

} else if (choice == 4) {
    System.out.print("Enter Student ID to update: ");
    int id = input.nextInt();
    input.nextLine();

    System.out.print("Enter new Name: ");
    String newName = input.nextLine();

    System.out.print("Enter new Department: ");
    String newDept = input.nextLine();

    System.out.print("Enter new GPA: ");
    double newGpa = input.nextDouble();

    System.out.print("Enter new Year: ");
    int newYear = input.nextInt();
    input.nextLine();

    manager.updateStudent(id, newName, newDept, newGpa, newYear);
} 
else if (choice == 5) {
    System.out.print("Enter Student ID to delete: ");
    int id = input.nextInt();
    input.nextLine();
    
    manager.deleteStudent(id);
} 
else if (choice == 6) {
    System.out.println("Saving data and exiting. Goodbye!");
    manager.saveToFile();
    break;
}
}

input.close();
}
}
