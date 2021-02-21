package homework.hw6;

public class Wheel extends DefaultObject {
    public Wheel() {
    }

    public Wheel(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString() + "(wheel)";
    }
}
