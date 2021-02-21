package homework.hw6;

class ToyotaCamryHybridWindowXX extends Window {
    ToyotaCamryHybridWindowXX(){
        super("ToyotaCamryHybrid XX");
    }
}

class ToyotaCamryHybridWindowXVI extends Window {
    ToyotaCamryHybridWindowXVI(){
        super("ToyotaCamryHybrid XVI");
    }
}

class ToyotaCamryHybridWheelF_XIV extends Wheel {
    public ToyotaCamryHybridWheelF_XIV() {
        super("ToyotaCamryHybrid F_XIV");
    }
}

class ToyotaCamryHybridDoorXIX extends Door {
    public ToyotaCamryHybridDoorXIX() {
        super("ToyotaCamryHybrid XIX");
    }
}

public class ToyotaCamryHybrid extends Car {
    ToyotaCamryHybrid(){
        super("Toyota Camry Hybrid",59_000,2017);
        super.setFrontWindow(new ToyotaCamryHybridWindowXX());
        super.setBackWindow(new ToyotaCamryHybridWindowXX());

        super.addDoor(new ToyotaCamryHybridDoorXIX());
        super.addDoor(new ToyotaCamryHybridDoorXIX());
        super.addDoor(new ToyotaCamryHybridDoorXIX());
        super.addDoor(new ToyotaCamryHybridDoorXIX());

        super.addSideWindow(new ToyotaCamryHybridWindowXVI());
        super.addSideWindow(new ToyotaCamryHybridWindowXVI());
        super.addSideWindow(new ToyotaCamryHybridWindowXVI());
        super.addSideWindow(new ToyotaCamryHybridWindowXVI());

        super.addWheel(new ToyotaCamryHybridWheelF_XIV());
        super.addWheel(new ToyotaCamryHybridWheelF_XIV());
        super.addWheel(new ToyotaCamryHybridWheelF_XIV());
        super.addWheel(new ToyotaCamryHybridWheelF_XIV());
    }
}
