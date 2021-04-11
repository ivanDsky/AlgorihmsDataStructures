package practice.pw11;

import utils.Util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Tester {
    public static StudentGroup[] tests = {
            new StudentGroup(),
            new StudentGroup(new ArrayList<>(Arrays.asList(
                    new Student("Gamlet",80.0),
                    new Student("Kevin",10.0),
                    new Student("Rose",80.0),
                    new Student("James",15.0)
            ))),
            new StudentGroup(new ArrayList<>(Arrays.asList(
                    new Student("Gamlet",10.0),
                    new Student("Kevin",10.0),
                    new Student("Rose",80.0),
                    new Student("James",15.0)
            ))),
            new StudentGroup(new ArrayList<>(Arrays.asList(
                    new Student("Gamlet",80.0),
                    new Student("John",10.0),
                    new Student("Kevin",12.0),
                    new Student("Michael",12.0),
                    new Student("Rose",80.0),
                    new Student("Erich",80.0),
                    new Student("James",10.0)
            )))
    };
    public static void main(String[] args) {
        System.out.println(tests[0]);
        System.out.println(tests[0].getSortedGroup(new StudentSort.SortAlphabetically(),true));

        Util.dashLine();
        System.out.println(tests[1]);
        System.out.println(tests[1].getMinMaxStudent(false));
        System.out.println(tests[1].getMinMaxStudent(true));

        Util.dashLine();
        System.out.println(tests[2]);
        System.out.println(tests[2].getMinMaxStudent(false));
        System.out.println(tests[2].getMinMaxStudent(true));

        Util.dashLine();
        System.out.println(tests[3]);
        System.out.println(tests[3].getMinMaxStudent(false));
        System.out.println(tests[3].getMinMaxStudent(true));
        System.out.println(tests[3].getSortedGroup(new StudentSort.SortAlphabetically(),true));
        System.out.println(tests[3].getSortedGroup(new StudentSort.SortAlphabetically(),false));
        System.out.println(tests[3].getSortedGroup(new StudentSort.SortByGrade(),true));
        System.out.println(tests[3].getSortedGroup(new StudentSort.SortByGrade(),false));
    }
}
