package practice.pw7;

public class Fish extends Animal implements IMovable,IPrice{
    private String waterType;

    public Fish(double price, String waterType) {
        super(price);
        this.waterType = waterType;
    }

    public Fish(double price, double speed) {
        super(price, speed);
    }

    public Fish(double price, double speed, String waterType) {
        super(price, speed);
        this.waterType = waterType;
    }

    public Fish(String waterType) {
        super();
        this.waterType = waterType;
    }

    public Fish(double price) {
        super(price);
        this.waterType = "default";
    }

    public Fish() {
        super();
        this.waterType = "default";
    }

    @Override
    public String toString() {
        String ret = "Fish";
        ret += " can be bought by " + price;
        ret += ". It should leave in " + waterType;
        ret += ". It's speed is " + speed;
        return ret +".";
    }
}
