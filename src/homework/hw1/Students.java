package homework.hw1;

public class Students {
    private Student[] student;
    private int index;
    Students(int size){
        student = new Student[size];
        index = 0;
    }

    public Student[] getStudents() {
        return student;
    }

    public void setStudents(Student[] students) {
        this.student = students;
    }

    public void addStudent(Student addStudent){
        student[index++] = addStudent;
    }

    public String getStudentsByLetter(char letter){
        String ret = "";
        for(int i = 0;i < index; ++i){
            if(student[i].getFullName().charAt(0) == letter){
                ret += "•" + student[i] + "\n";
            }
        }
        if(ret.equals(""))return "No students with fullname on '" + letter + "' letter";
        ret = ret.substring(0,ret.length() - 2);
        ret = "Students with first letter '" + letter + "' : \n" + ret;
        return ret;
    }

    @Override
    public String toString() {
        String ret = "";
        for(int i = 0;i < index; ++i){
            ret += "•" + student[i] + (i == index - 1 ? "" : "\n");
        }
        if(ret.equals(""))return "No students added";
        return ret;
    }
}
