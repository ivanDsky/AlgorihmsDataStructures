package homework.hw6;

public class Window extends DefaultObject {
    public Window() {
    }

    public Window(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString() + "(window)";
    }
}
