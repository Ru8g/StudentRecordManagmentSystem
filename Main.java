import java.util.Scanner;

public class Main {

public static void main(String[] args) {

Scanner input = new Scanner(System.in);

StudentManager manager = new StudentManager();

manager.loadFromFile();

System.out.println("Student Record Management System");

}
}
