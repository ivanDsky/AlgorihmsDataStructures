package homework.hw6;

public class Door extends DefaultObject {
    public Door() {
    }

    public Door(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString() + "(door)";
    }
}
