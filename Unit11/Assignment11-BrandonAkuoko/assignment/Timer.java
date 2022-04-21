package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Timer
 * - Vector finished faster.
 */
public class Timer {

    public static void function(String name, List<Integer> list, int numberOfValues) {

        long start = System.nanoTime();
        for (int i = 0; i < numberOfValues; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        System.out.println("Filled " + name + " with " + numberOfValues + " in " + (end - start) + " nanoseconds.");
    }
    public static void main(String[] args) throws InterruptedException {
        List<Integer> v = new Vector<>();
        List<Integer> a = new ArrayList<>();
        function("Vector", v, 100000000);
        function("ArrayList", a, 100000000);
        Thread.sleep(1000);
    }
}