package homework.hw3;

public class Animal {

    private double cost;
    private double saturation;
    private double maxSaturation;

    public Animal(double cost, double maxSaturation) {
        this.cost = cost;
        this.maxSaturation = maxSaturation;
        double r = Math.random();
        double lf = 0.2,rg = 0.8;
        saturation = maxSaturation * (lf + (rg - lf) * r);
        saturation = (int) saturation;
    }

    public void voice(){

    }

    public void eatSound(){

    }

    public void feedUp(Food food){
        saturation += food.getFoodValue() * maxSaturation;
        saturation = Math.min(saturation,maxSaturation);
    }

    public void hunger(){
        if(saturation < maxSaturation * 0.20)return;
        saturation -= maxSaturation * 0.15;
        System.out.println("Its saturation decreased. It's " + saturation + "now");
    }

    public void stroke(){

    }

    public double getCost() {
        return cost;
    }

    public double getSaturation() {
        return saturation;
    }

    public boolean isFullSaturation(){
        return  saturation == maxSaturation;
    }

    public String getName(){
        return "No name";
    }
}
