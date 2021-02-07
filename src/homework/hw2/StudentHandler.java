package homework.hw2;

public class StudentHandler {
    private Student[] students;
    private int index;

    public StudentHandler() {
    }

    public StudentHandler(int size) {
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

    public void sort(boolean byName, boolean increaseOrder){
        this.byName = byName;
        this.increaseOrder = increaseOrder;
        mergeSort(0,index - 1);
    }

    private void mergeSort(int l,int r){
        if(l == r)return;
        int m = (l + r) >> 1;
        mergeSort(l,m);
        mergeSort(m + 1,r);
        int leftID = l,rightID = m + 1,newID = 0;
        Student[] copyArray = new Student[r - l + 1];
        while(leftID <= m || rightID <= r){
            if(leftID > m)copyArray[newID++] = students[rightID++];else
            if(rightID > r)copyArray[newID++] = students[leftID++];else

            if(isStudentALessB(students[leftID],students[rightID])){
                copyArray[newID++] = students[leftID++];
            }else{
                copyArray[newID++] = students[rightID++];
            }
        }
        for(int i = l;i <= r; ++i){
            students[i] = copyArray[i - l];
        }
    }

    private boolean byName;
    private boolean increaseOrder;

    private boolean isStudentALessB(Student a, Student b){
        if(byName){
            String aName = a.getName(),bName = b.getName();
            int len = Math.min(aName.length(),bName.length());
            for(int i = 0;i < len; ++i){
                char aC = aName.charAt(i),bC = bName.charAt(i);
                aC = Character.toLowerCase(aC);
                bC = Character.toLowerCase(bC);
                if(aC < bC)return increaseOrder;
                if(bC < aC)return !increaseOrder;
            }
            return increaseOrder;
        }else{
            return increaseOrder ? a.getAverage() < b.getAverage() : b.getAverage() < a.getAverage();
        }
    }

    @Override
    public String toString() {
        String ret = "";
        for(int i = 0;i < index; ++i){
            ret += "•" + students[i] + (i == index - 1 ? "" : "\n");
        }
        if(ret.equals(""))return "No students added";
        return ret;
    }
}
