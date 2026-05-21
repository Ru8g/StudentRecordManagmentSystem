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
System.out.println("4. Exit & Save");
System.out.print("Choice: ");

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
System.out.println("\n--- Students Report ---");
for (Student s : manager.getStudents()) {
System.out.println(s.toString());
}

} else if (choice == 4) {
manager.saveToFile();
exit = true;
System.out.println("System Exited.");
} else {
System.out.println("Invalid Choice.");
}
}

input.close();
}
}
