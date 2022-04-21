import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
@Testable
public class MiscellanyTest {
    @Test
    public void palidroneTest(){
        //setup
        boolean actual = Miscellany.palidrone("abc");
        assertEquals(false, actual);
    }

    
}
