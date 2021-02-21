package utils.geometry;

import utils.DataInput;

public class Point3D {
    public double x,y,z;

    public Point3D(){
        x = y = z = 0;
    }

    public Point3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Point3D readPoint(String s){
        System.out.println(s);
        double x,y,z;
        x = DataInput.getDouble("Enter x : ");
        y = DataInput.getDouble("Enter y : ");
        z = DataInput.getDouble("Enter z : ");
        return new Point3D(x,y,z);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

