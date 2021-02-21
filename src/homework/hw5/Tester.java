package homework.hw5;

import utils.DataInput;
import utils.Util;
import utils.geometry.Vector3D;

public class Tester {
    public static void main(String[] args) {
        System.out.println("This program can operate with parallelepiped");//Enter program description
        while(true) {
            System.out.println("Create parallelepiped by : \n" +
                    "1 - one point N\n" +
                    "2 - point A,B,C, length of AA1 and angle between AA1 and (ABC)\n"+
                    "3 - point A, length of AB,AD angle between AB and AD, length of AA1 and angle between AA1 and (ABC)\n" +
                    "4 - point A, vector a,b,c\n" +
                    "5 - point A,B,C,A1\n" +
                    "6 - exit");
            int type = 0;
            while (true) {
                type = DataInput.getInt("Enter type : ");
                if (type < 1 || type > 6) {
                    System.out.println("Type can be in rage 1 to 6");
                    continue;
                }
                break;
            }
            if (type == 1) {
                Point N = Point.readPoint("Enter point N");
                System.out.println(new Parallelepiped(N));
            }
            if (type == 2) {
                Point A, B, C;
                A = Point.readPoint("Enter point A");
                B = Point.readPoint("Enter point B");
                C = Point.readPoint("Enter point C");
                double AA1, alpha;
                AA1 = DataInput.getDouble("Enter A_A1 : ");
                alpha = DataInput.getDouble("Enter alpha in degrees : ");
                System.out.println(new Parallelepiped(A, B, C, AA1, alpha));
            }

            if (type == 3) {
                Point A;
                double AB, AD, theta, AA1, alpha;
                A = Point.readPoint("Enter point A");
                AB = DataInput.getDouble("Enter AB : ");
                AD = DataInput.getDouble("Enter AD : ");
                theta = DataInput.getDouble("Enter theta in degrees : ");
                AA1 = DataInput.getDouble("Enter A_A1 : ");
                alpha = DataInput.getDouble("Enter alpha in degrees : ");
                System.out.println(new Parallelepiped(A,AB,AD,theta, AA1, alpha));
            }

            if(type == 4){
                Point A;
                Vector3D a, b, c;
                A = Point.readPoint("Enter point A");
                a = Vector3D.readVector("Enter vector a");
                b = Vector3D.readVector("Enter vector b");
                c = Vector3D.readVector("Enter vector c");
                System.out.println(new Parallelepiped(A,a,b,c));
            }

            if(type == 5){
                Point A,B,C,A1;
                A = Point.readPoint("Enter point A");
                B = Point.readPoint("Enter point B");
                C = Point.readPoint("Enter point C");
                A1 = Point.readPoint("Enter point A1");
                System.out.println(new Parallelepiped(A,B,C,A1));
            }

            if(type == 6){
                break;
            }
            Util.dashLine();
        }
    }
}