package GoatsVsTrolls.gvt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fighter extends Goat {
    /**
     * Example of using the Ability interface
     */
    // private static class BasicAttack implements Ability {
    //     @Override
    //     public void use(List<Troll> enemies, List<Goat> party) {
    //         Goat.basicAttack(enemies, party);
    //     }
    // }

    static Ability cleave = (enemies, party)->{
        for(int i = 0; i < 3 && i < enemies.size(); i++){
            Troll target = getRandomTarget(enemies);
            Troll target2 = getRandomTarget(enemies); // targets should not be the same
            if(i == 0){ // should be the first attack
                int [] hits = {25};
                Attack attack = new Attack("Cleave", hits, DamageType.PHYSICAL);
                target.takeDamage(attack);
                removeVanquished(enemies, target);
            }
            else{
                if(target == target2){ // checks to make sure the targets are the same
                    target2 = getRandomTarget(enemies); // randomzies it again
                }
                else{
                    int [] hits = {13};
                    Attack attack = new Attack("Cleave", hits, DamageType.PHYSICAL);
                    target2.takeDamage(attack);
                    removeVanquished(enemies, target2);
                }
            }
        }
    };
    /**
     * Rampage hits a random opponent for 30 damage
     */
    static Ability rampage = (enemies, party)->{
        Troll target = getRandomTarget(enemies);
        int [] hits = {30};
        Attack attack = new Attack("Rampage", hits, DamageType.PHYSICAL);
        target.takeDamage(attack);
        removeVanquished(enemies, target);
    };

    /**
     * Fighter ability list. There is one list for all fighters.
     */
    private static final Map <String, Ability> abilities = new HashMap<> ();

    static {
        /**
         * Add new abilities in here
         */
        abilities.put ("Punch", Goat :: basicAttack); // method instance 
        abilities.put("Cleave", cleave);
        abilities.put("Rampage", rampage);
    }

    public Fighter(String name) {
        super(name, 150, abilities);
    }
    
    @Override
    public Attack attack() {
        int[] hits = {25};
        return new Attack("Cleave", hits, DamageType.PHYSICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 1.25;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 0.75;
        }
        takeDamage(attack, adjustment);
    }
}
