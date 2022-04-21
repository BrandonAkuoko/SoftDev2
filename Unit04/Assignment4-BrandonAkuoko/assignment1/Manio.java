package assignment1;
/**
 * This class is used to make the Manio character that is extended from fighter
 * @author Brandon Akuoko
 */
import java.util.Random;

public class Manio extends Fighter{
    public Manio(){
        super("Manio", 100);
    }
    @Override
    /**
     * This function creates a special attack for Manio
     */
    public Attack attack(){
        Random hitPoints = new Random();
        int hit = hitPoints.nextInt((25) + 1) + 25;
        int [] hits = {hit};
        System.out.println("Jump attack was used!");
        return new Attack("Jump attack", hits);
    }

    @Override
    /**
     * Updates the take damage for Manio.
     * There is a 25% chance that he will dodge the attack
     */
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        Random r = new Random();
        int percentage = r.nextInt(4); // 0,1,2,3
        if(percentage == 0){System.out.println("Attack was dodged");}
        else{takeDamage(attack, adjustment);}
    }
}
