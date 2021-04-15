package labs.lab2.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
        JList<String> list = new JList(new String[]{
                "First item","Second item","Third item",
                "First item","Second item","Third item",
                "First item","Second item","Third item",
                "First item","Second item","Third item",
                "First item","Second item","Third item",
                "First item","Second item","Third item",
                "First item","Second item","Third item"
        });

        searchListPanel = new JScrollPane(list);
        searchListPanel.setBorder(new EmptyBorder(20,0,0,0));
    }

    private void setupButtonPanel() {
        centerButtonPanel.setLayout(new GridBagLayout());
        centerButtonPanel.setBorder(new EmptyBorder(20,20,20,0));

        buttonPanel.setLayout(new GridLayout(0,1,0,10));
        JButton btn1 = new JButton("Add new product");
        btn1.setMaximumSize(new Dimension(100,10));
        buttonPanel.add(btn1);
        buttonPanel.add(new JButton("Text1"));
        buttonPanel.add(new JButton("Text2"));
        buttonPanel.add(new JButton("Text3"));

        centerButtonPanel.add(buttonPanel);
    }


}
