package utils;

import java.io.IOException;

public final class Util {
    public static boolean toExit() {
        int ans = DataInput.getInt("Do you want to exit?(0 - exit, else to repeat it one more time) : ");
        return ans == 0;
    }

    public static void dashLine() {
        System.out.println("---------------------------------------------------------------------");
    }


}
