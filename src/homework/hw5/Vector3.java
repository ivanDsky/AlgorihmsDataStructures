package homework.hw5;

import utils.DataInput;

public class Vector3 {
    public double x,y,z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(Point A,Point B){
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

    public Vector3 add(Vector3 b){
        return new Vector3(x + b.x,y + b.y,z + b.z);
    }

    public static double area(Vector3 a,Vector3 b){
        return volume(a,b,new Vector3(1,1,1));
    }

    public static double volume(Vector3 a,Vector3 b,Vector3 c){
        Vector3 abc = new Vector3(c.x * (a.y * b.z - a.z * b.y),c.y * (a.x * b.z - a.z * b.x),c.z * (a.x * b.y - a.y * b.x));
        return abc.magnitude();
    }

    public static Vector3 readVector(String s){
        System.out.println(s);
        double x,y,z;
        x = DataInput.getDouble("Enter x : ");
        y = DataInput.getDouble("Enter y : ");
        z = DataInput.getDouble("Enter z : ");
        return new Vector3(x,y,z);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
