package ds;

import java.util.Iterator;
/**
 * This class is used to create the default class for a range iteration
 * @author Brandon Akuoko
 */
public class RangeIterator implements Iterator<Integer>{

    private final Range range;
    private int index; //marker

    public RangeIterator(Range range){
        this.range = range;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {return index < range.size();}

    @Override
    public Integer next() {
        int value = range.get(index);
        index++;
        return value;
    }
    
}
