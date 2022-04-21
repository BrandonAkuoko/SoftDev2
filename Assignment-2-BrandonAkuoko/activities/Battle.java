package activities;

public class Battle {
    public static void main(String[] args) {
        Ship ship1, ship2;
        ship1 = new Ship("Ship1", 100, 50, 3);
        ship2 = new Ship("Ship2", 120, 4, 5);
        while(ship1.isOperational() && ship2.isOperational()){
            ship1.attack(ship2);
            if(!ship2.isOperational()){
                System.out.println("ship2 died");
                break;
            }
            ship2.attack(ship1);
            if(!ship1.isOperational()){
                System.out.println("ship1 died");
                break;
            }

        }

    }
    
}
