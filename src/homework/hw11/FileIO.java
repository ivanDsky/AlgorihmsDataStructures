package homework.hw11;

import java.io.*;
import java.util.Scanner;

public class FileIO {
    public static String getInput(File fileFrom) throws IOException {
        System.out.println("Start read " + fileFrom.getName());
        FileReader fin = new FileReader(fileFrom);
        BufferedReader reader = new BufferedReader(fin);
        String s;
        StringBuilder file = new StringBuilder("");
        do{
            s=reader.readLine();
            if(s!=null)file.append(s).append(' ');
        }
        while (s!=null);
        System.out.println("End read " + fileFrom.getName());
        return file.toString();
    }

    public static void setOutput(File fileTo,String content) throws IOException {
        FileWriter writer = new FileWriter(fileTo);
        BufferedWriter bufWriter = new BufferedWriter(writer);
        bufWriter.write(content);
        bufWriter.close();
    }

}
