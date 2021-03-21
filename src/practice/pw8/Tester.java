package practice.pw8;

import utils.DataInput;

public class Tester {
    public static void main(String[] args) {
        int cnt = DataInput.getInt("Enter number of students that will be entered : ");
        StudentGroup group = new StudentGroup(cnt);
        StudentInput input = new StudentInput();
        for(int i = 0;i < cnt; ++i){
            group.addStudent(input.readStudent());
        }
        System.out.println("Students " + group);
        System.out.println("Maximal average have " + group.bestAverage(true));
        System.out.println("Minimal average have " + group.bestAverage(false));
    }
}
