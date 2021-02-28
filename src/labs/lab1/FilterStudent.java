package labs.lab1;

public class FilterStudent {
    public static Student[] getByLength(Student[] students,int length){
        length = Math.min(length, students.length);
        Student[] newStudents = new Student[length];
        for(int i = 0;i < length; ++i){
            if(students[i] == null)break;
            newStudents[i] = students[i];
        }
        return newStudents;
    }

    public static Student[] getByDepartment(Student[] students,Department department){
        Student[] newStudents = new Student[students.length];
        int len = 0;
        for(int i = 0;i < students.length; ++i){
            if(students[i] == null)break;
            if(students[i].getDepartment().equals(department))newStudents[len++] = students[i];
        }
        return getByLength(newStudents,len);
    }

    public static Student[] getByFaculty(Student[] students,Faculty faculty){
        Student[] newStudents = new Student[students.length];
        int len = 0;
        for(int i = 0;i < students.length; ++i){
            if(students[i] == null)break;
            if(students[i].getDepartment().getFaculty().equals(faculty))newStudents[len++] = students[i];
        }
        return getByLength(newStudents,len);
    }

    public static Student[] getByCourse(Student[] students,int course){
        Student[] newStudents = new Student[students.length];
        int len = 0;
        for(int i = 0;i < students.length; ++i){
            if(students[i] == null)break;
            if(students[i].getCourse() == course)newStudents[len++] = students[i];
        }
        return getByLength(newStudents,len);
    }
}
