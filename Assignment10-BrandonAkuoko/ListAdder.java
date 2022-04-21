
import java.util.ArrayList;
import java.util.List;


public class ListAdder implements Runnable {

    private static final int NUMBER_TO_ADD = 1000;

    private List<Integer> list;

    public ListAdder(List<Integer> list) {
        this.list = list;
    }

   
    @Override
    public void run() {
        for (int i = 0; i < NUMBER_TO_ADD; i++) {
            list.add(i);
        }
    }

    
    public static void main(String[] args) {
        int numberOfThreads = 10;

        List<Integer> list = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
       
        for (int i = 0; i < numberOfThreads; i++) {
            ListAdder adder = new ListAdder(list);
            Thread thread = new Thread(adder);
            thread.start();
            threads.add(thread);
        }
// use join() to wait for all of the other threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // this will never happen, so squash it
            }
        }
        
        // print the number of integers successfully added
        System.out.println("size (should be " 
            + (numberOfThreads * NUMBER_TO_ADD) + "): " 
            + list.size());
    }
}
