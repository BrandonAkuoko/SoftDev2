import java.util.LinkedList;
import java.util.List;

public class ChezWoolie {
    private List<Food> conveyor;
    private int dinerCount;
    
    public ChezWoolie(){
        conveyor = new LinkedList<>();
        dinerCount = 0;
    }

    public synchronized void enter(){
        dinerCount++;
        notify();
    }

    public synchronized void exit(){
        dinerCount--;
    }

    public synchronized int getDinerCount(){
        return dinerCount;
    }
    public List<Food> getConveyor() {
        return conveyor;
    }

    public Food retrieveFood(){
        synchronized(conveyor){
            while (conveyor.isEmpty()) {
                try {
                    conveyor.wait();
                }
                catch (Exception e) {
                }
            }
            return conveyor.remove(0);
        }
    }

    public void serveFood(Food food){
        synchronized(conveyor){
            conveyor.add(food);
            conveyor.notifyAll();
        }
    }
}
