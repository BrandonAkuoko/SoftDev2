public class Countdown extends Thread{

    @Override
    public void run() {
        int count = -10;
        while(true){
            if (count < 0){
                System.out.println("T" + count);
                try {Thread.sleep(100);} 
                catch (InterruptedException e) {}
            }
            else if(count == 0){System.out.println("Liftoff!");}
            else{System.out.println(count);}
            count++;
        }
        
    }
    public static void main(String[] args) {
        Thread t = new Countdown();
        t.start();
    }
    
}
