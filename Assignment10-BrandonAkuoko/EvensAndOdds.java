public class EvensAndOdds{
    private boolean even;
    private int count = 1;
    private final int MAX = 99;

    public void Odd() throws InterruptedException{
        synchronized(this){
            while (count < MAX) {
                System.out.println(count);
                this.wait();
                this.notify();
                    
                count++;
                even = false;
            }
        }
    }
    public void Even() throws InterruptedException{
        try {
            Thread.sleep(1000);
        } 
        catch (Exception e) {
        }
        synchronized(this){
            while (count - 1 <= MAX) {
                
                
                try {
                    this.notify();
                    this.wait(); 
                } catch (Exception e) {
                    //TODO: handle exception
                }
                count++;
                System.out.println(count);
                even = true;
            }
        }
    }
    public static void main(String[] args) {
        EvensAndOdds e = new EvensAndOdds();
        e.even = true;
        Thread t1 = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    e.Even();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
            
        });
        Thread t2 = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    e.Odd();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
            
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } 
        catch (Exception ex) {
        }
        
    }
}
