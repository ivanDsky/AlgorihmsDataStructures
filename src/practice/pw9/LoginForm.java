package practice.pw9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private LoginController controller = new LoginController();

    LoginForm() {
        super("Login");

        JLabel loginLabel = new JLabel("Login");
        JLabel passwordLabel = new JLabel("Password");

        JTextField loginField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton sendButton = new JButton("OK");
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(sendButton);

        JPanel verticalPanel = new JPanel(new GridLayout(5, 1));

        verticalPanel.add(loginLabel);
        verticalPanel.add(loginField);
        verticalPanel.add(passwordLabel);
        verticalPanel.add(passwordField);
        verticalPanel.add(buttonPanel);

        add(verticalPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        setVisible(true);

       sendButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               onSendCLick(loginField.getText(),new String(passwordField.getPassword()));
           }
       });
    }

    public void onSendCLick(String login,String password){
        String secretInformation = controller.onSendClick(login,password);
        if(secretInformation == null){
            System.out.println("Incorrect input data");
            JOptionPane.showMessageDialog(this,"Incorrect input data","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            System.out.println(secretInformation);
            JOptionPane.showMessageDialog(this,secretInformation,"Secret info",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
