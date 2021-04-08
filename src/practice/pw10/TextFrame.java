package practice.pw10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;

public class TextFrame extends JFrame {
    JTextArea area = new JTextArea(5, 20);
    JScrollPane scrollPane = new JScrollPane(area);

    TextFrame() {
        openFile(new File("D:\\Temp.txt"));

        JPanel layout = new JPanel(new BorderLayout());

        JButton openButton = new JButton("Open");

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = getFile();

                if (file == null) {
                    //JOptionPane.showMessageDialog(null,"Incorrect file","Error",JOptionPane.ERROR_MESSAGE);
                } else {
                    openFile(file);
                }
            }
        });

        layout.add(openButton, BorderLayout.PAGE_END);
        layout.add(scrollPane);

        area.setDisabledTextColor(Color.BLACK);
        area.setEditable(false);

        add(layout);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);

    }

    private void openFile(File file) {
        area.setText("");
        try {
            BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.ISO_8859_1);
            while (true) {
                String s = reader.readLine();
                if (s == null) break;
                area.append(s + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File getFile() {
        JFileChooser fileChooser = new JFileChooser("D:");
        int ret = fileChooser.showOpenDialog(null);
        if (ret == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public static void main(String[] args) {
        new TextFrame();
    }
}
