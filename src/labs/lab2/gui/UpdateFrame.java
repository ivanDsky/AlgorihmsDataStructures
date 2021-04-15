package labs.lab2.gui;

import labs.lab2.Util;
import labs.lab2.data.DBItem;
import labs.lab2.data.Database;
import labs.lab2.data.Group;
import labs.lab2.data.Product;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class UpdateFrame extends JFrame {
    IOnRefreshList frame;
    JPanel mainPanel;
    JTextField amountField;
    JComboBox<String> groupBox;
    JComboBox<String> productBox;
    JCheckBox addBox;
    JLabel valueLabel = new JLabel();

    private Group selectedGroup;
    private Product selectedProduct;
    private final GridBagConstraints c = new GridBagConstraints();

    UpdateFrame(IOnRefreshList frame) {
        this.frame = frame;
        mainPanel = new JPanel(new GridBagLayout());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridwidth = 2;
        c.insets = new Insets(0, 10, 10, 10);

        JLabel title = new JLabel("Update product", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(18f));
        title.setBorder(new EmptyBorder(10,0,15,0));
        mainPanel.add(title, c);


        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        JLabel groupLabel = new JLabel("Group:");
        mainPanel.add(groupLabel, c);

        setupGroup();

        c.gridx = 0;
        c.gridy = 2;
        JLabel productLabel = new JLabel("Product:");
        mainPanel.add(productLabel, c);

        c.gridx = 0;
        c.gridy = 3;
        addBox = new JCheckBox("Add:",true);
        mainPanel.add(addBox,c);
        c.gridx = 1;
        JCheckBox removeBox = new JCheckBox("Remove:");
        mainPanel.add(removeBox,c);

        addBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBox.setSelected(!addBox.isSelected());
            }
        });
        removeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBox.setSelected(!removeBox.isSelected());
            }
        });

        c.gridx = 0;
        c.gridy = 4;
        c.weighty = 1000;
        valueLabel = new JLabel("Value:");
        mainPanel.add(valueLabel,c);
        c.gridx = 1;
        amountField = new JTextField();
        mainPanel.add(amountField,c);



        JButton submit = new JButton("OK");
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String validate = onValidate();
                if(validate != null){
                    JOptionPane.showMessageDialog(null,validate,"Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double amount = Double.parseDouble(amountField.getText());
                if(addBox.isSelected())selectedProduct.setAmount(selectedProduct.getAmount() + amount);
                else selectedProduct.setAmount(selectedProduct.getAmount() - amount);

                frame.refreshList();
                dispose();

            }
        });

        mainPanel.add(submit,c);


        add(mainPanel);
        setSize(400, 400);
        Util.centerFrame(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Update product");
        setVisible(true);
    }

    private void setupProduct(Group group) {
        Vector<String> products = new Vector<>();
        for (Product pr : group.getProducts()) {
            products.add(pr.getName());
        }
        if(productBox != null)mainPanel.remove(productBox);
        productBox = new JComboBox<>(products);
        if (products.size() > 0) {
            productBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedProduct = group.getProducts().get(productBox.getSelectedIndex());
                    valueLabel.setText(String.format("Value[0..%.1f]",selectedProduct.getAmount()));
                }
            });
            productBox.setSelectedIndex(0);
        }
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 2.8;
        mainPanel.add(productBox,c);
        mainPanel.updateUI();
    }

    private void setupGroup() {
        Vector<String> groups = new Vector<>();
        for (Group gr : Database.getInstance().getGroups()) {
            groups.add(gr.getName());
        }
        groupBox = new JComboBox<>(groups);

        if (groups.size() > 0) {
            groupBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedGroup = Database.getInstance().getGroups().get(groupBox.getSelectedIndex());
                    setupProduct(selectedGroup);
                }
            });
            groupBox.setSelectedIndex(0);
        }

        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(groupBox,c);
        mainPanel.updateUI();
    }

    private String onValidate(){
        StringBuilder ret = new StringBuilder();
        if(groupBox.getSelectedIndex() == -1)ret.append("Create new group\n");else
        if(productBox.getSelectedIndex() == -1)ret.append("Select product\n");else
        try{
            double val = Double.parseDouble(amountField.getText());
            if (val < 0) ret.append("Amount can't be less than 0\n");
            if(selectedProduct.getAmount() < val && !addBox.isSelected())ret.append("Amount can't be less than in stock");
        }catch (Exception e){
            ret.append("Enter correct amount\n");
        }

        if(ret.isEmpty())return null;
        return ret.deleteCharAt(ret.length() - 1).toString();
    }
}
