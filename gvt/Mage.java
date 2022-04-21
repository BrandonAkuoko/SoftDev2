package gvt;

public class Mage extends Goat{
    // private String name;
    // private final  int maxHealth = 100;
    // private int currHealth;
    
    public Mage(String name, int maxHealth){
        super(name, 100);
    }
    @Override
    public Attack attack(){
        int [] hits = {9, 9, 9, 9};

        return new Attack("Magic Missle",hits,DamageType.MAGICAL);
    }
    @Override
    public void takeDamage(Attack attack){
        double adjustment = 1.0;
        if(attack.getType() == DamageType.MAGICAL){
            adjustment = 0.75;
        }
        else if(attack.getType() == DamageType.PHYSICAL){
            adjustment = 1.25;
        }
        takeDamage(attack, adjustment);

    }
    
}
