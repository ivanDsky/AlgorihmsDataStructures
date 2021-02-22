package practice.pw6;

import utils.geometry.Point;
import utils.geometry.Vector;

public class Quadrangle extends Figure{
    protected Point A,B,C,D;
    protected double ab,bc,cd,ad;

    protected Quadrangle(){}

    public Quadrangle(Point A,Point B,Point C,Point D){
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        ab = Point.distance(A,B);
        bc = Point.distance(B,C);
        cd = Point.distance(C,D);
        ad = Point.distance(A,D);
    }

    @Override
    public double getPerimeter() {
        perimeter = ab + bc + cd + ad;
        return perimeter;
    }

    @Override
    public double getArea() {
        //return Vector.area(new Vector(A,C), new Vector(B,D));
        return (new Triangle(A,B,C).getArea()) + (new Triangle(C,D,A).getArea());
    }

    @Override
    public Point getCenter() {
        center.x = (A.x + B.x) * (A.x * B.y - A.y * B.x) +
                (B.x + C.x) * (B.x * C.y - B.y * C.x) +
                (C.x + D.x) * (C.x * D.y - C.y * D.x) +
                (D.x + A.x) * (D.x * A.y - D.y * A.x);
        center.y = (A.y + B.y) * (A.x * B.y - A.y * B.x) +
                (B.y + C.y) * (B.x * C.y - B.y * C.x) +
                (C.y + D.y) * (C.x * D.y - C.y * D.x) +
                (D.y + A.y) * (D.x * A.y - D.y * A.x);
        double sum3OfDet = 3 * ((A.x * B.y - A.y * B.x) +
                (B.x * C.y - B.y * C.x) +
                (C.x * D.y - C.y * D.x) +
                (D.x * A.y - D.y * A.x));
        center.x /= sum3OfDet;
        center.y /= sum3OfDet;
        return center;
    }

    @Override
    public String toString() {
        return "Quadrangle : area  = " + getArea() + ", perimeter = " + getPerimeter() + ", center of quadrangle = " + getCenter();
    }
}
