package ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class PQTest {
    @Test
    public void ListPQTest(){
        //Setup
        LinkedList<Integer> l = new LinkedList<>();
        ListPQ list = new ListPQ(l, 0);
        int expected = 1;

        //Invoke
        list.enqueue(5);
        list.enqueue(2);
        list.enqueue(6);
        list.enqueue(8);
        list.enqueue(1);
        list.enqueue(12);
        list.enqueue(69);

        //Analyze
        assertEquals(expected, list.dequeue());



        
    }
    
    @Test
    public void HeapPQTest(){
        //setup
        ArrayHeap h = new ArrayHeap();
        HeapPQ heap = new HeapPQ(h, 0);

        //setup
        heap.enqueue(5);
        heap.enqueue(3);
        heap.enqueue(2);
        heap.enqueue(4);
        heap.enqueue(1);

        //analyze
        assertEquals(1, heap.dequeue());
        assertEquals(2, heap.dequeue());
        assertEquals(3, heap.dequeue());
        assertEquals(4, heap.dequeue());
        assertEquals(5, heap.dequeue());
    }
    
    
}
