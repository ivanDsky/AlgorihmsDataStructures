package homework.hw1;

public class Student {
    private String fullName;
    private int grade;
    private boolean goodMood;

    Student(){};

    Student(String fullName,int grade,boolean mood){
        this.fullName = fullName;
        this.grade = grade;
        this.goodMood = mood;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean getMood() {
        return goodMood;
    }

    public void setMood(boolean mood) {
        this.goodMood = mood;
    }

    @Override
    public String toString() {
        String ret = fullName + ". He/She has " + grade + " points. He/She is ";
        if(goodMood)ret += "happy.";
        else ret += "sad.";
        return ret;
    }
}
