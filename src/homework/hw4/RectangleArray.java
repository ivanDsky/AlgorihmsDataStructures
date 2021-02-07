package homework.hw4;

public class RectangleArray {
    private final static int MAX_SIZE = 100;
    private Rectangle[] rectangles;

    public int getSize() {
        return index;
    }

    private int index;

    public RectangleArray() {
        rectangles = new Rectangle[MAX_SIZE];
        index = 0;
    }

    public void addRectangle(Rectangle rect){
        rectangles[index++] = rect;
    }

    public Rectangle getRectangle(int index){
        if(index < 0 || index >= this.index)return null;
        return rectangles[index];
    }

    @Override
    public String toString() {
        String ret = "Rectangles\n";
        for(int i = 0;i < index; ++i){
            ret += (i + 1) + " : " + rectangles[i];
            if(i != index  - 1)ret += "\n";
        }
        return ret;
    }
}
