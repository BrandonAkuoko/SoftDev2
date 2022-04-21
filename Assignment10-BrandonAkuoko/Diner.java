import java.util.Random;

public class Diner implements Runnable{
    private String name;
    private int hunger;
    private ChezWoolie chezWoolie;

    public Diner(String name, ChezWoolie chezWoolie){
        this.name = name;
        Random random = new Random();
        this.hunger = random.nextInt(6) + 5;
        this.chezWoolie = chezWoolie;
    }
    public String getName() {
        return name;
    }
    public ChezWoolie getChezWoolie() {
        return chezWoolie;
    }
    public int getHunger() {
        return hunger;
    }
    public void eat(Food food){
        System.out.println(name + " begins eating " + food);
        try {
            Thread.sleep(food.getServings() * 1000);
            
        } catch (Exception e) {
        }
        hunger -= food.getServings();
        System.out.println(name + " finishes eating "+food);
    }

    @Override
    public void run() {
        chezWoolie.enter();
        synchronized(chezWoolie){
            chezWoolie.notify();
        }
        while (hunger > 0) {
            Food food = chezWoolie.retrieveFood();
            eat(food);
        }
        chezWoolie.exit();
    }
}
