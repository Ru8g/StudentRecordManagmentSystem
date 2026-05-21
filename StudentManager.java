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
}