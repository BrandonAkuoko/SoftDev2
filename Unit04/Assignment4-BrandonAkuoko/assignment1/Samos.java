package assignment1;

import java.util.Random;

public class Samos extends Fighter{

    public Samos(){super("Samos A.", 200);}

    @Override
    /**
     * In the takeDamage for Samos A. there were no modifications from the default
     */
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        takeDamage(attack, adjustment);
    }

    @Override
    /**
     * the attack function randomly generates a possibility(1/4) that missiles will be shot
     * Else, The arm cannon will be used
     */
    public Attack attack(){
        Random r = new Random();
        int possibility = r.nextInt(4); // 0, 1, 2, 3
        if(possibility == 0){
            int[] hits = {75};
            System.out.println("Missiles were shot!");
            return new Attack("Missiles", hits);
        }
        else{
            int[] hits = {40};
            System.out.println("Arm Cannon was used!");
            return new Attack("Arm Cannon", hits);
        }
    }
}
