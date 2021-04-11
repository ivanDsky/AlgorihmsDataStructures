package practice.pw11;

public class Student {
    private String fullName;
    private double averageGrade;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public Student(){
        this("No name",0.0);
    }

    public Student(String fullName, double averageGrade) {
        this.fullName = fullName;
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return fullName + " has average grade : " + averageGrade;
    }
}
