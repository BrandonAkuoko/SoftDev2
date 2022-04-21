package ds;

import java.util.Iterator;

/**
 * This class is used to create a range that takes in a start, stop and step
 * @author Brandon Akuoko
 */

public class IntRange implements Range {
    private int start;
    private int stop;
    private int step;

    /**
     * Constructor that is used to create an integer range
     * @param start
     * @param stop
     * @param step
     */
    public IntRange(int start, int stop, int step){
        this.start = start;
        this.stop = stop;
        this.step = step;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(this);
    }

    @Override
    public int size() {
        int range = (stop - start);
        int size = (range / step);
        if((range % step) != 0){size += 1;}
        return size;
    }

    @Override
    public int get(int index) {
        if(index == size()){
            return stop;
        }
        return index * step;
    }
    
    public static void main(String[] args) {
        for(int elements : new IntRange(0, 100, 2)){
            System.out.println(elements);
        }
        for(int elements : new IntRange(0, 100, 3)){
            System.out.println(elements);
        }
    }
    
}
