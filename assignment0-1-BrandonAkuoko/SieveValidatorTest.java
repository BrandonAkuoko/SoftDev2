import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class SieveValidatorTest {
    @Test
    public void repairSieveTest(){
        //Setup
        int[] array = SieveValidator.readSieve("data/sieve_10.txt");
        int expected = 2;

        //Invoke
        

        // Analyze
        assertEquals(expected, SieveValidator.repairSieve(array));
        

    }
    public void repairSieveTest2(){
        //Setup
        int[] array = SieveValidator.readSieve("data/sieve_5.txt");
        int expected = 3;

        //Invoke
        

        // Analyze
        assertEquals(expected, SieveValidator.repairSieve(array));
        

    }
}
