package practice.pw5;

import utils.DataInput;
import utils.Util;

public class Tester {
    public static void main(String[] args) {
        Util.dashLine();
        System.out.println(new MercedesBenzE());
        Util.dashLine();
        System.out.println(new ToyotaCamryHybrid());
        Util.dashLine();
        Car customCar = new Car("ToMers 2021",14_000,2021);
        customCar.setFrontWindow(new MercedesBenzEWindow20()).setBackWindow(new MercedesBenzEWindow20());
        customCar.addWheel(new ToyotaCamryHybridWheelF_XIV());
        customCar.addWheel(new ToyotaCamryHybridWheelF_XIV());
        customCar.addWheel(new ToyotaCamryHybridWheelF_XIV());
        customCar.addWheel(new ToyotaCamryHybridWheelF_XIV());
        customCar.setDoorsAmount(2);
        customCar.addDoor(new MercedesBenzEDoor17());
        customCar.addDoor(new ToyotaCamryHybridDoorXIX());
        customCar.setSideWindowsAmount(2);
        customCar.addSideWindow(new MercedesBenzEWindow18());
        customCar.addSideWindow(new MercedesBenzEWindow18());
        System.out.println(customCar);
    }
}