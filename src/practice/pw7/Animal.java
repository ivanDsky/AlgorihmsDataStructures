package practice.pw7;

public abstract class Animal implements IPrice,IMovable{
    protected double price;
    protected double speed;

    @Override
    public void move() {
        speed += 5;
    }

    @Override
    public void move(double x) {
        speed += x;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public Animal(double price, double speed) {
        this.price = price;
        this.speed = speed;
    }


    public Animal(double price) {
        this.price = price;
    }

    public Animal(){
        this(0,0);
    }
}
