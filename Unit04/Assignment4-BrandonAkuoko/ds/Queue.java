package ds;

public interface Queue<E>{ // will hold elements of type E
    void enqueue(E value);
    E dequeue();
    int size();

    
}
