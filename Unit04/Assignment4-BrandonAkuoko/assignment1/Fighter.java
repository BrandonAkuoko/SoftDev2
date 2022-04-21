package assignment1;
/**
 * This class is used as a Parent to all the sub Fighter Classes
 * @author Brandon Akuoko
 */
public abstract class Fighter {
    private String name;
    protected int currHealth;
    private final int maxHealth;
    
    /**
     * Constructor is used to create the basic Fighter class 
     * @param name
     * @param maxHealth
     */
    public Fighter(String name, int maxHealth){
        this.name = name;
        this.currHealth = maxHealth;
        this.maxHealth = maxHealth;
    }
    /**
     * Boolean function checks to see if the Fighter is dead
     * @return
     */
    public boolean isUnconsious(){return currHealth == 0;}
    public abstract void takeDamage(Attack attack);
    public abstract Attack attack();

    /**
     * This take damage function is used to hit the fighters with attacks
     * @param attack
     * @param adjustment
     */
    public void takeDamage(Attack attack, double adjustment){
        int[] hits = attack.getHits(); // {25}
        for(int i = 0; i < hits.length; i++){
            currHealth -= (int)(hits[i] * adjustment); // 9*.75 = 6.456
        }
        if(currHealth < 0){
            currHealth = 0;
        }
    }
}
