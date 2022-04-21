package gvt;

public class GoatMain {
    public static void main(String[] args) {
        Goat mage = new Mage("Mage", 100);
        Troll troll = new Trollzord();

        while(true){
            troll.takeDamage(mage.attack());
            if(troll.isVanquished()){
                System.out.println("Mage wins");
                break;
            }
            mage.takeDamage(troll.attack());
            if(mage.isUnconsious()){
                System.out.println("Troll win");
                break;
            }

        }
        
    }
    
}
