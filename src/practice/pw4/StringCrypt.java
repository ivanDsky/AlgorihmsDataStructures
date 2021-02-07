package practice.pw4;

public class StringCrypt {
    private String origin;
    private String crypt;

    public StringCrypt() {

    }

    public StringCrypt(String origin){
        this.origin = origin;
    }

    public StringCrypt(String origin,int shift){
        this.origin = origin;
        encrypt(shift);
    }

    public String getCrypt() {
        return crypt;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
        crypt = origin;
    }

    public String encrypt(int shift){
        crypt = "";
        for(int i = 0;i < origin.length(); ++i){
            crypt += (char)(origin.charAt(i) + shift);
        }
        return getCrypt();
    }
}
