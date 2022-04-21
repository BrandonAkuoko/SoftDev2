package ds;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E>{
    private Object[] elements;
    private int size; // index for the new elements

    public ArrayList(){
        this.elements = new Object[4];
        this.size = 0;
    }

    @Override
    public void append(E value) { // O(1) --> on average
        //resizing if the array is full
        if(size == elements.length){
           elements = Arrays.copyOf(elements, 2 * elements.length);
        }
        elements[size] = value;
        size++;
    }
    @Override
    public Iterator<E> iterator(){
        return new ArrayIterator<>(elements, size);
    }

    @Override
    public E get(int index){return (E)elements[index];}

    @Override
    public void set(int index, E value) {
        if(index > 0 || index < size){
            elements[index] = value;
        }
    }

    @Override
    public int size() {return this.size;}

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.append(10);
        arrayList.append(100);
        arrayList.append(69);
        arrayList.append(420);
        arrayList.append(42069);
        arrayList.set(0, 45);
        System.out.println(arrayList.get(0));

    }
    
}
