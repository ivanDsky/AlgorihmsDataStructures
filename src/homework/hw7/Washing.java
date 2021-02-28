package homework.hw7;

public class Washing implements ICarFactory{
    private ICar car;
    @Override
    public void insert(ICar car) {
        System.out.println(car.getType() + " is in Washing");
        this.car = car;
    }

    @Override
    public ICar extract() {
        car = applyTo(car);
        System.out.println("Car is ready. Take it from Washing");
        return car;
    }

    private ICar applyTo(ICar car) {
        System.out.println("Washing car");
        return new WashCar(car);
    }
}
