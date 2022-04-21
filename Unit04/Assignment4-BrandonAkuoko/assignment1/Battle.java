package assignment1;
/**
 * This class is used to simulate the battle between the two fighters
 * @author Brandon Akuoko
 */
public class Battle {
    public static void main(String[] args) {

        Fighter manio = new Manio();
        Fighter samos = new Samos();

        while(true){
            manio.takeDamage(samos.attack());
            if(manio.isUnconsious()){
                System.out.println("Samos A. wins");
                break;
            }
            samos.takeDamage(manio.attack());
            if(samos.isUnconsious()){
                System.out.println("Manio wins");
                break;
            }

        }
    }
    
}
