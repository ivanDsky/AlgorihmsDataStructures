package homework.hw1;

import utils.DataInput;
import utils.Util;

public class Tester {
    private final static int MAX_SIZE = 1000;

    public static void main(String[] args) {
        System.out.println("This program read students info and shows only students that starts on input letter.");
        do {
            Students students = new Students(MAX_SIZE);
            System.out.println("Enter students(empty name will stop read cycle)");
            for (int i = 0; i < MAX_SIZE; ++i) {
                String fullName = DataInput.getString("Enter student fullname : ");
                if(fullName.equals(""))break;
                int grade;
                while(true){
                    grade = DataInput.getInt("Enter " + fullName + " grade : ");
                    if(0 <= grade && grade <= 100)break;
                    else {
                        System.out.println("Student grade should be in range 0 to 100 inclusive");
                    }
                }
                boolean mood;
                while(true){
                    String sMood = DataInput.getString("Enter " + fullName + " mood[ ')' if happy,'(' if sad] : ");
                    if(sMood.equals("(") || sMood.equals(")")){
                        mood = sMood.equals(")");
                        break;
                    }
                    else {
                        System.out.println("Student mood should be '(' or ')' only");
                    }
                }
                students.addStudent(new Student(fullName, grade, mood));
                System.out.println(fullName + " added to group.");
            }
            Util.dashLine();
            System.out.println(students);
            Util.dashLine();
            System.out.println("Enter first letter of student fullname (no letter will stop read cycle, more than one letter will get only first)");
            while(true){
                String letter = DataInput.getString("Enter first letter : ");
                if(letter.equals(""))break;
                char let = letter.charAt(0);
                System.out.println(students.getStudentsByLetter(let));
                Util.dashLine();
            }
        }while(!Util.toExit());
    }
}
