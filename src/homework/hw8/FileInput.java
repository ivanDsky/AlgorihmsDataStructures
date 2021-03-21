package homework.hw8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileInput {
    public static String getInput(String fileFrom) throws IOException {

        FileReader fin = new FileReader(fileFrom);
        BufferedReader reader = new BufferedReader(fin);
        String s = null,file = "";
        do{
            s=reader.readLine();
            if(s!=null)file+=s+" ";
        }
        while (s!=null);
        return file;
    }
}
