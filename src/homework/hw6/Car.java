package homework.hw6;

public class Car {
    private Wheel[] wheels;
    private Door[] doors;
    private Window frontWindow;
    private Window backWindow;
    private Window[] sideWindows;

    private String name;
    private int year;
    private int dollarPrice;

    Car(){
        wheels = new Wheel[4];
        doors = new Door[4];
        sideWindows = new Window[4];
        name = "Empty car";
        year = -1;
        dollarPrice = -1;
    }

    Car(String name){
        this();
        this.name = name;
    }

    Car(String name,int dollarPrice){
        this(name);
        this.dollarPrice = dollarPrice;
    }

    Car(String name,int dollarPrice,int year){
        this(name,dollarPrice);
        this.year = year;
    }

    public Car addWheel(Wheel wheel){
        for(int i = 0;i < wheels.length; ++i){
            if(wheels[i] == null){
                wheels[i] = wheel;
                return this;
            }
        }
        System.out.println("No more space for wheel");
        return this;
    }

    public Car setDoorsAmount(int x){
        if(x <= 0) {
            System.out.println("Amount of doors should be greater than 0");
            return this;
        }
        doors = new Door[x];
        return this;
    }

    public Car addDoor(Door door){
        for(int i = 0;i < doors.length; ++i){
            if(doors[i] == null){
                doors[i] = door;
                return this;
            }
        }
        System.out.println("No more space for door");
        return this;
    }

    public Car setSideWindowsAmount(int x){
        if(x < 0) {
            System.out.println("Amount of side windows should be greater than 0");
            return this;
        }
        if(x == 0)sideWindows = null;else
        sideWindows = new Window[x];
        return this;
    }

    public Car addSideWindow(Window window){
        if(sideWindows == null){
            System.out.println("You can't install side window in this car");
            return this;
        }
        for(int i = 0;i < sideWindows.length; ++i){
            if(sideWindows[i] == null){
                sideWindows[i] = window;
                return this;
            }
        }
        System.out.println("No more space for side window");
        return this;
    }

    public Car setFrontWindow(Window window){
        frontWindow = window;
        return this;
    }

    public Car setBackWindow(Window window){
        backWindow = window;
        return this;
    }

    @Override
    public String toString() {
        String ret = name + "\n";
        if(dollarPrice != -1)ret += "Price : " + dollarPrice + "$\n";
        if(year != -1)ret += "Year : " + year + "\n";
        ret += "Windows\n";
        ret += "Front window : " + frontWindow + "\n";
        ret += "Back window : " + backWindow + "\n";

        ret += "Side windows : ";
        for(int i = 0;i < sideWindows.length; ++i){
            ret += ((i == 0) ? "" : ", ") + sideWindows[i];
        }
        ret += "\n";

        ret += "Doors : ";
        for(int i = 0;i < doors.length; ++i){
            ret += ((i == 0) ? "" : ", ") + doors[i];
        }
        ret += "\n";

        ret += "Wheels : ";
        for(int i = 0;i < wheels.length; ++i){
            ret += ((i == 0) ? "" : ", ") + wheels[i];
        }
        return ret;
    }
}
