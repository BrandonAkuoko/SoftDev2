package ds;

public class ArrayQueue<E> implements Queue<E>{
    private Object[] array;
    private int front; // index at which front is used for dequeue
    private int back; // index at which the back is used for enqueue
    private int size;

    public ArrayQueue(){
        array = new Object[2];
        front = 0;
        back = 0;
        size = 0;
    }


    public void enqueue(E value){ // back
        // Resizing
        if(size == array.length){
            Object[] bigArray = new Object[array.length * 2];
            //Copy
            int src = front;
            for(int dst = 0; dst < array.length; dst++){
                bigArray[dst] = array[src];
                src = (src + 1) % array.length;
            }
            front = 0;
            back = size;
            array = bigArray;
        }
        //assuming the array is not full
        array[back] = value;
        back = (back+1) % array.length;
        size++;
    }


    public E dequeue(){ //front 
        if(size == 0){return null;}
        E deValue = (E)array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        return deValue;
    }
    public int size() {return size;}

    public static void main(String[] args) {
        Queue<String> q = new ArrayQueue<>();

        q.enqueue("A");
        q.enqueue("B"); //{A, B}
        q.enqueue("C"); // resizing {A, B, C, null}
        q.enqueue("D");
        System.out.println(q.dequeue()); // "A" || {null, B, C, D} front = C, back = D
        q.enqueue("E");
        q.enqueue("F"); // {E, B, C, D, F}

        while(q.size() > 0) {
            System.out.print(q.dequeue());
        }


        
        // q.enqueue("C"); // {A, B, C , null}
        // System.out.println(q.dequeue()); // "A" || {"null", B, C, null} -- > "b" will be the front
        // q.enqueue("D"); // {null, B, C, D} back will be D, front will be B
        // q.enqueue("E"); // {E, B, C, D} // back will be E, front will be B
        // System.out.println(q.dequeue()); // {e, null, C, D} front = 2, back = 0
        // System.out.println(q.dequeue()); // {e, null, null, D} front = 3
    }
    
}
