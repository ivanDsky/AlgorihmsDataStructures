package homework.hw8;

public class Tester {
    private static final String FILE_NAME = "src/homework/hw8/Input.txt";

    public static void main(String[] args) {
        String file = "";
        try{
            file = FileInput.getInput(FILE_NAME);
        }catch (Exception e){
            e.printStackTrace();
        }

        StringSeparator separator = new StringSeparator(file);

        System.out.println("Number of words : " + separator.cntWords());
        System.out.println("Number of unique words : " + separator.cntUniqueWords());

        System.out.println("All words");
        String[] unique = separator.getUniqueWords();
        int[] cnt = separator.getCnt();
        for(int i = 0;i < unique.length; ++i){
            System.out.println(unique[i] + " : " + cnt[i]);
        }

    }
}
