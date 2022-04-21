package GoatsVsTrolls.gvt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Mage extends Goat {

    static Ability missile = (enemies, party)->{
            for(int i = 0; i < 4 && i < enemies.size(); i++){
                Troll target = getRandomTarget(enemies);
                int [] hits = {9};
                Attack attack = new Attack("Magic Missile", hits, DamageType.MAGICAL);
                target.takeDamage(attack);
                removeVanquished(enemies, target);
            }
        };
    /**
     * Method of depression is a 3 round shooter of a random target where a random amount of depression hits
     */
    static Ability depression = (enemies, party)->{
        for(int i = 0; i < 3 && i < enemies.size(); i++){
            Troll target = getRandomTarget(enemies);
            Random r = new Random();
            int hit = r.nextInt(10);
            int [] hits = {hit};
            Attack attack = new Attack("Depression", hits, DamageType.PHYSICAL);
            target.takeDamage(attack);
            removeVanquished(enemies, target);
        }
    };

    /**
     * Mage ability list. There is one list for all mages.
     */
    private static final Map <String, Ability> abilities = new HashMap<> ();
    static {
        /**
         * Add new abilities in here
         */
        abilities.put ("Staff Attack", Goat :: basicAttack); // method instance
        abilities.put("Magic Missile", missile);
        abilities.put("Depression", depression);
        
    }

    public Mage(String name) {
        super(name, 100, abilities);
    }

    public Attack attack() {
        int[] hits = {9, 9, 9, 9};
        return new Attack("Magic Missiles", hits, DamageType.MAGICAL);
    }

    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 0.75;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 1.25;
        }
        takeDamage(attack, adjustment);
    }
}
