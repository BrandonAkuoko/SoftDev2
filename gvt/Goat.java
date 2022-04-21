package gvt;

public abstract class Goat {
    private String name;
    protected int currHealth;
    private final int maxHealth;

    public Goat(String name, int maxHealth){
        this.name = name;
        this.currHealth = maxHealth;
        this.maxHealth = maxHealth;
    }
    public void heal(int amount){
        this.currHealth += amount;
        if(this.currHealth > maxHealth){
            this.currHealth = maxHealth;
        }

    }
    public boolean isUnconsious(){
        return currHealth == 0;
    }
    public abstract void takeDamage(Attack attack);

    public void takeDamage(Attack attack, double adjustment){
        int[] hits = attack.getHits(); // {25}
        for(int i = 0; i < hits.length; i++){
            currHealth -= (int)(hits[i] * adjustment); // 9*.75 = 6.456
        }
        if(currHealth < 0){
            currHealth = 0;
        }
    }
    public abstract Attack attack();
}
