import java.util.LinkedList;

public class Consumer implements Runnable {
    private final LinkedList<String> queue; // shared object 
    private final int id;

    public Consumer(int id, LinkedList<String> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            String message = null;
            synchronized(queue){
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            
                message = queue.remove(0);          
            System.out.println("Consumer " + id + ": " + message);
            }

        }
    }
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add("first message");
        queue.add("second message");
        Thread thread = new Thread(new Consumer(0, queue));
        thread.start();
    }
}
