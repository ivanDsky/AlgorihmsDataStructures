package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

    private static void writeText(String wr){
        if (wr == null)
            System.out.print("Введіть дані: ");
        else
            System.out.print(wr);
    }

    public static Long getLong() throws IOException{
        String s = getString();
        Long value = Long.valueOf(s);
        return value;
    }

    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }

    public static Integer getInt(String wr){
        writeText(wr);
        Integer value;
        while(true) {
            String s = "";
            try {
                s = getString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                value = Integer.valueOf(s);
                break;
            } catch (Exception e) {
                writeText("Invalid integer, enter again : ");
            }
        }
        return value;
    }

    public static Integer getIntInRange(String wr,int l,int r){
        int x = 0;
        while(true){
            x = DataInput.getInt(wr);
            if(x < l || x > r){
                System.out.println("Integer can be only in [" + l + ".." + r + "]");
                continue;
            }
            break;
        }
        return x;
    }

    public static Double getDouble(String wr){
        writeText(wr);
        Double value;
        while(true) {
            String s = "";
            try {
                s = getString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                value = Double.valueOf(s);
                break;
            } catch (Exception e) {
                writeText("Invalid double, enter again : ");
            }
        }
        return value;
    }

    public static String getString(String wr){
        writeText(wr);
        String s = "";
        while(true) {
            try {
                s = getString();
                break;
            } catch (IOException e) {
                e.printStackTrace();
                writeText("Enter again : ");
            }
        }
        return s;
    }

    public static boolean getBoolean(String wr){
        writeText(wr);
        String s;
        while(true) {
            try {
                s = getString();
                if(s.equals("1") || s.toLowerCase().equals("true"))return true;
                if(s.equals("0") || s.toLowerCase().equals("false"))return false;
                break;
            } catch (IOException e) {
                e.printStackTrace();
                writeText("Invalid boolean(only 0|1 or true|false).Enter again : ");
            }
        }
        return false;
    }

    public static boolean getBoolean(String wr, String truth, String lye){
        writeText(wr);
        String s;
        while(true) {
            try {
                s = getString();
                if(s.equals(truth))return true;
                if(s.equals(lye))return false;
                break;
            } catch (IOException e) {
                e.printStackTrace();
                writeText("Invalid boolean(only 0|1 or true|false).Enter again : ");
            }
        }
        return false;
    }

    private static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

}
