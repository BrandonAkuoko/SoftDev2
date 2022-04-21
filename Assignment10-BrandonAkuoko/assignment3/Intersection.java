package assignment3;

public class Intersection {
    private TrafficLight light1;
    private TrafficLight light2;
    
    public Intersection(){
        this.light1 = new TrafficLight("EAST/WEST", this);
        this.light2 = new TrafficLight("North/South", this);
    }
    public TrafficLight getLight1() {
        return light1;
    }
    public TrafficLight getLight2() {
        return light2;
    }
    

    public void driveThrough(Vehicle vehicle) throws InterruptedException{
        if (vehicle.getDirection().equals(Direction.WEST) || vehicle.getDirection().equals(Direction.EAST)){
            synchronized(light1){
                if(light1.getColor().equals(Color.GREEN)){
                    System.out.println("Vehicle " + vehicle.getid() + " headed " + vehicle.getDirection() + " drives through the intersection");
                }
                else{
                    System.out.println("Vehicle " + vehicle.getid() + " headed " + vehicle.getDirection() + " stops because the light is " + light1.getColor());
                    light1.wait();
                }
                System.out.println("Vehicle " + vehicle.getid() + " headed " + vehicle.getDirection() + " drives through the intersection");
            }
        }
        if (vehicle.getDirection().equals(Direction.NORTH) || vehicle.getDirection().equals(Direction.SOUTH)){
            synchronized(light2){
                if(light2.getColor().equals(Color.GREEN)){
                    System.out.println("Vehicle " + vehicle.getid() + " headed " + vehicle.getDirection() + " drives through the intersection");
                }
                else{
                    System.out.println("Vehicle " + vehicle.getid() + " headed " + vehicle.getDirection() + " stops because the light is " + light2.getColor());
                    light2.wait();
                }
                System.out.println("Vehicle " + vehicle.getid() + " headed " + vehicle.getDirection() + " drives through the intersection");
            }

        }
        
    }

}
