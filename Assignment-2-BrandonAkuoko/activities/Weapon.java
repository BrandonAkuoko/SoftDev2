package activities;

public class Weapon {
    public enum Type{
        HEAVY("Red"), NORMAL("Blue"), ION("Green");
        
        private String color;
        private Type(String color){
            this.color = color;
        }
        public String getColor(){
            return color;
        }
    }
    //states
    private Type type;
    private int damage;

    //Method
    public Weapon(int damage, Type type){
        this.damage = damage;
        this.type = type;
    }
    public Weapon(){
        this(10, Type.NORMAL);
    }
    public int getDamage(){
        return damage;
    }
    public Type getType(){
        return type;
    }
    public String getColor(){
        return this.type.getColor();
    }
}
