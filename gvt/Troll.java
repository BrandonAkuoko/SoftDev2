package gvt;

public abstract class Troll {
    private final String name;
    private final int maxHP;
    private double regenAmount;
    private int currHP;

    public Troll(String name, int maxHP, double regenAmount){
        this.name = name;
        this.maxHP = maxHP;
        this.currHP = maxHP;
        this.regenAmount = regenAmount;
    }
    public String getName(){return name;}
    public boolean isVanquished(){
        return this.currHP <= 0;
    }
    public abstract Attack attack();
    public abstract void takeDamage(Attack attack);
    public void takeDamage(Attack attack, double adjustment){
        int[] hits = attack.getHits(); // {25}
        for(int i = 0; i < hits.length; i++){
            currHP -= (int)(hits[i] * adjustment); // 9*.75 = 6.456
        }
        if(currHP < 0){
            currHP= 0;
        }
    }
    public void regenerate(){
        this.currHP += (int)(this.maxHP*regenAmount);
    }

}
