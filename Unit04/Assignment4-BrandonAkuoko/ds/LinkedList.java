package ds;

import java.util.Iterator;

import org.graalvm.compiler.graph.Node;

/**
 * This class is used to create a LinkedList that implements the List class
 * 
 * @author Brandon Akuoko
 */
public class LinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void append(E value) {
        Node<E> node = new Node<>(value);
        if (size == 0) {
            this.tail = node;
            this.head = node;
        } 
        else {
            this.tail.setNext(node);
        }
        size++;
    }

    @Override
    public E get(int index) {
        Node<E> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public void set(int index, E value) {
        Node<E> current;
        for (int i = 0; i < index; i++) {
            current = this.head.getNext();
            current.setValue(value);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {return new NodeIterator<>(head);}
    
}
