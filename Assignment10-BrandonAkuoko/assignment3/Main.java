package assignment3;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Intersection intersection = new Intersection();

        TrafficLight light1 = intersection.getLight1();
        light1.start();
        TrafficLight light2 = intersection.getLight2();
        light2.start();
        List<Direction> directions = new LinkedList<>();
        directions.add(Direction.EAST);
        directions.add(Direction.WEST);
        directions.add(Direction.SOUTH);
        directions.add(Direction.NORTH);


        for (int i = 1; i < 101; i++) {
            Random r = new Random();
            Direction direction = directions.get(r.nextInt(4));
            Vehicle vehicle = new Vehicle(i, direction, intersection);
            vehicle.start();
            Thread.sleep(r.nextInt(2001));
        }
    }
}
