package labs.lab1;

public class SortTeacher {
    public static void sortByName(Teacher[] teachers){
        mergeSort(0,teachers.length - 1,teachers,new ComparatorTeacherName());
    }

    private static void mergeSort(int l, int r, Teacher[] teachers, ComparatorTeacher comparator){
        if(l >= r)return;
        int m = (l + r) >> 1;
        mergeSort(l,m,teachers,comparator);
        mergeSort(m + 1,r,teachers,comparator);
        int leftID = l,rightID = m + 1,newID = 0;
        Teacher[] copyArray = new Teacher[r - l + 1];
        while(leftID <= m || rightID <= r){
            if(leftID > m)copyArray[newID++] = teachers[rightID++];else
            if(rightID > r)copyArray[newID++] = teachers[leftID++];else

            if(comparator.compare(teachers[leftID],teachers[rightID])){
                copyArray[newID++] = teachers[leftID++];
            }else{
                copyArray[newID++] = teachers[rightID++];
            }
        }
        for(int i = l;i <= r; ++i){
            teachers[i] = copyArray[i - l];
        }
    }
}

abstract class ComparatorTeacher{
    public boolean compare(Teacher a,Teacher b){
        return false;
    }
}

class ComparatorTeacherName extends ComparatorTeacher{
    public boolean compare(Teacher a,Teacher b){
        return a.getName().compareToIgnoreCase(b.getName()) < 0;
    }
}

