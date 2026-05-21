public class GraduateStudent extends Student {

    private String researchTopic;

    public GraduateStudent(int id, String name, String department, double gpa, int year, String researchTopic) {
        super(id, name, department, gpa, year);
        this.researchTopic = researchTopic;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    @Override
    public String toString() {
        return super.toString() + "," + researchTopic;
    }
}
