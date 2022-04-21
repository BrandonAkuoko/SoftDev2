package gvt;

public class Trollzord extends Troll{
    public Trollzord(){
        super("Trollzord", 64, 0.05);
    }

    @Override
    public Attack attack(){
        int[] hits = {25};
        return new Attack("Flame War", hits, DamageType.MAGICAL);
    }
    @Override
    public void takeDamage(Attack attack){
        System.out.println("Troll takes Damage");
        double adjustment = 1.0;
        if(attack.getType() == DamageType.HOLY){
            adjustment = 1.25;
        }
        takeDamage(attack, adjustment);
    }
    
}
