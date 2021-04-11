package practice.pw11;

import java.util.ArrayList;
import java.util.Optional;

public class StudentGroup {
    private ArrayList<Student> students = new ArrayList<>();

    public StudentGroup() {
    }

    public StudentGroup(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student st) {
        students.add(st);
    }

    public StudentGroup getSortedGroup(StudentSort sort, boolean increased) {
        ArrayList<Student> sortStudents = new ArrayList<>(students);
        sortStudents.sort((stA, stB) -> increased ? sort.sort(stA, stB) : sort.sort(stB, stA));
        return new StudentGroup(sortStudents);
    }

    public StudentGroup getMinMaxStudent(boolean isMax) {
        ArrayList<Student> bestStudents = new ArrayList<>();
        if (students.isEmpty()) return new StudentGroup(bestStudents);
        double val = students.get(0).getAverageGrade();

        for (Student s : students) {
            if (isMax) val = Math.max(val, s.getAverageGrade());
            else val = Math.min(val, s.getAverageGrade());
        }

        for (Student s : students) {
            if (s.getAverageGrade() == val) bestStudents.add(s);
        }

        return new StudentGroup(bestStudents);
    }

    @Override
    public String toString() {
        String ret = "Students : \n";
        for (Student s : students) {
            ret += "\t" + s.toString() + "\n";
        }
        return ret;
    }
}

abstract class StudentSort {
    abstract int sort(Student a, Student b);

    public static class SortAlphabetically extends StudentSort {

        @Override
        public int sort(Student a, Student b) {
            int sortVal = a.getFullName().compareToIgnoreCase(b.getFullName());
            if (sortVal == 0) {
                if (a.getAverageGrade() < b.getAverageGrade()) return -1;
                else if (a.getAverageGrade() == b.getAverageGrade()) return 0;
                else
                    return 1;
            } else return sortVal;
        }
    }

    public static class SortByGrade extends StudentSort {
        @Override
        public int sort(Student a, Student b) {
            if (a.getAverageGrade() == b.getAverageGrade()) {
                return a.getFullName().compareToIgnoreCase(b.getFullName());
            } else return a.getAverageGrade() < b.getAverageGrade() ? -1 : 1;
        }
    }
}