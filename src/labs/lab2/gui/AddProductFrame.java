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

public class AddProductFrame extends JFrame{
    JTextField nameField;
    JTextArea descriptionArea;
    JTextField manufacturerField;
    JTextField amountField;
    JTextField priceField;
    JComboBox<String> groupBox;

    private Product product;
    private Group group;
    private Group actualGroup;
    private IOnRefreshList frame;


    public AddProductFrame(IOnRefreshList frame){
        product = null;
        this.frame = frame;
        init();
    }

    public AddProductFrame(IOnRefreshList frame, Group group, Product product){
        group = Database.getInstance().getGroupByName(group.getName());
        this.group = group;
        this.product = product;
        this.frame = frame;
        init();
    }

    private JPanel mainPanel;

    private void init() {
        setTitle("Adding a product");
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridwidth = 2;
        c.insets = new Insets(0,10,10,10);

        JLabel title = new JLabel("Add new product",SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(18f));
        title.setBorder(new EmptyBorder(10,0,15,0));
        mainPanel.add(title,c);

        nameField = createField("Name:",product == null ? null : product.getName(),1);
        manufacturerField = createField("Manufacturer:",product == null ? null : product.getManufacturer(),4);
        amountField = createField("Amount:",product == null ? null : Double.toString(product.getAmount()),5);
        priceField = createField("Price:",product == null ? null : Double.toString(product.getPriceSingle()),6);


        c.gridx = 0;
        c.gridy = 2;
        JLabel descLabel = new JLabel("Description:");
        mainPanel.add(descLabel,c);

        c.gridx = 1;
        c.gridy = 2;
        descriptionArea = new JTextArea(product == null ? null : product.getDescription(),5,20);
        JScrollPane descriptionScroll = new JScrollPane(descriptionArea);
        mainPanel.add(descriptionScroll,c);

        c.gridx = 0;
        c.gridy = 3;
        JLabel groupLabel = new JLabel("Group:");
        mainPanel.add(groupLabel,c);

        c.gridx = 1;
        c.gridy = 3;
        Vector<String> groups = new Vector<>();
        int id = 0,saveId = 0;
        for(Group gr : Database.getInstance().getGroups()){
            groups.add(gr.getName());
            if(group != null && gr.getName().equals(group.getName())){
                saveId = id;
                actualGroup = gr;
            }
            ++id;
        }
        groupBox = new JComboBox<>(groups);
        if(!groups.isEmpty())groupBox.setSelectedIndex(saveId);
        mainPanel.add(groupBox,c);

        JButton submit = new JButton("OK");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String validate = onValidate();
                if(validate != null){
                    JOptionPane.showMessageDialog(null,validate,"Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double amount = 1;
                if(!amountField.getText().isBlank()) amount = Double.parseDouble(amountField.getText());
                Product nProduct = new Product(Util.removeEndSpaces(nameField.getText()),
                        descriptionArea.getText().isBlank() ? null : descriptionArea.getText(),
                        Util.removeEndSpaces(manufacturerField.getText()),
                        amount,Double.parseDouble(priceField.getText()));
                Group group = Database.getInstance().getGroupByName((String)groupBox.getSelectedItem());
                if(product == null){
                    group.addProduct(nProduct);
                }else{
                    actualGroup.removeProduct(product);
                    group.addProduct(product);
                    product.setAllFields(nProduct);
                }
                frame.refreshList();
                dispose();
            }
        });

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 7;
        mainPanel.add(submit,c);

        if (product != null) {
            JButton remove = new JButton("Remove");
            remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actualGroup.removeProduct(product);
                    frame.refreshList();
                    dispose();
                }
            });

            c.gridwidth = 2;
            c.gridx = 0;
            c.gridy = 8;
            mainPanel.add(remove, c);
        }


        add(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400,450);
        Util.centerFrame(this);
        setVisible(true);

    }

    private JTextField createField(String title, String defaultValue, int posY){
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridy = posY;
        if(posY == 6)c.weighty = 1000;
        c.insets = new Insets(0,10,10,10);

        JLabel label = new JLabel(title);
        mainPanel.add(label,c);

        c.gridx = 1;
        c.weightx = 2.8;

        JTextField field = new JTextField(defaultValue,1);
        mainPanel.add(field,c);
        return field;
    }

    private String onValidate(){
        StringBuilder ret = new StringBuilder();
        if(nameField.getText().isBlank())ret.append("Name can't be empty\n");else
        if(groupBox.getSelectedIndex() == -1)ret.append("Create new group\n");
        if((product == null || (!product.getName().equals(Util.removeEndSpaces(nameField.getText()))))
                && !Database.getInstance().isNameUnique(Util.removeEndSpaces(nameField.getText()), DBItem.PRODUCT))
            ret.append("Name should be unique\n");
        try{
            double val = Double.parseDouble(priceField.getText());
            if(val < 0)ret.append("Price can't be less than 0\n");
        }catch (Exception e){
            ret.append("Enter correct price\n");
        }
        try{
            if(!amountField.getText().isBlank()) {
                double val = Double.parseDouble(amountField.getText());
                if (val < 0) ret.append("Amount can't be less than 0\n");
            }
        }catch (Exception e){
            ret.append("Enter correct amount\n");
        }

        if(ret.isEmpty())return null;
        return ret.deleteCharAt(ret.length() - 1).toString();
    }

}
