package utils.geometry;

import utils.DataInput;

public class Vector {
    public double x,y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector(Point A, Point B){
        this.x = B.x - A.x;
        this.y = B.y - A.y;
    }

    public double magnitude(){
        return Math.sqrt(sqrMagnitude());
    }

    public double sqrMagnitude(){
        return x * x + y * y;
    }

    public Vector add(Vector b){
        return new Vector(x + b.x,y + b.y);
    }

    public static double area(Vector a, Vector b){
        return (a.x * b.y - b.x * a.y);
    }

    public static Vector readVector(String s){
        System.out.println(s);
        double x,y;
        x = DataInput.getDouble("Enter x : ");
        y = DataInput.getDouble("Enter y : ");
        return new Vector(x,y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
