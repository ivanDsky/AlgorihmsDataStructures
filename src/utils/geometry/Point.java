package utils.geometry;

import utils.DataInput;

public class Point {
    public double x, y;

    public Point() {
        x = y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point readPoint(String s) {
        System.out.println(s);
        double x, y;
        x = DataInput.getDouble("Enter x : ");
        y = DataInput.getDouble("Enter y : ");
        return new Point(x, y);
    }

    public static double distance(Point a,Point b){
        return Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
