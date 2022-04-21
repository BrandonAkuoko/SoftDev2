package gvt;

public class Trolling extends Troll{
    public Trolling(){
        super("Trolling", 38, 0.03);
    }

    @Override
    public Attack attack(){
        int[] hits = {25};
        return new Attack("U Mad", hits, DamageType.PHYSICAL);
    }
    @Override
    public void takeDamage(Attack attack){
        double adjustment = 1.0;
        if(attack.getType() == DamageType.MAGICAL){
            adjustment = 1.25;
        }
        takeDamage(attack, adjustment);
    }
    
}
