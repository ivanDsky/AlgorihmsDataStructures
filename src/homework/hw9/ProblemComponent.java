package homework.hw9;

import javax.swing.*;
import java.awt.*;

public class ProblemComponent extends JPanel {

    JTextField answerField = new JTextField();

    ProblemComponent(String question) {

        JLabel questionLabel = new JLabel(question);
        answerField.setColumns(20);

        add(questionLabel);
        add(answerField);

        setVisible(true);

    }

    public void setIsCorrect(boolean isCorrect){
        answerField.setEnabled(false);
        answerField.setDisabledTextColor(isCorrect ? Color.GREEN : Color.RED);
    }

    public String getAnswer(){
        return answerField.getText();
    }

}
