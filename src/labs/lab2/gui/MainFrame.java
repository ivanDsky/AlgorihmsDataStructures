package labs.lab2.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    JPanel mainPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel centerButtonPanel = new JPanel();
    JPanel searchPanel = new JPanel();
    JScrollPane searchListPanel;


    public MainFrame(){
        setupButtonPanel();
        setupSearchPanel();
        setupMainPanel();
    }

    private void setupMainPanel() {
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(centerButtonPanel,BorderLayout.WEST);
        mainPanel.add(searchPanel);
        add(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setVisible(true);
    }

    private void setupSearchPanel() {
        searchPanel.setLayout(new BorderLayout());
        searchPanel.setBorder(new EmptyBorder(20,20,20,20));

        JPanel searchLine = new JPanel();
        searchLine.setLayout(new BoxLayout(searchLine,BoxLayout.X_AXIS));
        JTextField searchTextField = new JTextField();
        JButton searchButton = new JButton("Search text");
        searchLine.add(searchTextField);
        searchLine.add(searchButton);

        searchPanel.add(searchLine,BorderLayout.PAGE_START);


        setupSearchListPanel();
        searchPanel.add(searchListPanel);
    }

    private void setupSearchListPanel() {
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list,BoxLayout.Y_AXIS));

        for(int i = 0;i < 100; ++i) {
            JLabel label = new JLabel("Label item #" + i);
            int lft = (i % 10) == 0 ? 0 : 25;
            label.setBorder(new EmptyBorder(0,lft,5,0));
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    System.out.println(label.getText());
                }
            });
            list.add(label);
        }

        searchListPanel = new JScrollPane(list);
        searchListPanel.setBorder(new EmptyBorder(20,0,0,0));
    }

    private void setupButtonPanel() {
        centerButtonPanel.setLayout(new GridBagLayout());
        centerButtonPanel.setBorder(new EmptyBorder(20,20,20,0));

        buttonPanel.setLayout(new GridLayout(0,1,0,10));

        JButton addProduct = new JButton("Add new product");
        JButton addGroup = new JButton("Add new group");
        JButton changeProduct = new JButton("Update product");
        JButton statistic = new JButton("Statistics");
        JButton exportFile = new JButton("Export to file");

        buttonPanel.add(addProduct);
        buttonPanel.add(addGroup);
        buttonPanel.add(changeProduct);
        buttonPanel.add(statistic);
        buttonPanel.add(exportFile);

        centerButtonPanel.add(buttonPanel);


        addGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddGroupFrame();
            }
        });
    }


}
