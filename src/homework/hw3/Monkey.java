package homework.hw3;

public class Monkey extends Animal{
    public Monkey(double cost, double maxSaturation) {
        super(cost, maxSaturation);
    }

    @Override
    public void voice() {
        System.out.println("Monkey says \"Hu-hu-hu\"");
    }

    @Override
    public void eatSound() {
        System.out.println("Monkey eats \"Chew-chew\"");
    }

    @Override
    public void feedUp(Food food) {
        super.feedUp(food);
        System.out.println("Monkey eats " + food + " and now monkeys' saturation is " + getSaturation());
        if(isFullSaturation()) System.out.println("It's monkeys' maximum saturation.");
    }

    @Override
    public void stroke() {
        System.out.println("Monkey is kind. It have smiled.");
    }

    @Override
    public String getName() {
        return "monkey";
    }

    @Override
    public String toString() {
        return "Monkey. Its saturation is : " + getSaturation() + ". Its price is " + getCost() + ".";
    }
}
