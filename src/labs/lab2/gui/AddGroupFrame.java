package labs.lab2.gui;

import javax.swing.*;
import java.awt.*;

public class AddGroupFrame extends JFrame {

    JTextField nameField;
    JTextField descriptionField;

    AddGroupFrame() {
        JFrame addGroup = new JFrame("Adding a group");
        JPanel mainPanel = new JPanel();
        JPanel namePanel = new JPanel(new BorderLayout());
        JPanel descriptionPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Title");
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        addGroup.add(title);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));



        namePanel.add(Box.createRigidArea(new Dimension(10,50)));
        JLabel name = new JLabel("Name:");
        mainPanel.add(name, BorderLayout.WEST);

        nameField = new JTextField(1);
        nameField.setSize(40,10);
        mainPanel.add(nameField);


        descriptionPanel.add(Box.createRigidArea(new Dimension(10,50)));
        JLabel description = new JLabel("Description:");
        mainPanel.add(description, BorderLayout.WEST);


        descriptionField = new JTextField(1);
        descriptionField.setSize(40,10);
        mainPanel.add(descriptionField);




        addGroup.add(mainPanel);
        addGroup.pack();
        addGroup.setDefaultCloseOperation(EXIT_ON_CLOSE);
        addGroup.setSize(400,400);
        addGroup.setVisible(true);

    }

    public static void main(String[] args) {
        new AddGroupFrame();

    }
}
