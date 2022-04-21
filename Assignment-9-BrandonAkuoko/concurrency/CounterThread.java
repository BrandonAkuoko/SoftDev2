public class CounterThread extends Thread{
    private String name;

    public CounterThread(String name){this.name = name;}

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(name + ": " + i);
        }
    }
    
    public static void main(String[] args) {
        CounterThread thread = new CounterThread("Thread-1");
        thread.start();
        //CounterThread thread2 = new CounterThread("Thread-2");
        // thread.start();
        // //thread2.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // while(thread.isAlive()){} 

        //main thread prints letters
        for(char ch = 'A'; ch <= 'Z'; ch++){
            System.out.println(ch + " ");
        }
        System.out.println();
    }
}
