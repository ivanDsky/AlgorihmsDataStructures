package utils.data;

public class Pair<T,V> {
    public T first;
    public V second;

    public Pair(T fst, V snd){
        first = fst;
        second = snd;
    }

    @Override
    public String toString() {
        return "{" + first + ", " + second + "}";
    }
}
