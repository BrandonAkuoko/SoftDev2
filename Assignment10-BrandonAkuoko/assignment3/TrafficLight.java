package assignment3;

public class TrafficLight extends Thread {
    private Color color;
    private Intersection intersection;
    private String id;

    public TrafficLight(String id, Intersection intersection){
        this.color = Color.RED;
        this.id = id;
        this.intersection = intersection;
    }

    public Color getColor() {
        return color;
    }
    @Override
    public void run() {
        synchronized(intersection){
            while(true){
                try{
                    Thread.sleep(1000);
                    System.out.println("The " + id + " light is " + getColor());
                    color = Color.GREEN;
                    Thread.sleep(5000);
                    System.out.println("The " + id + " changes from GREEN to YELLOW");
                    color = Color.YELLOW;
                    Thread.sleep(2000);
                    System.out.println("The " + id + " changes from YELLOW to RED");
                    color = Color.RED;
                    intersection.notify();
                    intersection.wait();
                }
                catch (InterruptedException e){
                    // squash
                }
            }
        }
    }
}
