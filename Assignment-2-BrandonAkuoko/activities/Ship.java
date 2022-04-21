package activities;

public class Ship {
    //state
    private String name;
    private int hull;
    private int shield;
    private Weapon[] aramament;
    private boolean operational;
    
    public Ship(String name, int hull, int shield, int numberWeapon){
        this.name = name;
        this.hull = hull;
        this.shield = shield;
        this.aramament = new Weapon[numberWeapon];
        for(int i = 0; i < numberWeapon; i++){
            aramament[i] = new Weapon(); 
        }
        this.operational = true;

    }
    public boolean isOperational(){
        return this.operational;
    }
    public void takeDamage(Weapon weapon){
        if(shield > 0){
            shield -= weapon.getDamage();
        }
        else if(hull > 0){
            hull -= weapon.getDamage();
        }
        else{
            this.operational = false;
        }

    }

    public void attack(Ship target){
        System.out.println(this.name + " attacks " + target.name);
        if(operational){
            for(int i = 0; i < aramament.length; i++){
            Weapon weapon = aramament[i];
            target.takeDamage(weapon);
            } 
        }    
    }
}
