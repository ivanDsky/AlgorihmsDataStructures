package homework.hw7;

public class Tester {
    public static void main(String[] args) {
        ICarFactory factory = new STO();
        ICar car = new Car();
        System.out.println(car);
        factory.insert(car);
        car = factory.extract();
        System.out.println(car);
        factory = new Washing();
        factory.insert(car);
        car = factory.extract();
        System.out.println(car);
    }
}