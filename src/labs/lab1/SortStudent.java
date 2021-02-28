package labs.lab1;

public class SortStudent {
    public static void sortByCourseOnly(Student[] students){
        mergeSort(0,students.length - 1,students,new ComparatorStudentCourse());
    }

    public static void sortByName(Student[] students){
        mergeSort(0,students.length - 1,students,new ComparatorStudentName());
    }

    public static void sortByCourse(Student[] students){
        sortByName(students);
        sortByCourseOnly(students);
    }

    private static void mergeSort(int l, int r, Student[] students, ComparatorStudent comparator){
        if(l >= r)return;
        int m = (l + r) >> 1;
        mergeSort(l,m,students,comparator);
        mergeSort(m + 1,r,students,comparator);
        int leftID = l,rightID = m + 1,newID = 0;
        Student[] copyArray = new Student[r - l + 1];
        while(leftID <= m || rightID <= r){
            if(leftID > m)copyArray[newID++] = students[rightID++];else
            if(rightID > r)copyArray[newID++] = students[leftID++];else

            if(comparator.compare(students[leftID],students[rightID])){
                copyArray[newID++] = students[leftID++];
            }else{
                copyArray[newID++] = students[rightID++];
            }
        }
        for(int i = l;i <= r; ++i){
            students[i] = copyArray[i - l];
        }
    }
}

abstract class ComparatorStudent{
    public boolean compare(Student a,Student b){
        return false;
    }
}

class ComparatorStudentCourse extends ComparatorStudent{
    public boolean compare(Student a,Student b){
        return a.getCourse() < b.getCourse();
    }
}

class ComparatorStudentName extends ComparatorStudent{
    public boolean compare(Student a,Student b){
        return a.getName().compareToIgnoreCase(b.getName()) < 0;
    }
}


