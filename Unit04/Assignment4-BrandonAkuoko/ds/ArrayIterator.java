package ds;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    private Object[] elements;
    private int index; //marker
    private int size; 

    public ArrayIterator(Object[] elements, int size){
        this.elements = elements;
        this.index = 0;
        this.size = size;   
    }

    @Override
    public boolean hasNext() {return index < size;}

    @Override
    @SuppressWarnings("unchecked")
    public E next() {
        E value = (E)elements[index];
        index++;
        return value;
    }

    
}
