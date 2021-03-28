package homework.hw9;

import utils.data.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameFrame extends JFrame {
    JPanel verticalPanel;
    private int maxValue;
    private int numOfProblems;
    private ProblemComponent[] problems;
    private int[] answers;

    GameFrame(int maxValue, int numOfProblems) {
        this.maxValue = maxValue;
        this.numOfProblems = numOfProblems;
        problems = new ProblemComponent[numOfProblems];
        answers = new int[numOfProblems];

        verticalPanel = new JPanel(new GridLayout(numOfProblems + 1, 1));

        for (int i = 0; i < numOfProblems; ++i) {
            createProblem(i);
        }

        JButton checkButton = new JButton("Check");
        verticalPanel.add(checkButton);
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cntCorrect = 0;
                for(int i = 0;i < numOfProblems; ++i){
                    try{
                        int ans = Integer.parseInt(problems[i].getAnswer());
                        boolean isEqual = ans == answers[i];
                        problems[i].setIsCorrect(isEqual);
                        cntCorrect += isEqual ? 1 : 0;
                    }catch (Exception ex){
                        problems[i].setIsCorrect(false);
                    }
                }
                checkButton.setEnabled(false);
                checkButton.setText(String.format("%d / %d",cntCorrect,numOfProblems));
            }
        });

        add(verticalPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, (numOfProblems + 3) * 35);
        setVisible(true);

    }

    private void createProblem(int id) {
        Random rnd = new Random();
        answers[id] = rnd.nextInt(maxValue);
        problems[id] = new ProblemComponent(generateProblemString(answers[id]));
        verticalPanel.add(problems[id]);
    }

    private String generateProblemString(int answer) {
        Random rnd = new Random();
        if(rnd.nextBoolean()){
            if(rnd.nextBoolean()){
                Pair<Integer,Integer> pr = getPairSum(answer);
                if(rnd.nextBoolean()){
                    Pair<Integer,Integer> pr2 = getPairSum(pr.second);
                    return String.format("%d + %d + %d = ", pr.first,pr2.first,pr2.second);
                }else{
                    Pair<Integer,Integer> pr2 = getPairSub(pr.second);
                    return String.format("%d + %d - %d = ", pr.first,pr2.first,pr2.second);
                }
            }else{
                if(rnd.nextBoolean()){
                    Pair<Integer, Integer> pr = getPairSum(answer);
                    Pair<Integer,Integer> pr2 = getPairSub(pr.first);
                    return String.format("%d - %d + %d = ", pr2.first,pr2.second,pr.second);
                }else{
                    Pair<Integer, Integer> pr = getPairSub(answer);
                    Pair<Integer,Integer> pr2 = getPairSub(pr.first);
                    return String.format("%d - %d - %d = ", pr2.first,pr2.second,pr.second);
                }
            }
        }else{
            if(rnd.nextBoolean()){
               Pair<Integer,Integer> pr = getPairSum(answer);
               return String.format("%d + %d = ", pr.first,pr.second);
            }else{
                Pair<Integer,Integer> pr = getPairSub(answer);
                return String.format("%d - %d = ", pr.first,pr.second);
            }
        }
    }

    private Pair<Integer, Integer> getPairSum(int sum) {
        Random rnd = new Random();
        int fst = rnd.nextInt(sum + 1);
        return new Pair<>(fst, sum - fst);
    }

    private Pair<Integer, Integer> getPairSub(int sub) {
        Random rnd = new Random();
        int fst = rnd.nextInt(100 - sub);
        return new Pair<>(fst + sub,fst);
    }
}
