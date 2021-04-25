package practice.pw13;

import java.util.LinkedList;
import java.util.List;

public class CustomLinkedList<T>{
    private Node first,last;
    private int size;

    CustomLinkedList(){
        first = last = null;
        size = 0;
    }

    private class Node{
        Node prev;
        Node next;
        T data;

        Node(){
            prev = next = null;
            data = null;
        }

        Node(T data){
            this();
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void pushBack(T data){
        pushBack(new Node(data));
    }

    public void pushBack(Node newLast){
        size++;
        if(last == null){
            addInEmpty(newLast);
            return;
        }
        newLast.prev = last;
        last.next = newLast;
        last = newLast;
    }

    public void pushFront(T data){
        pushFront(new Node(data));
    }

    public void pushFront(Node newFirst){
        size++;
        if(first == null){
            addInEmpty(newFirst);
            return;
        }
        newFirst.next = first;
        first.prev = newFirst;
        first = newFirst;
    }

    private void addInEmpty(Node add){
        first = last = add;
    }

    public Node getByIndex(int index){
        if(index < 0 || index >= size)return null;
        Node current = first;
        while(index > 0){
            current = current.next;
            index--;
        }
        return current;
    }

    public void removeByIndex(int index){
        if(index < 0 || index >= size)return;
        Node current = getByIndex(index);
        remove(current);
    }

    public void remove(Node node){
        if(getSize() == 1){
            clear();
        }else{
            if(node.next == null){
                node.prev.next = null;
            }else
            if(node.prev == null){
                node.next.prev = null;
            }else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }
    }

    public void pushAfter(int index, T data){
        pushAfter(getByIndex(index),data);
    }

    public void pushAfter(Node prevNode, T data){
        pushAfter(prevNode,new Node(data));
    }

    public void pushAfter(Node prevNode,Node newNode){
        if(prevNode == null || newNode == null)return;
        size++;
        Node afterNext = prevNode.next;
        prevNode.next = newNode;
        newNode.next = afterNext;
        newNode.prev = prevNode;
        if(afterNext != null)afterNext.prev = newNode;
        else last = newNode;
    }

    public void pushBefore(int index, T data){
        pushBefore(getByIndex(index),data);
    }

    public void pushBefore(Node nextNode, T data){
        pushBefore(nextNode, new Node(data));
    }

    public void pushBefore(Node nextNode,Node newNode){
        if(newNode == null || nextNode == null)return;
        size++;
        Node beforePrev = nextNode.prev;
        nextNode.prev = newNode;
        newNode.next = nextNode;
        newNode.prev = beforePrev;
        if(beforePrev != null)beforePrev.next = newNode;
        else first = newNode;
    }

    public int getSize(){
        return size;
    }

    public Node getFirst(){
        return first;
    }

    public Node getLast(){
        return last;
    }

    public void clear(){
        first = last = null;
        size = 0;
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    public boolean contains(T data){
        Node current = first;
        for(int i = 0;i < size; ++i,current = current.next){
            if(data.equals(current.data))return true;
        }
        return false;
    }

    public boolean contains(Node node){
        Node current = first;
        for(int i = 0;i < size; ++i,current = current.next){
            if(node.equals(current))return true;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node current = first;
        while(current != null){
            builder.append(current).append(',').append(' ');
            current = current.next;
        }
        if(first != null)builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append(']');
        return builder.toString();
    }
}
