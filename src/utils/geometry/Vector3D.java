package utils.geometry;

import homework.hw5.Point;
import utils.DataInput;

public class Vector3D {
    public double x,y,z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(homework.hw5.Point A, Point B){
        this.x = B.x - A.x;
        this.y = B.y - A.y;
        this.z = B.z - A.z;
    }

    public double magnitude(){
        return Math.sqrt(sqrMagnitude());
    }

    public double sqrMagnitude(){
        return x * x + y * y + z * z;
    }

    public Vector3D add(Vector3D b){
        return new Vector3D(x + b.x,y + b.y,z + b.z);
    }

    public static double area(Vector3D a, Vector3D b){
        return volume(a,b,new Vector3D(1,1,1));
    }

    public static double volume(Vector3D a, Vector3D b, Vector3D c){
        Vector3D abc = new Vector3D(c.x * (a.y * b.z - a.z * b.y),c.y * (a.x * b.z - a.z * b.x),c.z * (a.x * b.y - a.y * b.x));
        return abc.magnitude();
    }

    public static Vector3D readVector(String s){
        System.out.println(s);
        double x,y,z;
        x = DataInput.getDouble("Enter x : ");
        y = DataInput.getDouble("Enter y : ");
        z = DataInput.getDouble("Enter z : ");
        return new Vector3D(x,y,z);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
