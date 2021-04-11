package homework.hw11;

import utils.data.Pair;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileChooser{
    private File[] files;
    private ArrayList<StringSeparator> separators = new ArrayList<>();
    private StringSeparator allFilesSeparator;


    private static final int MIN_AMOUNT_OF_FIlES = 10;
    private static final int MIN_FILE_SIZE = 150 * 1024;
    private static final String VOCABULARY_PATH = "src/homework/hw11/Vocabulary.txt";


    FileChooser() { }

    public void readFiles() throws Exception{
        files = getFilesFromChooser();
        if(files == null || files.length < MIN_AMOUNT_OF_FIlES)throw new Exception("You need to select " + MIN_AMOUNT_OF_FIlES + " or more files");
        for(File file : files){
            if(!file.isFile())throw new Exception(file.getName() + " is not a file");
            if(file.length() < MIN_FILE_SIZE)throw new Exception(file.getName() + " is too small");
        }
    }

    public void generateVocabulary(){
        StringBuilder allContext = new StringBuilder("");

        int sumFileSize = 0;

        for(File file : files){
            sumFileSize += file.length();
            String context = "";
            try {
                context = FileIO.getInput(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            allContext.append(context).append('\n');
            StringSeparator separator = new StringSeparator(context);
            separators.add(separator);
        }
        allFilesSeparator = new StringSeparator(allContext.toString());
        allFilesSeparator.uniqueWords.sort(String::compareToIgnoreCase);
        StringBuilder vocabulary = new StringBuilder("");
        String dash = "----------------------------------------------------\n";
        System.out.println("Start vocabulary creation");
        for(String word : allFilesSeparator.uniqueWords){
            ArrayList<Pair<String,Integer>> ar = getWordStatistic(word);
            vocabulary.append(dash);
            vocabulary.append(word).append(' ').append(allFilesSeparator.uniqueWordsMap.get(word)).append('\n');
            for(Pair<String,Integer> el : ar){
                vocabulary.append(String.format("\t%d - %s\n",el.second,el.first));
            }
        }
        System.out.println("End vocabulary creation");
        File voc = new File(VOCABULARY_PATH);
        try {
            FileIO.setOutput(voc, vocabulary.toString());
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(vocabulary);
        System.out.printf("All collection size : %d\n" +
                "Vocabulary size : %d\n" +
                "Amount of unique words : %d\n", sumFileSize, voc.length(), allFilesSeparator.uniqueWords.size());
    }

    public ArrayList<Pair<String, Integer>> getWordStatistic(String word){
        ArrayList<Pair<String, Integer>> ret = new ArrayList<>();
        for(int i = 0;i < separators.size(); ++i){
            StringSeparator sep = separators.get(i);
            if(sep.uniqueWordsMap.containsKey(word)){
                ret.add(new Pair<>(files[i].getName(),sep.uniqueWordsMap.get(word)));
            }
        }
        ret.sort((a, b) -> {
            if(a.second > b.second)return -1;else
            if(a.second == b.second)return a.first.compareToIgnoreCase(b.first);else
                return 1;
        });
        return ret;
    }

    private File[] getFilesFromChooser() {
        JFileChooser fileChooser = new JFileChooser("D:");
        fileChooser.setPreferredSize(new Dimension(800,600));
        fileChooser.setMultiSelectionEnabled(true);
        int ret = fileChooser.showOpenDialog(null);
        if (ret == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFiles();
        }else System.exit(0);
        return null;
    }
}

