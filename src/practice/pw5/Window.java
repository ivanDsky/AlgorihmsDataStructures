package practice.pw5;

public class Window extends DefaultObject{
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
