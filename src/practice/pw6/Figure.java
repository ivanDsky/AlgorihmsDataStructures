package practice.pw6;

import utils.geometry.*;

public class Figure {
    protected double area;
    protected double perimeter;
    protected Point center;

    Figure(){
        area = perimeter = 0;
        center = new Point();
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public Point getCenter(){
        return center;
    }

    @Override
    public String toString() {
        return "Figure : area  = " + getArea() + ", perimeter = " + getPerimeter() + ", center of figure = " + getCenter();
    }
}
