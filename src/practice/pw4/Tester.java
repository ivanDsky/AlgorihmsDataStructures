package practice.pw4;

import utils.DataInput;
import utils.Util;

public class Tester {
    public static void main(String[] args) {
        System.out.println("This program encrypt given string by Caesar");//Enter program description
        StringCrypt crypt = new StringCrypt();
        int state = 2;
        while (true){
            if(state == 2) {
                String x = DataInput.getString("Enter string (empty string ends program): ");
                if (x.equals("")) break;
                crypt.setOrigin(x);
            }
            System.out.println("1 - encrypt origin string\n" +
                    "2 - change origin string to another one\n" +
                    "3 - exit");
            while(true){
                state = DataInput.getInt("Enter state : ");
                if(state != 1 && state != 2 && state != 3){
                    System.out.println("You can choose only 1,2 or 3");
                    continue;
                }
                break;
            }
            if(state == 3)break;
            if(state == 1){
                int shift = DataInput.getInt("Enter shift : ");
                crypt.encrypt(shift);
                System.out.println("Encrypted string : " + crypt.getCrypt());
            }
        }
    }
}

/*
    int v = 0;
    while(true){
        v = DataInput.getInt("Enter v");
        if(v < 0){
            System.out.println(" must be ");
            continue;
        }
        break;
    }
*/