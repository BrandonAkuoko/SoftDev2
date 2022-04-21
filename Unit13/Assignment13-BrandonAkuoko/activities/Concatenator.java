package activities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface Concatenator<E> {
    public void add(E o);
    public void remove(E o);
    public String concatenate();
}
class TraditionalCat<E> implements Concatenator<E>, Iterable<E>{
    private List<E> list;

    public TraditionalCat(){
        list = new ArrayList<>();
    }
    @Override
    public void add(E o) {
        list.add(o);
    }

    @Override
    public void remove(E o) {
        list.remove(o);
        
    }

    @Override
    public String concatenate() {
        String result = "";
        for (E e : list) {
            result+= e;
            
        }
        return result;
    }
    @Override
    public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
}
    
}
public static void main(String[] args) {
    TraditionalCat<Integer> cat = new TraditionalCat<>();
    cat.add(20);
    cat.add(30);
    cat.add(50);
    System.out.println(cat.concatenate());
    // for (Integer string : args) {
        
    // }
}

