package practice.pw8;

public class Student {
    private String fullName;
    private String address;
    private double averageGrade;

    public Student() {
        fullName = "no name";
        address = "no address";
        averageGrade = -1;
    }

    public Student(String fullName, String address, double averageGrade) {
        this.fullName = fullName;
        this.address = address;
        this.averageGrade = averageGrade;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "%s. It lives by %s. Its average grade is %f.".formatted(getFullName(),getAddress(),getAverageGrade());
    }
}
