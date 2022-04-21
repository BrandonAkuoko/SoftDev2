import java.util.LinkedList;
import java.util.Random;

public class Chef implements Runnable {
    private final static int WOOLESECOND = 1000;
    private final LinkedList<Food> menu;
    private ChezWoolie restaurant;
    private int id;

    public Chef(ChezWoolie restaurant, int id){

        this.menu = makeMenu();
        this.restaurant = restaurant;
        this.id = id;
    }

    @Override
    public void run() {
        Random rand = new Random();
        if(restaurant.getDinerCount()==0){
            synchronized(restaurant){
                    try {
                        System.out.println("Chef #"+id+" is early! waiting for customers...");
                        restaurant.wait();
                    } catch (InterruptedException e) {
                        
                    }
                }
            }else{
                System.out.println("Chef #"+id+" is late! he goes right to the kitchen...");
            }
        
        while(restaurant.getDinerCount()>0){
            Food food = menu.get(rand.nextInt(5));
            System.out.println("Chef #"+id+" begins preparing "+food.getServings()+" servings of "+food.getName());
            try {
                Thread.sleep(WOOLESECOND*2);
                System.out.println("Chef #"+id+" finishes preparing "+food.getServings()+" servings of "+food.getName());
            } catch (InterruptedException e) {
            }
            synchronized(restaurant){
                
                restaurant.serveFood(food);
                restaurant.notifyAll();
            }
        }
        System.out.println("Chef #"+id+" goes home for the night");
        
    }

    private LinkedList<Food> makeMenu(){
        LinkedList<Food> menu = new LinkedList<>();
        menu.add(new Food("Hotdogs", 6));
        menu.add(new Food("Sour Dough", 7));
        menu.add(new Food("ZaZa",1));
        menu.add(new Food("Steak", 4));
        menu.add(new Food("Popcorn", 3));
        return menu;
    }
    
}