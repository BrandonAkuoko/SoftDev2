package ds;

public class HeapPQ implements Queue<Integer> {
    private ArrayHeap hp;
    private int size;

    public HeapPQ(ArrayHeap hp, int size){
        this.hp = hp;
        this.size = size;
    }


    @Override
    public void enqueue(Integer value) {
        hp.add(value);
        size++;
    }

    @Override
    public Integer dequeue() {
        size--;
        return hp.remove();
        
    }

    @Override
    public int size() {return this.size;}
    
}
