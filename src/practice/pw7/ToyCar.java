package practice.pw7;

public class ToyCar extends Toy implements IMovable{
    private double speed;

    public ToyCar(double price, double speed, String shop) {
        this(price, speed);
        this.shop = shop;
    }

    public ToyCar(double price,double speed){
        this(price);
        this.speed = speed;
    }

    public ToyCar(double price) {
        super(price);
    }

    public ToyCar() {
    }

    @Override
    public void move() {
        speed += 5;
    }

    @Override
    public void move(double x) {
        speed += x;
    }

    @Override
    public String toString() {
        String ret = "Toy car";
        ret += " can be bought by " + price;
        if(shop != null)ret += " in " + shop;
        ret += ". It's speed is " + speed;
        return ret +".";
    }
}
