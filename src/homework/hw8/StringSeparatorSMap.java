package homework.hw8;

import java.util.*;

public class StringSeparatorSMap extends StringSeparator{
    public StringSeparatorSMap(String base) {
        super(base);
        this.base = base;
        separate();
    }

    private String base;

    private HashMap<String,Integer> map = new HashMap<>();


    private void separate(){
        String[] words = base.split("[\\s,.:;!?]");
        for(int i = 0;i < words.length; ++i){
            if(words[i].isEmpty() || words[i].equals("-"))continue;
            if(!map.containsKey(words[i])){
                map.put(words[i],1);
            }else{
                map.put(words[i],map.get(words[i]) + 1);
            }
        }
    }

    @Override
    public int cntWords() {
        int ret = 0;
        for(Map.Entry<String, Integer> item : map.entrySet()){
            ret += item.getValue();
        }
        return ret;
    }

    @Override
    public long cntUniqueWords() {
        return map.size();
    }

    @Override
    public String[] getUniqueWords() {
        String[] unique = new String[(int)cntUniqueWords()];
        int i = 0;
        for(Map.Entry<String, Integer> item : map.entrySet()){
            unique[i++] = item.getKey();
        }
        return unique;
    }

    @Override
    public int[] getCnt() {
        int[] unique = new int[(int)cntUniqueWords()];
        int i = 0;
        for(Map.Entry<String, Integer> item : map.entrySet()){
            unique[i++] = item.getValue();
        }
        return unique;
    }
}
