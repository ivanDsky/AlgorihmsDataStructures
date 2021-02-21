package practice.pw6;

import utils.geometry.Point;
import utils.geometry.Vector;

public class Rectangle extends Quadrangle{
    private Rectangle(Point A, Point B, Point C, Point D) {
        super(A, B, C, D);
    }

    public Rectangle(Point A, Point B, Point C) {
        Vector bc = new Vector(B, C);
        Point D = new Point(A.x + bc.x, A.y + bc.y);
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        ab = Point.distance(A,B);
        this.bc = Point.distance(B,C);
        cd = Point.distance(C,D);
        ad = Point.distance(A,D);
    }

    @Override
    public double getPerimeter() {
        perimeter = 2 * (ab + bc);
        return perimeter;
    }

    @Override
    public double getArea() {
        area = ab * bc;
        return area;
    }

    @Override
    public Point getCenter() {
        center = new Point((A.x + D.x) / 2,(A.y + B.y) / 2);
        return center;
    }

    @Override
    public String toString() {
        return "Rectangle : area  = " + getArea() + ", perimeter = " + getPerimeter() + ", center of rectangle = " + getCenter();
    }
}
