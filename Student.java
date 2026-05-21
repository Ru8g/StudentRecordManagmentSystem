public class Student {

    private String name;
    private int id;
    private String department;
    private double gpa;
    private int year;

public Student(int id,String name,String department,double gpa,int year){
    this.name=name;
    this.id=id;
    this.department=department;
    this.gpa=gpa;
    this.year=year;  
}
public int getId(){   return  id;     }

public String getName(){   return name;       }
public void setName(String name){ this.name=name;}

public String getDepartment(){   return  department;     }
public void setDepartment(String department){this.department=department;}


public double getGpa(){   return   gpa;    }
public void setGpa(double gpa){this.gpa=gpa;}


public int getYear(){   return   year;    }
public void setYear(int year){this.year=year;}

public String toString(){
    return id+","+name+","+department+","+gpa+","+year;
}

}