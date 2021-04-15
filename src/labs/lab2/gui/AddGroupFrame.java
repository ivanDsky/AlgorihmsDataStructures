package labs.lab2.gui;

import labs.lab2.data.Database;
import labs.lab2.data.Group;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGroupFrame extends JFrame {

    JTextField nameField;
    JTextArea descriptionArea;

    private Group group;
    private IOnRefreshList frame;


    public AddGroupFrame(IOnRefreshList frame){
        group = null;
        this.frame = frame;
        init();
    }

    public AddGroupFrame(IOnRefreshList frame,Group group){
        this.group = group;
        this.frame = frame;
        init();
    }

    private void init() {
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



        JLabel nameLabel = new JLabel("Name:");

        c.gridy = 1;
        c.gridwidth = 1;
        mainPanel.add(nameLabel,c);

        nameField = new JTextField(group == null ? null : group.getName(),1);
        nameField.setSize(40,10);
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(nameField,c);


        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 1000;


        JLabel descLabel = new JLabel("Description:");
        mainPanel.add(descLabel,c);

        descriptionArea = new JTextArea(group == null ? null : group.getDescription(),5,20);
        JScrollPane descriptionScroll = new JScrollPane(descriptionArea);
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 2.8;
        mainPanel.add(descriptionScroll,c);



        JButton submit = new JButton("OK");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Group nGroup = new Group(nameField.getText(),descriptionArea.getText());
                if(group == null){
                    Database.getInstance().addGroup(nGroup);
                }else{
                    Database.getInstance().updateGroup(group.getName(),nGroup);
                }
                frame.refreshList();
                addGroup.dispose();
            }
        });

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