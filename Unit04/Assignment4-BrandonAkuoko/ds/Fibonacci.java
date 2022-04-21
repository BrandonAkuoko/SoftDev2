package ds;

import java.util.Iterator;
/**
 * This class implements the famous Fibonacci Sequence
 * @author Brandon Akuoko
 */
public class Fibonacci implements Range {
    private int size;

    public Fibonacci(int size){this.size = size;}

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(this);
    }

    @Override
    public int size() {return size;}

    @Override
    public int get(int number) {
        int f1 = 0;
        int f2 = 1;
        while(number > 1){
            int temp = f1 + f2;
            f1 = f2;
            f2 = temp;
            number--;
        }
        if(number == 0){return f1;}
        else{return f2;}
    }
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci(45);
        System.out.print("First 45 Terms: ");
        for(int elements : fib){
            System.out.print("" + elements + ", ");
        }
    }
}
