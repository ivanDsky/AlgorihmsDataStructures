package labs.lab2.gui;

import labs.lab2.Util;
import labs.lab2.data.Database;
import labs.lab2.data.Group;
import labs.lab2.data.Product;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

import static labs.lab2.Util.toPattern;

public class MainFrame extends JFrame implements IOnRefreshList {
    JPanel mainPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel centerButtonPanel = new JPanel();
    JPanel searchPanel = new JPanel();
    JTextField searchTextField;
    JScrollPane searchListPanel;
    private final MainFrame thisFrame;
    //TODO only one open edit window

    public MainFrame() {
        thisFrame = this;
        setupDatabase();
        setupButtonPanel();
        setupSearchPanel();
        setupMainPanel();
    }

    private void setupDatabase() {
        Database.getInstance().addGroup(new Group("Test"));

        Group prod = new Group("Prod");
        prod.addProduct(new Product("Flour", 15.0));
        prod.addProduct(new Product("Oil", 15.0));
        prod.addProduct(new Product("Rice", 150.0));

        Group unprod = new Group("Unprod");
        unprod.addProduct(new Product("Soap", 20.0));
        unprod.addProduct(new Product("Napkin", "Napkins for kitchen", "Kyiv-Napkins", 20, 3));

        Database.getInstance().addGroup(prod);
        Database.getInstance().addGroup(unprod);
//        Database.getInstance().getGroups().get(2).removeProduct(prod.getProducts().get(1));
        Pattern p = Pattern.compile("");
        Database patternDB = Database.getInstance().databaseMatchPattern(".*l.*").databaseMatchPattern(".*r");
    }

    private void setupMainPanel() {
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(centerButtonPanel, BorderLayout.WEST);
        mainPanel.add(searchPanel);
        add(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        Util.centerFrame(this);
        setVisible(true);
    }

    private void setupSearchPanel() {
        searchPanel.setLayout(new BorderLayout());
        searchPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel searchLine = new JPanel();
        searchLine.setLayout(new BoxLayout(searchLine, BoxLayout.X_AXIS));
        searchTextField = new JTextField();
        searchTextField.setToolTipText("Enter search query");
        searchTextField.setFont(searchTextField.getFont().deriveFont(16f));
        searchTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                refreshList();
            }
        });

        searchLine.add(searchTextField);

        searchPanel.add(searchLine, BorderLayout.PAGE_START);

        refreshList();
        searchPanel.add(searchListPanel);
    }

    private void setupSearchListPanel(Database db) {
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));

        for (Group gr : db.getGroups()) {
            JLabel label = new JLabel(gr.getName());
            label.setBorder(new EmptyBorder(0, 0, 5, 0));
            label.setFont(label.getFont().deriveFont(18f));
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    new AddGroupFrame(thisFrame, gr);
                }
            });
            list.add(label);
            for (Product pr : gr.getProducts()) {
                JLabel label1 = new JLabel(pr.getName());
                label1.setBorder(new EmptyBorder(0, 25, 5, 0));
                label1.setFont(label.getFont().deriveFont(14f));
                label1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
                        new AddProductFrame(thisFrame, gr, pr);
                    }
                });
                list.add(label1);
            }
        }

        searchListPanel = new JScrollPane(list);
        searchListPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
    }

    private void setupButtonPanel() {
        centerButtonPanel.setLayout(new GridBagLayout());
        centerButtonPanel.setBorder(new EmptyBorder(20, 20, 20, 0));

        buttonPanel.setLayout(new GridLayout(0, 1, 0, 10));

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
                new AddGroupFrame(thisFrame);
            }
        });

        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddProductFrame(thisFrame);
            }
        });

        statistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatisticsFrame();
            }
        });

        exportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = "src/labs/lab2/File";
                Database.getInstance().saveToFile(path);
                JOptionPane.showMessageDialog(null,"Database exported to " + path,"Export",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public void refreshList() {
        if (searchListPanel != null) searchPanel.remove(searchListPanel);
        String pattern = toPattern(searchTextField.getText());
        if (searchTextField.getText().isBlank()) {
            setupSearchListPanel(Database.getInstance());
        } else {
            setupSearchListPanel(Database.getInstance().databaseMatchPattern(pattern));
        }
        searchPanel.add(searchListPanel);
        searchPanel.invalidate();
        searchPanel.updateUI();
    }


}
