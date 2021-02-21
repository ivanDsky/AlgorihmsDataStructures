package homework.hw6;

import utils.Util;

public class Tester {
    public static void main(String[] args) {
        Util.dashLine();
        System.out.println(new MercedesBenzE());
        Util.dashLine();
        System.out.println(new ToyotaCamryHybrid());
        Util.dashLine();
        System.out.println(new TeslaModelX());
        Util.dashLine();
        Car customCar = new Car("ToMers 2021",72_000,2021);
        customCar.setFrontWindow(new MercedesBenzEWindow20()).setBackWindow(new TeslaModelXWindow14());
        customCar.addWheel(new MercedesBenzEWheel4_12());
        customCar.addWheel(new MercedesBenzEWheel4_12());
        customCar.addWheel(new TeslaModelXWheelN08());
        customCar.addWheel(new TeslaModelXWheelN08());
        customCar.setDoorsAmount(2);
        customCar.addDoor(new ToyotaCamryHybridDoorXIX());
        customCar.addDoor(new TeslaModelXDoor10());
        customCar.setSideWindowsAmount(2);
        customCar.addSideWindow(new ToyotaCamryHybridWindowXVI());
        customCar.addSideWindow(new MercedesBenzEWindow18());
        System.out.println(customCar);
    }
}