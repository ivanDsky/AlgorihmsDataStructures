package practice.pw7;

import utils.DataInput;
import utils.Util;

public class Tester {
    public static void main(String[] args) {
        System.out.println("This program demonstrates usage of interfaces and abstract classes");//Enter program description
        ToyCar car = new ToyCar(200, 25, "CarWorld");
        ToySiren siren = new ToySiren(150, 300, "WiuChop");
        Fish fish = new Fish(255, 20, "salt");
        Tiger tiger = new Tiger(755, 75);
        Util.dashLine();
        System.out.print(car + "\n" + siren + "\n" + fish + "\n" + tiger + "\n");
        Util.dashLine();
        moveArray(new IMovable[]{car, fish, tiger}, 10);
        System.out.println(car + "\n" + fish + "\n" + tiger);
        Util.dashLine();
        System.out.println("Car " + ((isACheaperB(car, fish) ? "is" : "isn't") + " cheaper than fish"));
        System.out.println("Tiger " + ((isACheaperB(tiger, fish) ? "is" : "isn't") + " cheaper than fish"));
        Util.dashLine();
        System.out.println("Siren " + ((isALouderB(siren, tiger) ? "is" : "isn't") + " louder than tiger"));
    }

    public static void moveArray(IMovable[] movable, double del) {
        for (IMovable x :
                movable) {
            x.move(del);
        }
    }

    public static boolean isACheaperB(IPrice a, IPrice b) {
        return a.getPrice() < b.getPrice();
    }

    public static boolean isALouderB(ISoundable a, ISoundable b) {
        return a.getVolume() > b.getVolume();
    }
}