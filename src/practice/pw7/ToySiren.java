package practice.pw7;

public class ToySiren extends Toy implements ISoundable {
    private double volume;

    public ToySiren(double price, double volume, String shop) {
        this(price, volume);
        this.shop = shop;
    }

    public ToySiren(double price,double volume){
        this(price);
        this.volume = volume;
    }

    public ToySiren(double price) {
        super(price);
    }

    public ToySiren() {
    }

    @Override
    public void speak() {
        System.out.println("Wiu wiu wiu");
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        String ret = "Toy siren";
        ret += " can be bought by " + price;
        if(shop != null)ret += " in " + shop;
        ret += ". It has volume " + volume;
        return ret +".";
    }
}
