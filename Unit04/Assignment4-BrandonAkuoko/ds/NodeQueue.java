package ds;

public class NodeQueue<E> implements Queue<E>{
    private Node<E> front;
    private Node<E> back;
    private int size;

    public NodeQueue(){
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public void enqueue(E value){ //something to do with back
        //1. Create a new node object
        Node<E> newNode = new Node<>(value);
        if(front == null){
            front = newNode;
            back = newNode;
        }
        else{
            //2. The node needs to be connected
            back.setNext(newNode);
            //update back to set new node
            back = newNode;
            //increase size
        }
        size++;


    }

    public E dequeue(){ // something to do with front
        if(front == null){
            return null;
        }
        E devalue = front.getValue();
        front = front.getNext();
        //Special case - queue becomes empty
        if(front == null){
            back = null;
        }
        this.size--;
        return devalue;
    }

    public int size(){return size;}

    public static void main(String[] args) {
        NodeQueue<String> q = new NodeQueue<>();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");

        while(q.size > 0){
            System.out.println(q.dequeue()); // [A,B,C]
        }
    }
}
