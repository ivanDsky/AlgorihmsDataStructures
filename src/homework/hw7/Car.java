package homework.hw7;

public class Car implements ICar{
    private double speed = 0;
    private boolean isEngine = false;

    public Car() {

    }

    @Override
    public void gas() {
        if(!isEngine) System.out.println("Cars' engine disabled");
        else {
            speed += 10;
            System.out.println("Car speeds up");
        }
    }

    @Override
    public void brakes() {
        if(speed == 0)return;
        speed -= 20;
        speed = Math.max(speed,0);
        System.out.println("Car brakes");
    }

    @Override
    public void engine(boolean start) {
        if(start){
            System.out.println("Engine starts");
        }
        else System.out.println("Engine stops");
        isEngine = start;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public boolean getEngine() {
        return isEngine;
    }

    public String getType(){
        return "Car";
    }

    @Override
    public String toString() {
        return "Car engine " + (isEngine ? "is" : "isn't") + " works. It has speed " + speed;
    }
}
