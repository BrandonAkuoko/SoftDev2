import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class Practice01Test {
    @Test
    public void arrayTest(){
        //Setup
        int [] testArray = {1, 2, 5, 3, 5};
        String expected = "[1, 2, 5, 3, 5]";
        //invoke
        String actual = Practice01.arrayToString(testArray);
        //Analyze
        assertEquals(expected, actual);
    }
    
    public void newArrayTest(){
        //Setup
        int [] array = {4, 4, 4, 4, 4};
        String expected = "[4, 4, 4, 4, 4]";
        //invoke
        String actual = Practice01.arrayToString(array);
        //Analyze
        assertEquals(expected, actual);


    }
    
    
}
