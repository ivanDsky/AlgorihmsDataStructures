package homework.hw6;

class MercedesBenzEWindow20 extends Window {
    MercedesBenzEWindow20(){
        super("MercedesBenzE W20");
    }
}

class MercedesBenzEWindow18 extends Window {
    MercedesBenzEWindow18(){
        super("MercedesBenzE W18");
    }
}

class MercedesBenzEWheel4_12 extends Wheel {
    public MercedesBenzEWheel4_12() {
        super("MercedesBenzE Wh4_12");
    }
}

class MercedesBenzEDoor17 extends Door {
    public MercedesBenzEDoor17() {
        super("MercedesBenzE D17");
    }
}

public class MercedesBenzE extends Car {
    MercedesBenzE(){
        super("Mercedes Benz E",65_000,2018);

        this.addSideWindow(new MercedesBenzEWindow18());
        this.addSideWindow(new MercedesBenzEWindow18());
        this.addSideWindow(new MercedesBenzEWindow18());
        this.addSideWindow(new MercedesBenzEWindow18());

        this.setFrontWindow(new MercedesBenzEWindow20());
        this.setBackWindow(new MercedesBenzEWindow20());

        this.setDoorsAmount(2);
        this.addDoor(new MercedesBenzEDoor17());
        this.addDoor(new MercedesBenzEDoor17());
        this.addDoor(new MercedesBenzEDoor17());

        this.addWheel(new MercedesBenzEWheel4_12());
        this.addWheel(new MercedesBenzEWheel4_12());
        this.addWheel(new MercedesBenzEWheel4_12());
        this.addWheel(new MercedesBenzEWheel4_12());
        this.addWheel(new MercedesBenzEWheel4_12());
    }
}
