public class RunnableCounter implements Runnable{

    private String name;

    public RunnableCounter(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name + ": " + i);
        }
        
    }
    public static void main(String[] args) {
        int numberThread = 5;
        Thread[] threads = new Thread[5];
        for (int i = 0; i < numberThread; i++) {
            Runnable runnable = new RunnableCounter("Thread " + (i + 1));
            Thread thread = new Thread(runnable);
            thread.start();
        }
        
    }
    
}
