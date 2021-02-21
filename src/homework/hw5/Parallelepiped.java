package homework.hw5;

import utils.geometry.Vector3D;

public class Parallelepiped {
    private double height;
    private double area;
    private double volume;

    private Vector3D a,b,c;
    private Point A;

    public Parallelepiped(Point N){
        A = new Point(0,0,0);
        a = new Vector3D(N.x,0,0);
        b = new Vector3D(0,N.y,0);
        c = new Vector3D(0,0,N.z);
        area = N.x * N.y;
        height = N.z;
    }

    public Parallelepiped(Point A,Point B,Point C,double AA1,double alpha){
        a = new Vector3D(A,B);
        b = new Vector3D(A,C);
        area = Vector3D.area(a,b);
        height = AA1 * Math.sin((alpha * Math.PI) / 180.0);
    }

    public Parallelepiped(Point A,double AB,double AD,double theta,double AA1,double alpha){
        area = AB * AD * Math.sin((theta * Math.PI) / 180.0);
        height = AA1 * Math.sin((alpha * Math.PI) / 180.0);
    }

    public Parallelepiped(Point A, Vector3D a, Vector3D b, Vector3D c){
        this.A = A;
        this.a = a;
        this.b = b;
        this.c = c;
        area = Vector3D.area(a,b);
        height = area == 0 ? 0 : Vector3D.volume(a,b,c) / area;
    }

    public Parallelepiped(Point A,Point B,Point C,Point A1){
        this.A = A;
        a = new Vector3D(A,B);
        b = new Vector3D(A,C);
        c = new Vector3D(A,A1);
        area = Vector3D.area(a,b);
        height = area == 0 ? 0 : Vector3D.volume(a,b,c) / area;
    }

    public double getVolume(){
        volume = getArea() * getHeight();
        return volume;
    }

    public double getArea(){
        return area;
    }

    public double getHeight(){
        return height;
    }

    @Override
    public String toString() {
        return "Parallelepiped have area : " + getArea() + ", height : " + getHeight() + ", volume : " + getVolume() +
                ((c != null) ? (", can be represented by 3 vectors : " + a + ", " + b + ", " + c) : "");
    }
}
