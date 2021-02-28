package homework.hw7;

public class STO implements ICarFactory{
    private ICar car;
    @Override
    public void insert(ICar car) {
        System.out.println(car.getType() + " is in STO");
        this.car = car;
    }

    @Override
    public ICar extract() {
        car = applyTo(car);
        System.out.println("Car is ready. Take it from STO");
        return car;
    }

    private ICar applyTo(ICar car) {
        System.out.println("Fixing car");
        return new FixableCar(car);
    }
}
