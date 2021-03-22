package homework.hw8;

import java.util.Arrays;

public class StringSeparator {
    private String base;
    private String[] words;
    private String[] uniqueWords;
    private int[] cnt;

    public StringSeparator(String base){
        this.base = base;
        separate();
        generateUnique();
        generateCnt();
    }

    private void separate(){
        words = base.split("[\\s,.:;!?]");
        int cnt = 0;
        for(int i = 0;i < words.length; ++i){
            if(words[i].isEmpty() || words[i].equals("-"))continue;
            cnt++;
        }
        String[] newW = new String[cnt];
        cnt = 0;
        for(int i = 0;i < words.length; ++i){
            if(words[i].isEmpty() || words[i].equals("-"))continue;
            newW[cnt++] = words[i];
        }
        words = newW;
    }

    private void generateUnique(){
        String[] tmp = new String[words.length];
        int[] tmpCnt = new int[words.length];
        int tmpLen = 0;
        for(int i = 0;i < words.length; ++i){
            boolean isCopy = false;
            for(int j = 0;j < tmpLen; ++j){
                if(tmp[j].equals(words[i])){isCopy = true;tmpCnt[j]++;break;}
            }
            if(!isCopy)tmp[tmpLen++] = words[i];
        }
        uniqueWords = new String[tmpLen];
        cnt = new int[tmpLen];
        for(int i = 0;i < tmpLen; ++i){
            uniqueWords[i] = tmp[i];
            cnt[i] = tmpCnt[i] + 1;
        }
        Arrays.sort(uniqueWords,(a,b) -> {
            return a.toLowerCase().compareToIgnoreCase(b);
        });
    }

    private void generateCnt(){
        cnt = new int[uniqueWords.length];
        for(int i = 0;i < words.length; ++i){
            for(int j = 0;j < uniqueWords.length; ++j){
                if(uniqueWords[j].equals(words[i])){
                    cnt[j]++;
                    break;
                }
            }
        }
    }

    public int cntWords(){
        return words.length;
    }

    public long cntUniqueWords(){
        return uniqueWords.length;
    }

    public String[] getUniqueWords(){
        return uniqueWords;
    }

    public int[] getCnt(){
        return cnt;
    }
}
