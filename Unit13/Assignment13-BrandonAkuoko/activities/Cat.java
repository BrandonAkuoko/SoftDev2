package activities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cat{
    private String name;
    private String furColor;
    private int evilRating;

    public Cat (String name, String furColor, int evilRating) {
        this.name = name;
        this.furColor = furColor;
        this.evilRating = evilRating;
    }
    public String getName(){
        return name;
    }
    public String getFurColor(){
        return furColor;
    }
    public int getEvilRating() {
        return evilRating;
    }

    
    public static void main(String[] args) {
        
    }
}
