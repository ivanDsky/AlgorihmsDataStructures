package homework.hw4;

public class Rectangle {
    private double x1,x2,y1,y2;

    /**
     * Empty rectangle with coordinates (0,0) (0,0)
     */
    public Rectangle(){
        x1 = y1 = x2 = y2;
    }

    /**
     * Creates rectangle with coordinates (0,0) (x,y)
     * @param x
     * @param y
     */
    public Rectangle(double x,double y) {
        x1 = y1 = 0;
        this.x2 = x;
        this.y2 = y;
    }

    /**
     * Creates rectangle with coordinates (x1,y1) (x2,y2)
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public Rectangle(double x1, double y1, double x2, double y2) {
        if(x1 > x2){
            double t = x1;
            x1 = x2;
            x2 = t;
        }

        if(y1 > y2){
            double t = y1;
            y1 = y2;
            y2 = t;
        }

        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public void setStart(double x1,double y1){
        this.x1 = x1;
        this.y1 = y1;
    }

    public void setEnd(double x2,double y2){
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setCoordinates(double x1, double y1, double x2, double y2) {
        if(x1 > x2){
            double t = x1;
            x1 = x2;
            x2 = t;
        }

        if(y1 > y2){
            double t = y1;
            y1 = y2;
            y2 = t;
        }

        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    /**
     * Changes rectangle width and height but start points are fixed
     * @param width
     * @param height
     */
    public void setSize(double width,double height){
        x2 = x1 + width;
        y2 = y1 + height;
    }

    /**
     * Moves rectangle by vector (x,y)
     * @param x
     * @param y
     */
    public void move(double x,double y){
        x1 += x;x2 += x;
        y1 += y;y2 += y;
    }

    /**
     * Checks is point (x,y) inside rectangle
     * @param x
     * @param y
     * @return
     */
    public boolean isPointInside(double x,double y){
        return (x1 <= x && x <= x2) && (y1 <= y && y <= y2);
    }

    /**
     * Returns new rectangle that is union of current and given one
     * @param rect
     * @return
     */
    public Rectangle union(Rectangle rect){
        Rectangle ret = new Rectangle(
                Math.min(x1,rect.x1),
                Math.min(y1,rect.y1),
                Math.max(x2,rect.x2),
                Math.max(y2,rect.y2));

        return ret;
    }

    /**
     * Returns new rectangle that is intersection of current and given one
     * @param rect
     * @return
     */
    public Rectangle intersection(Rectangle rect){
        double rx1 = Math.max(x1,rect.x1),ry1 = Math.max(y1,rect.y1),
                rx2 = Math.min(x2,rect.x2),ry2 = Math.min(y2,rect.y2);
        if(rx1 > rx2 || ry1 > ry2)return null;
        return new Rectangle(rx1,ry1,rx2,ry2);
    }

    @Override
    public String toString() {
        return "Rectangle with coordinates from (" + x1 + ", " + y1 +") to (" + x2 + ", " + y2 + ")";
    }
}
