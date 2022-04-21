public class Counting5 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new CounterThread("Counter thread " + (i+1));
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                //TODO: handle exception
            }
        }
        System.out.println("Counting is all done");
    }
}
