package labs.lab2.gui;

import labs.lab2.Util;
import labs.lab2.data.Database;
import labs.lab2.data.Group;
import labs.lab2.data.Product;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StatisticsFrame extends JFrame {
    private JTextArea textArea;
    private JLabel sumItemLabel;

    StatisticsFrame(){
        setTitle("Statistics");
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));

        JLabel title = new JLabel("Statistics",SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(18f));
        title.setBorder(new EmptyBorder(15,0,25,0));
        mainPanel.add(title,BorderLayout.NORTH);

        JPanel infoPane = new JPanel(new BorderLayout());
        sumItemLabel = new JLabel("",SwingConstants.CENTER);
        sumItemLabel.setFont(sumItemLabel.getFont().deriveFont(20f));
        sumItemLabel.setBorder(new EmptyBorder(0,10,10,0));

        textArea = new JTextArea();
        textArea.setBorder(new EmptyBorder(10,10,10,10));
        textArea.setEditable(false);
        textArea.setFont(textArea.getFont().deriveFont(14f));
        textArea.setTabSize(2);

        infoPane.add(sumItemLabel,BorderLayout.NORTH);
        infoPane.add(new JScrollPane(textArea));

        mainPanel.add(infoPane);


        JPanel groupList = new JPanel();
        groupList.setLayout(new BoxLayout(groupList,BoxLayout.PAGE_AXIS));

        JLabel current = new JLabel("All items");
        current.setBorder(new EmptyBorder(0,10,10,80));
        current.setFont(current.getFont().deriveFont(18f));
        sumItemLabel.setText("All products cost: " + Database.getInstance().getSumPrice());
        textArea.setText("All items\n\n" + Database.getInstance().toString());
        current.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                sumItemLabel.setText("All products cost: " + Database.getInstance().getSumPrice());
                textArea.setText("All items\n\n" + Database.getInstance().toString());
            }
        });
        groupList.add(current);
        for(Group gr : Database.getInstance().getGroups()){
            current = new JLabel(gr.getName());
            current.setBorder(new EmptyBorder(0,25,10,10));
            current.setFont(current.getFont().deriveFont(16f));
            current.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    textArea.setText(gr.toString());
                    sumItemLabel.setText("All group products cost: " + gr.getSumPrice());
                }
            });
            groupList.add(current);
            for(Product pr : gr.getProducts()){
                current = new JLabel(pr.getName());
                current.setBorder(new EmptyBorder(0,40,10,10));
                current.setFont(current.getFont().deriveFont(14f));
                current.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
                        textArea.setText(pr.fullInfo(""));
                        sumItemLabel.setText("Sum cost: " + pr.getPriceAll());
                    }
                });
                groupList.add(current);
            }
        }

        JScrollPane scrollPane = new JScrollPane(groupList);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        mainPanel.add(scrollPane,BorderLayout.WEST);

        add(mainPanel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(900,600);
        Util.centerFrame(this);
        setVisible(true);
    }
}
