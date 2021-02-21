package practice.pw6;

import utils.geometry.Point;

public class Triangle extends Figure{
    private Point A,B,C;
    private double ab,bc,ac;

    public Triangle(Point A,Point B,Point C){
        this.A = A;
        this.B = B;
        this.C = C;
        ab = Point.distance(A,B);
        bc = Point.distance(B,C);
        ac = Point.distance(A,C);
    }

    @Override
    public double getPerimeter() {
        perimeter = ab + bc + ac;
        return perimeter;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        area = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        return area;
    }

    @Override
    public Point getCenter() {
        center.x = (A.x + B.x + C.x) / 3;
        center.y = (A.y + B.y + C.y) / 3;
        return center;
    }

    @Override
    public String toString() {
        return "Triangle : area  = " + getArea() + ", perimeter = " + getPerimeter() + ", center of triangle = " + getCenter();
    }
}
