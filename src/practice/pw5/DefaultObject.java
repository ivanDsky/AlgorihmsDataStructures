package practice.pw5;

public class DefaultObject {
    private String name;

    public String getName() {
        return name;
    }

    DefaultObject(){
        name = "no name";
    }

    DefaultObject(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
