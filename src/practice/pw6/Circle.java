package practice.pw6;

import utils.geometry.Point;

public class Circle extends Figure{
    private double radius;

    public Circle(Point center,double radius){
        radius = Math.abs(radius);
        this.radius = radius;
        this.center = center;
    }

    @Override
    public double getArea() {
        area = Math.PI * radius * radius;
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

    @Override
    public String toString() {
        return "Circle : area  = " + getArea() + ", perimeter = " + getPerimeter() + ", center of circle = " + getCenter();
    }
}
