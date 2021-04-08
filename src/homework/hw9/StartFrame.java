package homework.hw9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class StartFrame extends JFrame {
    StartFrame() {
        JLabel maxValueLabel = new JLabel("Maximum value of answer");

        JLabel numberOfProblemsLabel = new JLabel("Number of problems");
        JLabel errorLabel = new JLabel();
        errorLabel.setVisible(false);

        JButton sendButton = new JButton("OK");


        JPanel maxValuePanel = new JPanel(new FlowLayout());
        JSlider maxValueSlider = new JSlider(0, 100);
        maxValuePanel.add(maxValueLabel);
        maxValuePanel.add(maxValueSlider);
        maxValueSlider.setMajorTickSpacing(20);
        maxValueSlider.setMinorTickSpacing(10);
        maxValueSlider.setPaintTicks(true);
        maxValueSlider.setSnapToTicks(true);
        maxValueSlider.setPaintLabels(true);

        JPanel numberOfProblemsPanel = new JPanel(new FlowLayout());
        JSlider numberOfProblemsSlider = new JSlider(0, 10);
        numberOfProblemsPanel.add(numberOfProblemsLabel);
        numberOfProblemsPanel.add(numberOfProblemsSlider);
        numberOfProblemsSlider.setMajorTickSpacing(2);
        numberOfProblemsSlider.setPaintTicks(true);
        numberOfProblemsSlider.setPaintLabels(true);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(sendButton);

        JPanel verticalPanel = new JPanel(new GridLayout(4, 1));
        verticalPanel.add(maxValuePanel);
        verticalPanel.add(numberOfProblemsPanel);
        verticalPanel.add(buttonPanel);
        verticalPanel.add(errorLabel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSendClick(maxValueSlider.getValue(),numberOfProblemsSlider.getValue());
            }
        });

        add(verticalPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 250);
        setVisible(true);
        
    }

    private void onSendClick(int maxValue,int numberOfProblems){
        setVisible(false);
        JFrame gameFrame = new GameFrame(maxValue,numberOfProblems);
    }
}
