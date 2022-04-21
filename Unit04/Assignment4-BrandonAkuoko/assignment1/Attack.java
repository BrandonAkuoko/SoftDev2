package assignment1;
/**
 * This class is used to create an Attack
 * @author Brandon Akuoko
 */
public class Attack {
    private String name;
    private int[] hits;

    /**
     * Creates the attack via name and hits
     * @param name
     * @param hits
     */
    public Attack(String name, int[] hits){
        this.name = name;
        this.hits = hits;
    }

    public String getName(){return this.name;}
    public int[] getHits(){return this.hits;}
}
