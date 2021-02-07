package homework.hw3;

public class Chicken extends Animal{
    public Chicken(double cost, double maxSaturation) {
        super(cost, maxSaturation);
    }

    @Override
    public void voice() {
        System.out.println("Chicken says \"Ko-ko-ko\"");
    }

    @Override
    public void eatSound() {
        System.out.println("Chicken eats \"Kudh-tsok\"");
    }

    @Override
    public void feedUp(Food food) {
        super.feedUp(food);
        System.out.println("Chicken eats " + food + " and now chickens' saturation is " + getSaturation());
        if(isFullSaturation()) System.out.println("It's chicken maximum saturation.");
    }

    @Override
    public void stroke() {
        System.out.println("Chicken is angry. It have pecked you.");
    }

    @Override
    public String getName() {
        return "chicken";
    }

    @Override
    public String toString() {
        return "Chicken. Its saturation is : " + getSaturation() + ". Its price is " + getCost() + ".";
    }
}
