package practice.pw8;

public class StudentGroup {
    private Student[] students;
    private int index;

    public StudentGroup() {
        students = new Student[500];
    }

    public StudentGroup(int size) {
        students = new Student[size];
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
        index = students.length;
    }

    public void addStudent(Student student){
        students[index++] = student;
    }

    public StudentGroup bestAverage(boolean isMax){
        double average = -1;
        for(int i = 0;i < index; ++i){
            if(i == 0)average = students[i].getAverageGrade();
            else if(isMax)average = Math.max(average,students[i].getAverageGrade());
            else average = Math.min(average,students[i].getAverageGrade());
        }
        StudentGroup ret = new StudentGroup();
        for(int i = 0;i < index; ++i){
            if(students[i].getAverageGrade() == average)ret.addStudent(students[i]);
        }
        return ret;
    }

    @Override
    public String toString() {
        String ret = "";
        for(int i = 0;i < index; ++i){
            ret += "•" + students[i] + (i == index - 1 ? "" : "\n");
        }
        if(ret.equals(""))return "no students";
        return "\n"+ret;
    }
}
