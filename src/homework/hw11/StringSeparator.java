package homework.hw11;

import java.util.ArrayList;
import java.util.HashMap;

public class StringSeparator {
    private String base;
    public ArrayList<String> words;
    public ArrayList<String> uniqueWords;
    public HashMap<String, Integer> uniqueWordsMap;

    public StringSeparator(String base) {
        this.base = base;
        System.out.println("Start separate file");
        separate();
        generateUnique();
        System.out.println("End separate file");
    }

    private void separate() {
        words = new ArrayList<>();
        for (String word : base.split("[\\s,.:;!?]")) {
            if (!word.isEmpty()) words.add(word);
        }
    }

    private void generateUnique() {
        uniqueWordsMap = new HashMap<>();
        for (String word : words) {
            int val = uniqueWordsMap.containsKey(word) ? uniqueWordsMap.get(word) + 1 : 1;
            uniqueWordsMap.put(word, val);
        }
        uniqueWords = new ArrayList<>();
        uniqueWords.addAll(uniqueWordsMap.keySet());
    }
}
