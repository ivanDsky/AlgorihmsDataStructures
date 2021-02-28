package practice.pw7;

public class Tiger extends Animal implements IMovable,IPrice,ISoundable{
    public Tiger(double price, double speed) {
        super(price, speed);
    }

    public Tiger() {
        super();
    }

    public Tiger(double price) {
        super(price);
    }

    @Override
    public void speak() {
        System.out.println("Grrrr");
    }

    @Override
    public double getVolume() {
        return 75;
    }

    @Override
    public String toString() {
        String ret = "Tiger";
        ret += " can be bought by " + price;
        ret += ". It has volume " + getVolume();
        ret += ". It's speed is " + speed;
        return ret +".";
    }
}
