package gvt;

public class Fighter extends Goat {

    
    public Fighter(String name, int maxHealth){
        super(name, 150);
    }
    @Override
    public Attack attack(){
        int [] hits = {25};

        return new Attack("Cleave",hits,DamageType.PHYSICAL);
    }
    @Override
    public void takeDamage(Attack attack){
        double adjustment = 1.0;
        if(attack.getType() == DamageType.MAGICAL){
            adjustment = 1.25;
        }
        else if(attack.getType() == DamageType.PHYSICAL){
            adjustment = .75;
        }
        takeDamage(attack, adjustment);

    }
    
}
