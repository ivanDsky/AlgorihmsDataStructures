package practice.pw1;

import utils.DataInput;
import utils.Util;

import static utils.Util.toExit;

public class Tester {
    public static int MAX_SIZE = 1000;

    public static void main(String[] args) {
        System.out.println("This program read students grades and compute different statistic information.");
        do {
            StudentsGrades studentsGrades = new StudentsGrades(MAX_SIZE);
            System.out.println("Enter students grades(-1 will stop read cycle)");
            for (int i = 0; i < MAX_SIZE; ++i) {
                int grade;
                while(true){
                    grade = DataInput.getInt("Enter grade of " + (i + 1) + " student : ");
                    if (grade == -1) break;
                    if(studentsGrades.addGrade(grade))break;
                    else {
                        System.out.println("Student grade should be in range 0 to 100 inclusive");
                    }
                }
                if(grade == -1)break;
            }
            Util.dashLine();
            if(studentsGrades.maxGrade() == -1)System.out.println("No max grade, because no students");
            else System.out.println("Max grade is : " + studentsGrades.maxGrade());
            if(studentsGrades.minGrade() == -1)System.out.println("No min grade, because no students");
            else System.out.println("Min grade is : " + studentsGrades.minGrade());
            if(studentsGrades.averageGrade() == -1)System.out.println("No average grade, because no students");
            else System.out.println("Average grade is : " + studentsGrades.averageGrade());
            System.out.println("Number of students grade greater than average: " + studentsGrades.studentsWithGreaterAverage());
            System.out.println("Number of students grade lower than average: " + studentsGrades.studentsWithLowerAverage());
            System.out.println("Number of students with excellent grade : " + studentsGrades.studentsWithA());
            System.out.println("Number of students with good grade : " + studentsGrades.studentsWithBC());
            System.out.println("Number of students with ok grade : " + studentsGrades.studentsWithDE());
            System.out.println("Number of students with bad grade : " + studentsGrades.studentsWithF());
            System.out.println(studentsGrades);
            Util.dashLine();
        }while(!toExit());
    }


}
