import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class CollatzTest {
    @Test
    public void sequenceTest(){
        //Setup
        int x = 5;
        String expected = "5 16 8 4 2 1";
        //Invoke
        String actual = Collatz.Sequence(x);
        //Analyze
        assertEquals(expected, actual);

    }
    
    
}
