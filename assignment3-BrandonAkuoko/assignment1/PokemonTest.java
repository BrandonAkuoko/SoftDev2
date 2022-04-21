package assignment1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class PokemonTest {
    @Test
    public void changeNameTest(){
        //Setup
        Pokemon charmandar = new Pokemon("Charmandar", Type.FIRE);
        String expected = "Bobby";

        //Invoke
        charmandar.changeName("Bobby");
        String actual = charmandar.getName();

        //Analyze
        assertEquals(expected, actual);
    }
    @Test
    public void levelUpTest(){
        // Setup
        Pokemon charmandar = new Pokemon("Charmandar", Type.FIRE, 99);
        int expected = 100;

        // Invoke
        charmandar.levelUp();
        int actual = charmandar.getLevel();

        //Analyze
        assertEquals(expected, actual);


    }
    @Test
    public void toStringTest(){
        //Setup
        Pokemon charmandar = new Pokemon("Charmandar", Type.FIRE, 87);
        String expected = "Pokemon{name = Charmandar, type = FIRE, level = 87}";

        //Invoke
        String actual = charmandar.toString();

        //Analyze
        assertEquals(expected, actual);
    }
    @Test 
    public void equalsTest(){
        //Setup
        Pokemon charmandar = new Pokemon("Charmandar", Type.FIRE, 87);
        Pokemon scorchmonkey = new Pokemon("Scorchmonkey", Type.FIRE, 87);
        
        //Invoke
        boolean expected = true;

        //Analyze
        assertEquals(expected, charmandar.equals(scorchmonkey));
    }
}
