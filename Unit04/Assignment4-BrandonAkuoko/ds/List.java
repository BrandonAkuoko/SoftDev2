package ds;

import java.util.Iterator;
import java.util.*;

public interface List<E> extends Iterable<E>{
    void append(E value);
    E get(int index);
    void set(int index, E value);
    int size();
    default Iterator<E> iterator(){
        throw new UnsupportedOperationException("unsupported");
    }
    // inherit abstract Iterator() method


    
}