package homework.hw3;

import utils.DataInput;

public class PetShop {
    private static Animal[] animals = {
            new Chicken(100,90),
            new Monkey(320,170),
            new PocketHorse(670,330)
    };

    public static void main(String[] args) {
        Player player = new Player(1500,200);
        System.out.println("Today is good day to go to the pet shop");
        System.out.println("--------Pet shop--------");
        System.out.println("Shop assistant: Good morning");
        while(true) {
            System.out.println("What do you want to do?\n" +
                    "1 - You want to look on pets.\n" +
                    "2 - You want to feed pets or yourself.\n" +
                    "3 - You want to interact with your pets.\n" +
                    "4 - Leave pet shop out.");
            int type = 0;
            while (true){
                type = DataInput.getInt("Enter number: ");
                if (type >= 5 || type <= 0) {
                    System.out.println("Answer is 1 to 4");
                    continue;
                }
                break;
            }
            if(type == 4){
                System.out.println("Good bye!");
                System.exit(0);
            }
            if(type == 1){
                System.out.println("You have " + player.getMoney() + ".");
                int mx = 0;
                if(haveAnimals()){
                    mx = showAnimals();
                }else{
                    System.out.println("Sorry, we don't have pets now");
                    continue;
                }
                int x = 0;
                while(true){
                    x = DataInput.getInt("Enter number: ");
                    if (x > mx || x <= 0) {
                        System.out.println("Answer is 1 to " + mx);
                        continue;
                    }
                    break;
                }
                buyAnimal(player,x);
            }

            if(type == 2){
                System.out.println("Whom do you want to feed?\n" +
                        "1 - yourself\n" +
                        "2 - your animal");
                while(true){
                    type = DataInput.getInt("Enter number: ");
                    if (type >= 3 || type <= 0) {
                        System.out.println("Answer is 1 or 2");
                        continue;
                    }
                    break;
                }
                Animal animal = null;
                if(type == 2)animal = getPlayerAnimal(player);
                if(type == 2 && animal == null)continue;
                int x = 0;
                System.out.println("What type of food?\n" +
                        "1 - apples\n" +
                        "2 - bananas\n" +
                        "3 - bread");
                while(true){
                    x = DataInput.getInt("Enter number: ");
                    if (x >= 4 || x <= 0) {
                        System.out.println("Answer is 1 to 3");
                        continue;
                    }
                    break;
                }
                Food food = null;
                if(x == 1)food = new Apple();
                if(x == 2)food = new Banana();
                if(x == 3)food = new Bread();

                if(type == 1){
                    player.feedUp(food);
                }else{
                    animal.eatSound();
                    animal.feedUp(food);
                }
            }

            if(type == 3){
                Animal anim = getPlayerAnimal(player);
                if(anim == null)continue;
                int x = 0;
                System.out.println("What do you want to do?\n" +
                        "1 - listen to your pet\n" +
                        "2 - stroke your pet");
                while(true){
                    x = DataInput.getInt("Enter number: ");
                    if (x >= 3 || x <= 0) {
                        System.out.println("Answer is 1 or 2");
                        continue;
                    }
                    break;
                }
                if(x == 1)anim.voice();
                if(x == 2)anim.stroke();
            }
        }
    }

    private static Animal getPlayerAnimal(Player player){
        if(!player.hasAnimal()){
            System.out.println("No bought animals.");
            return null;
        }
        System.out.println("Select pet : ");
        for(int i = 0;i < 3; ++i){
            Animal current = player.getAnimal(i);
            if(current == null)break;
            System.out.println((i + 1) + " - " + current.getName());
        }
        int id = 0;
        while (true){
            id = DataInput.getInt("Enter number: ");
            if(player.getAnimal(id - 1) == null) continue;
            break;
        }
        return player.getAnimal(id - 1);
    }

    private static int showAnimals(){
        System.out.println("We have :");
        int cnt = 0;
        for(int id = 0;id < animals.length; ++id){
            if(animals[id] == null) continue;
            System.out.println(++cnt + " - " + animals[id]);
        }
        return cnt;
    }

    private static void buyAnimal(Player player,int cnt){
        for(int id = 0;id < animals.length; ++id){
            if(animals[id] == null) continue;
            --cnt;
            if(cnt == 0){
                boolean isBuy = player.buyAnimal(animals[id]);
                if(isBuy){
                    System.out.println("You bought " + animals[id].getName());
                    animals[id] = null;
                }else{
                    System.out.println("You can't bought animal(not enough money)");
                }
                return;
            }
        }
    }

    private static boolean haveAnimals(){
        for (Animal animal : animals) {
            if(animal != null) return true;
        }
        return false;
    }

}
