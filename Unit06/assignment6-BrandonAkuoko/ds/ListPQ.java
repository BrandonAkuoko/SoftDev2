package ds;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class ListPQ implements Queue<Integer>{
    private LinkedList<Integer> list;
    private int size;

    public ListPQ(LinkedList<Integer> list, int size){
        this.list = list;
        this.size = size;
    }


    @Override
    public void enqueue(Integer value) {
        list.add(value);
        size++;
    }

    @Override
    public Integer dequeue() {
        Collections.sort(list);
        size--;
        return list.removeFirst();
    }

    @Override
    public int size() {return this.size;}
    
}
