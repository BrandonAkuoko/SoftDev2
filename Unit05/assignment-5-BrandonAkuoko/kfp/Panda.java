package kfp;

import java.util.ArrayList;
import java.util.Arrays;

public class Panda<E>{
    private E weapon;
    private String name;

    public Panda(E wpn, String name){
        this.weapon = wpn;
        this.name = name;
    }

    /**
     * This function is used to check the weapon class 
     */
    
    public void strike(){
        if(this.weapon instanceof Fist){
            System.out.println(Arrays.toString(((Fist) weapon).combo()));
        }
        else if(this.weapon instanceof Naginata){
            System.out.println(((Naginata) weapon).attack());
        }
        else if(this.weapon instanceof Flowers){
            System.out.println(weapon);
        }
    }
    /**
     * This function creates an ArrayList and checks the contain of the String list to make sure that no name occurs more than once.
     * @param names
     * @return
     */
    public static ArrayList<String> unique(String[] names){
        ArrayList<String> updatedNames = new ArrayList<>();
        for(int i = 0; i < names.length; i++){
            if(updatedNames.contains(names[i])){
                continue;
            }
            else{
                updatedNames.add(names[i]);
            }
        }
        return updatedNames;
    }
}
