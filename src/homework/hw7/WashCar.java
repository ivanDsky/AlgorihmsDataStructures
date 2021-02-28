package homework.hw7;

public class WashCar extends Car{
    private double speed = 0;
    private boolean isEngine = false;
    private boolean isWashed = true;

    public WashCar(ICar car) {
        this.speed = car.getSpeed();
        this.isEngine = car.getEngine();
    }

    @Override
    public void gas() {
        if(!isEngine) System.out.println("Cars' engine disabled");
        else {
            isWashed = false;
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

    @Override
    public String getType() {
        return "WashCar";
    }

    @Override
    public String toString() {
        return "WashCar " + (isWashed ? "is" : "isn't") + " washed, engine " + (isEngine ? "is" : "isn't") + " works. It has speed " + speed;
    }
}
