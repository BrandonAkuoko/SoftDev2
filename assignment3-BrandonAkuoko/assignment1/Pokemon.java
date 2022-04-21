package assignment1;
/**
 *  The purpose of the Pokemon class is to create a pokemon via a name, type, and level.
 *  However the level is not neccesarily required as there a default value given out if you choose.
 *  @author Brandon Akuoko
 */

public class Pokemon {
    protected String name; // name can be changed at any time
    protected Type type;
    protected int level;
    private final static int defaultLevel = 1;

    /**
     * Given a string name, Type type, and int level, user is able to create a pokemon with a level of their choice
     * @param name
     * @param type
     * @param level
     */
    public Pokemon(String name, Type type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }
    /**
     * Given parameters name and type, The user is able to create a pokemon and default level will be set to 1
     * @param name
     * @param type
     */
    public Pokemon(String name, Type type) {
        this(name, type, defaultLevel);
    }
    /**
     * Given the parameter name, A user is able to change the name of their given pokemon
     * @param name
     */
    public void changeName(String name){
        this.name = name;
    }
    /**
     * This function is used to level up a pokemon one incrament at a time
     */
    public void levelUp(){
        level++;
        if(level > 100){
            this.level = 100;
        }
    }
    /**
     * Function is used to return a string strip of the name, type and level of a pokemon
     */
    @Override
    public String toString(){
        return "Pokemon{name = " + name + ", type = " + type + ", level = " + level + "}";
    }
    /**
     * This function is used to show that two pokemon given their types and levels are set equal
     * If its proven not true it will return False
     */
    @Override
    public boolean equals(Object another){
        //this vs. another
        if(another instanceof Pokemon){
            Pokemon anotherType = (Pokemon) another;
            return this.type == anotherType.type && this.level == anotherType.level;
        }
        return false;
    }
    /**
     * The following three functions return a certain pokemon's type, name, and level respectively
     * @return
     */
    public Type getType(){return this.type;}
    public String getName(){return this.name;}
    public int getLevel(){return this.level;}
    




}
