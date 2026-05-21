public class GraduateStudent extends Student {

    private String researchTopic;
    private String supervisorName;

    public GraduateStudent(int id, String name, String department, double gpa, int year, String researchTopic, String supervisorName) {
        super(id, name, department, gpa, year);
        this.researchTopic = researchTopic;
        this.supervisorName = supervisorName;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }
public String getSupervisorName() {
return supervisorName;
}

public void setSupervisorName(String supervisorName) {
this.supervisorName = supervisorName;
}
    @Override
    public String toString() {
        return super.toString() + "," + researchTopic + "," + supervisorName;
    }
}
