package homework.hw6;

public class TeslaModelX extends Car{
    TeslaModelX(){
        super("Tesla Model X",102_000,2015);

        this.addSideWindow(new TeslaModelXWindow12());
        this.addSideWindow(new TeslaModelXWindow12());
        this.addSideWindow(new TeslaModelXWindow12());
        this.addSideWindow(new TeslaModelXWindow12());

        this.setFrontWindow(new TeslaModelXWindow14());
        this.setBackWindow(new TeslaModelXWindow14());

        this.setDoorsAmount(2);
        this.addDoor(new TeslaModelXDoor10());
        this.addDoor(new TeslaModelXDoor10());

        this.addWheel(new TeslaModelXWheelN08());
        this.addWheel(new TeslaModelXWheelN08());
        this.addWheel(new TeslaModelXWheelN08());
        this.addWheel(new TeslaModelXWheelN08());
    }
}


class TeslaModelXWindow12 extends Window {
    TeslaModelXWindow12(){
        super("TeslaModelX Wn(20)");
    }
}

class TeslaModelXWindow14 extends Window {
    TeslaModelXWindow14(){
        super("TeslaModelX Wn(14)");
    }
}

class TeslaModelXWheelN08 extends Wheel {
    public TeslaModelXWheelN08() {
        super("TeslaModelX Wl(08)");
    }
}

class TeslaModelXDoor10 extends Door {
    public TeslaModelXDoor10() {
        super("TeslaModelX Dr(10)");
    }
}
