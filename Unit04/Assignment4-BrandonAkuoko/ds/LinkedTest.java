package ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class LinkedTest {
    @Test
    public void appendTest(){
        //Setup
        List<Integer> list = new LinkedList<>();
        //Invoke
        list.append(10);
        //Analyze
        assertEquals(1, list.size());
    }
    @Test
    public void getTest(){
        //Setup
        List<Integer> list = new LinkedList<>();

        //Invoke
        list.append(20);
        list.append(30);
        
        //Analyze
        assertEquals(20, list.get(0));
        assertEquals(30, list.get(1));

    }

    
}
