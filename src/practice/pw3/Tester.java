package practice.pw3;

import utils.DataInput;
import utils.Util;

import java.math.BigInteger;

public class Tester {
    public static void main(String[] args) {
        Factorial defFact = new Factorial();
        FactorialCash cashFact = new FactorialCash();
        System.out.println("This program demonstrate that cash is efficient way of saving reusable data");
        System.out.println("You have 3 choices\n" +
                "1 - test cashed factorial\n" +
                "2 - test default factorial\n" +
                "3 - test both factorials");
        do{
            int inp,n = 0;
            while(true) {
                inp = DataInput.getInt("Enter your choice : ");
                if (inp <= 0 || inp > 3) System.out.println("Incorrect input. Try again.");
                else break;
            }
            BigInteger ans = BigInteger.ZERO,ans2 = BigInteger.ZERO;
            if(inp == 2){
                while(true){
                    n = DataInput.getInt("Enter n : ");
                    try{
                        ans = defFact.getFactorial(n);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                }
            }
            if(inp == 1 || inp == 3){
                while(true){
                    n = DataInput.getInt("Enter n : ");
                    try{
                        ans = cashFact.getFactorial(n);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                }
            }

            if(inp == 3){
                try{
                    ans2 = defFact.getFactorial(n);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    continue;
                }
            }

            if(inp == 2){
                System.out.println("Default factorial : " + ans);
            }
            if(inp == 1){
                System.out.println("Cashed factorial : " + ans);
            }
            if(inp == 3){
                System.out.println("Cashed factorial : " + ans);
                System.out.println("Default factorial : " + ans2);
            }
        }while (!Util.toExit());
    }
}
