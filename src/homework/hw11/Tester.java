package homework.hw11;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Tester {
    public static void main(String[] args) {


        FileChooser chooser = new FileChooser();

        while (true) {
            try {
                chooser.readFiles();
                break;
            } catch (FileChooseException e) {
                JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
        }
        chooser.generateVocabulary();

    }
}
