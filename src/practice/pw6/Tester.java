package practice.pw6;

import utils.DataInput;
import utils.Util;
import utils.geometry.Point;
import utils.geometry.Vector3D;

public class Tester {
    public static void main(String[] args) {
        System.out.println("This program operates with figures");//Enter program description
        while(true) {
            System.out.println("Create figure : \n" +
                    "1 - triangle\n" +
                    "2 - circle\n"+
                    "3 - quadrangle\n" +
                    "4 - rectangle\n" +
                    "5 - exit");
            int type = 0;
            while (true) {
                type = DataInput.getInt("Enter type : ");
                if (type < 1 || type > 5) {
                    System.out.println("Type can be in rage 1 to 5");
                    continue;
                }
                break;
            }
            Figure figure = null;
            if (type == 1) {
                Point A, B, C;
                A = Point.readPoint("Enter point A");
                B = Point.readPoint("Enter point B");
                C = Point.readPoint("Enter point C");

                figure = new Triangle(A,B,C);
            }
            if (type == 2) {
                Point A;
                double radius;
                A = Point.readPoint("Enter point A");
                radius = DataInput.getDouble("Enter radius : ");

                figure = new Circle(A,radius);
            }

            if (type == 3) {
                Point A, B, C, D;
                A = Point.readPoint("Enter point A");
                B = Point.readPoint("Enter point B");
                C = Point.readPoint("Enter point C");
                D = Point.readPoint("Enter point D");

                figure = new Quadrangle(A,B,C,D);
            }

            if(type == 4){
                Point A, B, C;
                A = B = C = null;
                A = Point.readPoint("Enter point A");
                while(true){
                    B = Point.readPoint("Enter point B");
                    if(A.x != B.x){
                        System.out.println("A and B must have equal x coordinates");
                        continue;
                    }
                    break;
                }
                while(true){
                    C = Point.readPoint("Enter point C");
                    if(B.y != C.y){
                        System.out.println("B and C must have equal y coordinates");
                        continue;
                    }
                    break;
                }

                figure = new Rectangle(A,B,C);
            }

            if(type == 5){
                break;
            }

            System.out.println(figure);
            Util.dashLine();
        }
    }
}