package practice.pw13;

import java.util.LinkedList;

public class Tester {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
        for(int i = 0; i < 5; ++i){
            list.pushBack(i);
        }
        System.out.println(list);
        list.removeByIndex(3);
        System.out.println(list);
        list.pushAfter(0,5);
        list.pushBefore(0,3);
        System.out.println(list);
        list.pushAfter(list.getSize() - 1, 3);
        list.pushFront(17);
        list.pushBack(20);
        System.out.println(list);
        list.clear();
        System.out.println("Is list empty - " + list.isEmpty() + ", " + list);
        list.pushFront(10);
        list.pushFront(-1);
        list.pushBack(20);
        System.out.println("Is list empty - " + list.isEmpty() + ", " + list);
        System.out.println("Contains -1 - " + list.contains(-1) + ", contains 0 - " + list.contains(0));

        System.out.println("--------------------------------");

        CustomLinkedList<Double> listD = new CustomLinkedList<Double>();
        for(int i = 0; i < 5; ++i){
            listD.pushBack((double)i);
        }
        System.out.println(listD);
        listD.removeByIndex(3);
        System.out.println(listD);
        listD.pushAfter(0,(double)5);
        listD.pushBefore(0,(double)3);
        System.out.println(listD);
        listD.pushAfter(listD.getSize() - 1, (double)3);
        listD.pushFront((double)17);
        listD.pushBack((double)20);
        System.out.println(listD);
        listD.clear();
        System.out.println("Is list empty - " + listD.isEmpty() + ", " + listD);
        listD.pushFront((double)10);
        listD.pushFront((double)-1);
        listD.pushBack((double)20);
        System.out.println("Is list empty - " + listD.isEmpty() + ", " + listD);
        System.out.println("Contains -1 - " + listD.contains(-1.0) + ", contains 0 - " + listD.contains(0.0));
    }
}
