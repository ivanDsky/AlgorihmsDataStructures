package practice.pw7;

public abstract class Toy implements IPrice {
    protected String shop;
    protected double price;

    public Toy(double price, String shop) {
        this.shop = shop;
        this.price = price;
    }

    public Toy(double price) {
        this(price,"default");
        shop = null;
    }

    public Toy(){
        this(10);
        shop = null;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public String getShop() {
        return shop;
    }
}
