package practice.pw1;

public class StudentsGrades {
    private int[] grades;
    private int index;

    StudentsGrades(){};

    StudentsGrades(int size){
        grades = new int[size];
        index = 0;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public boolean addGrade(int grade){
        if(grade < 0 || grade > 100)return false;
        grades[index++]= grade;
        return true;
    }

    public int maxGrade(){
        if(index == 0)return -1;
        int ret = -1;
        for(int i = 0;i < index; ++i){
            ret = Math.max(ret,grades[i]);
        }
        return ret;
    }

    public int minGrade(){
        if(index == 0)return -1;
        int ret = 101;
        for(int i = 0;i < index; ++i){
            ret = Math.min(ret,grades[i]);
        }
        return ret;
    }

    public float averageGrade(){
        if(index == 0)return -1;
        int sum = 0;
        for(int i = 0;i < index; ++i){
            sum += grades[i];
        }
        return sum / (float)index;
    }

    public int studentsWithGreaterAverage(){
        return studentsGradeLR((int)Math.floor(averageGrade()),101);
    }

    public int studentsWithLowerAverage(){
        return studentsGradeLR(-1,(int)Math.ceil(averageGrade()));
    }

    public int studentsWithA(){
        return studentsGradeLR(90,101);
    }

    public int studentsWithBC(){
        return studentsGradeLR(70,91);
    }

    public int studentsWithDE(){
        return studentsGradeLR(59,71);
    }

    public int studentsWithF(){
        return studentsGradeLR(-1,60);
    }

    @Override
    public String toString() {
        String ret = "Students grades : ";
        for(int i = 0; i < index; ++i){
            if(i != index - 1)ret = ret + grades[i] +", ";
            else ret = ret + grades[i];
        }
        return ret;
    }

    public int studentsGradeLR(int l, int r){
        int cnt = 0;
        for(int i = 0;i < index; ++i){
            if(l < grades[i] && grades[i] < r)cnt++;
        }
        return cnt;
    }
}
