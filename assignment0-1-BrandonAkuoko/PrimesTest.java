import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class PrimesTest {
    @Test
    public void isPrimeTest(){
        //Setup
        int x = 3;
        boolean expected = true;

        //invoke
        boolean actual = Primes.isPrime(x);

        //Analyze
        assertEquals(expected, actual);
        
    }
    
    
}
