import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Thread> list = new LinkedList<>();
        ChezWoolie resturant = new ChezWoolie();
        System.out.println("It is opening day");
        for (int i = 0; i < 2; i++) {
            Chef chef = new Chef(resturant, i +1);
            Thread c = new Thread(chef);
            c.start();
            list.add(c);
        }
        for (int i = 0; i < 10; i++) {
            Diner diner = new Diner("Diner " + (i+1), resturant);
            Thread d = new Thread(diner);
            d.start();
        }
        for (Thread thread : list) {
            thread.join();
        }
        System.out.println("Chezwoolie is closing for the night");
    }
}
