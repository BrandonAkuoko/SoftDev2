package assignment3;

public class Vehicle extends Thread{
    private int id;
    private Direction direction;
    private Intersection intersection;

    public Vehicle(int id, Direction direction, Intersection intersection){
        this.id = id;
        this.direction = direction;
        this.intersection = intersection;
    }
    public int getid() {
        return id;
    }
    public Intersection getIntersection() {
        return intersection;
    }
    public Direction getDirection() {
        return direction;
    }
    @Override
    public void run() {
        try {
            intersection.driveThrough(this);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
}
