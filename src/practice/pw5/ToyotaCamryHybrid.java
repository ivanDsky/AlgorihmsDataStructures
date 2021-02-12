package practice.pw5;

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

class ToyotaCamryHybridWheelF_XIV extends Wheel{
    public ToyotaCamryHybridWheelF_XIV() {
        super("ToyotaCamryHybrid F_XIV");
    }
}

class ToyotaCamryHybridDoorXIX extends Door{
    public ToyotaCamryHybridDoorXIX() {
        super("ToyotaCamryHybrid XIX");
    }
}

public class ToyotaCamryHybrid extends Car{
    ToyotaCamryHybrid(){
        super("Toyota Camry Hybrid",20_000,2017);
        super.setFrontWindow(new ToyotaCamryHybridWindowXVI());
        super.setBackWindow(new ToyotaCamryHybridWindowXVI());

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
