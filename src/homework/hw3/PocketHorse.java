package homework.hw3;

public class PocketHorse extends Animal{
    public PocketHorse(double cost, double maxSaturation) {
        super(cost, maxSaturation);
    }

    @Override
    public void voice() {
        System.out.println("Pocket horse says \"Iho-ho-ho\"");
    }

    @Override
    public void eatSound() {
        System.out.println("Pocket horse eats \"Hrum-hrum\"");
    }

    @Override
    public void feedUp(Food food) {
        super.feedUp(food);
        System.out.println("Pocket horse eats " + food + " and now pocket horses' saturation is " + getSaturation());
        if(isFullSaturation()) System.out.println("It's pocket horses' maximum saturation.");
    }

    @Override
    public void stroke() {
        System.out.println("Pocket horse is kind. It have licked you.");
    }

    @Override
    public String getName() {
        return "pocket horse";
    }

    @Override
    public String toString() {
        return "Pocket horse. Its saturation is : " + getSaturation() + ". Its price is " + getCost() + ".";
    }
}
