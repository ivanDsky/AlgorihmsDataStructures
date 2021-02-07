package homework.hw3;

public class Player {
    private double money;
    private double saturation;
    private double maxSaturation;

    private Animal[] animals = new Animal[3];

    public Player(double money, double maxSaturation) {
        this.money = money;
        this.maxSaturation = maxSaturation;
    }

    public void feedUp(Food food){
        saturation += food.getFoodValue() * maxSaturation;
        saturation = Math.min(saturation,maxSaturation);
        System.out.println("You have eaten " + food + ". Your saturation is " + saturation);
        if(saturation == maxSaturation) System.out.println("It's your maximum saturation.");
    }

    public void hunger(){
        if(saturation < maxSaturation * 0.20)return;
        saturation -= maxSaturation * 0.15;
        System.out.println("You saturation decreased. It's " + saturation + "now");
    }

    public double getMoney() {
        return money;
    }

    public double getSaturation() {
        return saturation;
    }

    public String getAnimals() {
        String ret = "Your animals are : \n";
        for (Animal animal:animals) {
            ret += " " + animal + "\n";
        }
        return ret;
    }

    public boolean hasAnimal(){
        for(int i = 0;i < 3; ++i){
            if(animals[i] != null)return true;
        }
        return false;
    }

    public boolean canMoreAnimal(){
        for(int i = 0;i < 3; ++i){
            if(animals[i] == null)return true;
        }
        return false;
    }

    public void addAnimal(Animal animal){
        for(int i = 0;i < 3; ++i){
            if(animals[i] == null){animals[i] = animal;break;}
        }
    }

    public Animal getAnimal(int x){
        if(x < 0 || x >= animals.length)return null;
        return animals[x];
    }

    public boolean buyAnimal(Animal animal){
        if(money >= animal.getCost() && canMoreAnimal()){
            money -= animal.getCost();
            addAnimal(animal);
            return true;
        }else{
            return false;
        }
    }
}
