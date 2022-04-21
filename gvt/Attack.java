package gvt;

public class Attack {
    private String name;
    private int[] hits;
    private DamageType type;

    public Attack(String name, int[] hits, DamageType type){
        this.name = name;
        this.hits = hits;
        this.type = type;
    }
    public String getName(){
        return this.name;
    }
    public DamageType getType(){
        return this.type;
    }
    public int[] getHits(){
        return this.hits;
    }
    
}
