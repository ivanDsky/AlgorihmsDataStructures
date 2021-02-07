package homework.hw4;

import utils.DataInput;
import utils.Util;

public class Tester {
    public static void main(String[] args) {
        System.out.println("This program operates with rectangles.");//Enter program description
        RectangleArray array = new RectangleArray();
        while(true){
            System.out.println("You can do this operations \n" +
                    "1 - add new rectangle do array\n" +
                    "2 - chose rectangle from array to operate with it\n" +
                    "3 - exit");
            int state = 0;
            while(true){
                state = DataInput.getInt("Enter state : ");
                if(state != 1 && state != 2 && state != 3){
                    System.out.println("State must be 1,2 or 3");
                    continue;
                }
                break;
            }
            if(state == 3)break;
            if(state == 1){
                Rectangle nw = getRectangle();
                array.addRectangle(nw);
                System.out.println(nw);
                System.out.println("It has been added to array");
            }
            else{
                if(array.getSize() == 0){
                    System.out.println("No rectangles in array");
                    continue;
                }
                System.out.println(array);
                Rectangle cur = getRectangleFromArray(array);

                System.out.println("Current rectangle : " + cur);
                System.out.println("1 - change rectangle coordinates\n" +
                        "2 - move rectangle by vector\n" +
                        "3 - check is point inside rectangle\n" +
                        "4 - get union of this rectangle and other from array\n" +
                        "5 - get intersection of this rectangle and other from array\n" +
                        "6 - back");
                state = 0;
                while(true){
                    state = DataInput.getInt("Enter state : ");
                    if(state < 1 || state > 5){
                        System.out.println("Incorrect state. It must be in range 1 to 5");
                        continue;
                    }
                    break;
                }

                if(state == 6)continue;

                if(state == 1){
                    System.out.println("Enter new coordinates");
                    double x1,x2,y1,y2;
                    x1 = DataInput.getDouble("Enter x1 : ");
                    y1 = DataInput.getDouble("Enter y1 : ");
                    x2 = DataInput.getDouble("Enter x2 : ");
                    y2 = DataInput.getDouble("Enter y2 : ");
                    cur.setCoordinates(x1,y1,x2,y2);
                    System.out.println("Rectangle has benn changed coordinates : " + cur);
                }

                if(state == 2){
                    System.out.println("Enter vector");
                    double x,y;
                    x = DataInput.getDouble("Enter x : ");
                    y = DataInput.getDouble("Enter y : ");
                    cur.move(x,y);
                    System.out.println("Rectangle has been moved : " + cur);
                }

                if(state == 3){
                    System.out.println("Enter point");
                    double x,y;
                    x = DataInput.getDouble("Enter x : ");
                    y = DataInput.getDouble("Enter y : ");
                    boolean inter = cur.isPointInside(x,y);
                    if(inter) System.out.println("Point (" + x + ", " + y + ") is inside rectangle");
                    else System.out.println("Point (" + x + ", " + y + ") isn't inside rectangle");
                }

                if(state == 4){
                    System.out.println("Choose rectangle unite with");
                    System.out.println(array);
                    Rectangle nw = getRectangleFromArray(array);
                    System.out.println("Union : " + cur.union(nw));
                }

                if(state == 5){
                    System.out.println("Choose rectangle intersect with");
                    System.out.println(array);
                    Rectangle nw = getRectangleFromArray(array);
                    System.out.println("Intersection : " + cur.intersection(nw));
                }

            }
        }
    }

    public static Rectangle getRectangleFromArray(RectangleArray array){
        int index = 0;
        while(true){
            index = DataInput.getInt("Enter index : ") - 1;
            if(array.getRectangle(index) == null){
                System.out.println("No rectangle with this index");
                continue;
            }
            break;
        }
        return array.getRectangle(index);
    }

    public static Rectangle getRectangle(){
        System.out.println("Enter rectangle");
        double x1,x2,y1,y2;
        x1 = DataInput.getDouble("Enter x1 : ");
        y1 = DataInput.getDouble("Enter y1 : ");
        x2 = DataInput.getDouble("Enter x2 : ");
        y2 = DataInput.getDouble("Enter y2 : ");

        return new Rectangle(x1,y1,x2,y2);
    }

}