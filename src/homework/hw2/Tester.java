package homework.hw2;

import utils.DataInput;
import utils.Util;

public class Tester {
    private final static int MAX_SIZE = 1000;

    public static void main(String[] args) {
//        StudentHandler studentHandler = new StudentHandler();
//        studentHandler.setStudents(new Student[]{
//                new Student("gsdgsgsd",15.4),
//                new Student("авыаыа",15.4),
//                new Student("gAss",14.9),
//                new Student("GdSf",100),
//                new Student("Gzsdfdsfdfds",80.4),
//                new Student("Авяыава",45.4),
//                new Student("фваыфа",45.4),
//                new Student("авыф",45.4),
//                new Student("авыаыа",15.4)
//        });
//        studentHandler.sort(false,false);
//        System.out.println(studentHandler);


        System.out.println("This program read students info and sort them by given parameters.");
        do {
            StudentHandler students = new StudentHandler(MAX_SIZE);
            System.out.println("Enter students(empty name will stop read cycle)");
            for (int i = 0; i < MAX_SIZE; ++i) {
                String fullName = DataInput.getString("Enter student fullname : ");
                if(fullName.equals(""))break;
                double grade;
                while(true){
                    grade = DataInput.getDouble("Enter " + fullName + " grade : ");
                    if(0 <= grade && grade <= 100)break;
                    else {
                        System.out.println("Student grade should be in range 0 to 100 inclusive");
                    }
                }
                students.addStudent(new Student(fullName, grade));
                System.out.println(fullName + " added to group.");
            }
            Util.dashLine();
            System.out.println("Students unsorted : \n" + students);
            Util.dashLine();
            System.out.println("Sorting...");
            do{
                boolean byName = DataInput.getBoolean("Sort by name? (true - name,false - average grade) : ");
                boolean increase = DataInput.getBoolean("Sort in increase order? (true - increase,false - decrease) : ");
                students.sort(byName,increase);
                System.out.println("Students sorted " + (byName ? "by name " : "by grade ") +
                        "in " + (increase ? "increase " : "decrease ") + "order : \n" + students);
            }while(!Util.toExit());
        }while(!Util.toExit());
    }
}
