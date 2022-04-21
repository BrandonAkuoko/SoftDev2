import java.util.Scanner;

public class AnonymousCounters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int threads = 5;
        for (int j = 0; j < threads; j++) {
            String name = "Thread " + j;
            Thread thread1 = new Thread(new Runnable(){
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        System.out.println(name + ":" + i);
                    }
                }
                
            });
            thread1.start();
        }
    }
}
