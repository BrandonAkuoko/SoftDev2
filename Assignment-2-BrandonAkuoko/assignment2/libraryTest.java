package assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class libraryTest {
    @Test
    public void patronTest(){
        //Setup
        String expected = "Billy";

        //Invoke
        Patron billy = new Patron("Billy");

        //Analyze
        assertEquals(expected, billy.getName());

    }
    @Test
    public void patronTest2(){
        //Setup
        String expected = "Tom";

        //Invoke
        Patron tom = new Patron("Tom");

        //Analyze
        assertEquals(expected, tom.getName());

    }
    @Test
    public void bookTest1(){
        //Setup
        String expected = "Harry Parter";

        //Invoke
        Book hp = new Book("Harry Parter","JK Rowling");

        //Analyze
        assertEquals(expected, hp.getTitle());

    }
    @Test
    public void bookTest2(){
        //Setup
        String expected = "JK Rowling";

        //Invoke
        Book hp = new Book("Harry Parter","JK Rowling");

        //Analyze
        assertEquals(expected, hp.getAuthor());

    }
    @Test
    public void bookTest3(){
        //Setup
        int expected = 1;

        //Invoke
        Book hp = new Book("Harry Parter","JK Rowling");

        //Analyze
        assertEquals(expected, hp.getCopies());

    }
}
