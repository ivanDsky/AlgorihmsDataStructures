package homework.hw5;

import utils.DataInput;

public class Point {
    public double x,y,z;

    Point(){
        x = y = z = 0;
    }

    Point(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Point(int x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Point readPoint(String s){
        System.out.println(s);
        double x,y,z;
        x = DataInput.getDouble("Enter x : ");
        y = DataInput.getDouble("Enter y : ");
        z = DataInput.getDouble("Enter z : ");
        return new Point(x,y,z);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
