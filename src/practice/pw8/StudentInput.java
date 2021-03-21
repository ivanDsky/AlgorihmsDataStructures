package practice.pw8;

import java.util.Locale;
import java.util.Scanner;

public class StudentInput {

    public Student readStudent() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ROOT);
        System.out.println("Enter student");
        String name = "", address = "";
        double grade = -1;

        System.out.print("Enter fullname : ");
        if (scanner.hasNextLine()) {
            name = scanner.nextLine();
        }

        System.out.print("Enter address : ");
        if (scanner.hasNextLine()) {
            address = scanner.nextLine();
        }

        while (scanner.hasNextDouble()) {
            System.out.print("Enter average grade : ");
            grade = scanner.nextDouble();
            if(grade <= 100 && grade >= 0)break;
            System.out.println("Grade should be in range 0 to 100 inclusive");
        }

        return new Student(name,address,grade);
    }
}
