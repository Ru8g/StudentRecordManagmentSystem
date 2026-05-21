import java.io.*;
import java.util.ArrayList;

public class StudentManager {

private ArrayList<Student>students =new ArrayList<>();
private final String FILE_NAME="students_data.txt";

public void addStudent(Student student){
    students.add(student);
    System.out.println("Student added succecfully!");
}
public void updateStudent(int id,String newName,String newDept,double newGpa,int newYear){
    for
    (Student s : students){
        if(s.getId()==id){
            s.setName(newName);
            s.setDepartment(newDept);
            s.setGpa(newGpa);
            s.setYear(newYear);
            System.out.println("the Student Data have been updated succesfully");
            return;
        }
    }
    System.out.println("Student not found");
}
public void deleteStudent(int id){
    for (int i =0;i<students.size();i++){
        if(students.get(i).getId()==id){
            students.remove(i);
            System.out.println("Student data have been deleted Succesfully.");
            return;
        }
    }
    System.out.println("Student not found");
}


public void loadFromFile(){
    File file= new File(FILE_NAME);
    if(!file.exists()){
        return;
     }
try (BufferedReader reader =new BufferedReader(new FileReader(file))){
    String line;
    students.clear();

    while ((line=reader.readLine())!=null){
        String[] data =line.split(",");

        if(data.length==5){
            int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String dept = data[2];
                    double gpa = Double.parseDouble(data[3]);
                    int year = Integer.parseInt(data[4]);

                    students.add(new Student(id, name, dept, gpa, year));
        }
    }
}catch (Exception e) {
    System.out.println("an Error has accured during file reading"+e.getMessage());
}
    
}
public ArrayList<Student> getStudents() {
    return students;
}

public void saveToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
        for (Student s : students) {
            writer.write(s.toString());
            writer.newLine();
        }
    } catch (Exception e) {
        System.out.println("An error occurred during file writing: " + e.getMessage());
    }
}
public void printAllStudentsReports() {
    System.out.println("\n====================================== Students Report ======================================");
    
    if (students.isEmpty()) {
        System.out.println(" No students found in the system.");
    } else {
        for (Student s : students) {
            System.out.print("ID: " + s.getId() + " | Name: " + s.getName() + 
                             " | Dept: " + s.getDepartment() + " | GPA: " + s.getGpa() + 
                             " | Year: " + s.getYear());
            
            if (s instanceof GraduateStudent) {
                GraduateStudent gs = (GraduateStudent) s;
                System.out.print(" | Topic: " + gs.getResearchTopic() + " | Supervisor: " + gs.getSupervisorName());
            }
            System.out.println(); 
        }
    }
    System.out.println("=============================================================================================\n");
}
}