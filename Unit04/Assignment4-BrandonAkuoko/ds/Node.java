package ds;

public class Node<E> {
    private E value;
    private Node<E> next;

    public Node(E value, Node<E> next){
        this.value = value;
        this.next = next;
    }
    public Node(E value){
        this(value, null);
    }
    public E getValue(){return value;}
    public Node<E> getNext(){return next;}
    public void setNext(Node<E> next){this.next = next;}
    public void setValue(E value){this.value = value;} // updated 
    public static void main(String[] args) {
        Node<String> nodeA = new Node<>("A");

        nodeA.setNext(new Node<>("B"));
        nodeA.getNext().setNext(new Node<>("C"));
        System.out.println(nodeA.getNext().getValue()); // "B"
        System.out.println(nodeA.getNext().getNext().getValue()); //"C"

        // /**
        //  * How it iterate around a node to get each valueww
        //  */
        // Node curr = nodeA;
        // while(curr != null){
        //     System.out.println(curr.getValue());
        //     curr = curr.getNext();
        }
    }
    
