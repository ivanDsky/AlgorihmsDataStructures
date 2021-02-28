package homework.hw7;

public class FixableCar extends Car {
    private double speed = 0;
    private boolean isEngine = false;
    private double fixPercent = 100;

    public FixableCar(ICar car) {
        this.speed = car.getSpeed();
        this.isEngine = car.getEngine();
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
        fixPercent -= 3;
        fixPercent = Math.max(fixPercent,0);
        speed = Math.max(speed,0);
        System.out.println("Car brakes");
    }

    @Override
    public void engine(boolean start) {
        if(start){
            if(fixPercent == 0){
                System.out.println("Car is broken.");
                isEngine = false;
                return;
            }
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
        return "FixableCar";
    }

    @Override
    public String toString() {
        return "FixableCar is fixed on " + fixPercent + "%, engine " + (isEngine ? "is" : "isn't") + " works. It has speed " + speed;
    }
}
