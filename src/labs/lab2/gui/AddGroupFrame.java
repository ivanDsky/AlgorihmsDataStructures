package labs.lab2.gui;

import javax.swing.*;
import java.awt.*;

public class AddGroupFrame extends JFrame {

    JTextField nameField;
    JTextArea descriptionArea;

    AddGroupFrame() {
        JFrame addGroup = new JFrame("Adding a group");
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 1;
        c.gridwidth = 2;
        c.insets = new Insets(10,10,10,10);

        JLabel title = new JLabel("Add new group",SwingConstants.CENTER);
        mainPanel.add(title,c);



        JLabel name = new JLabel("Name:");

        c.gridy = 1;
        c.gridwidth = 1;
        mainPanel.add(name,c);

        nameField = new JTextField(1);
        nameField.setSize(40,10);
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(nameField,c);


        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 1000;
        JLabel description = new JLabel("Description:");
        mainPanel.add(description,c);


        descriptionArea = new JTextArea(5,20);
        JScrollPane descriptionScroll = new JScrollPane(descriptionArea);
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 2.8;
        mainPanel.add(descriptionScroll,c);



        JButton submit = new JButton("OK");
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 3;
        c.weighty = 1;
        mainPanel.add(submit,c);


        addGroup.add(mainPanel);
        addGroup.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addGroup.setSize(400,400);
        addGroup.setVisible(true);

    }

}
