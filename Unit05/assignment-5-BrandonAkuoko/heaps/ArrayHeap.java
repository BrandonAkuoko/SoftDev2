package heaps;
import java.util.Arrays;

public class ArrayHeap implements Heap {
    private int[] array;
    private int size;

    public ArrayHeap() {
        this.array = new int[3];
        this.size = 0;
    }
    @Override
    public String toString() {
        return "" + Arrays.toString(array) + ", " + size;
    }
    public int size() {
        return size;
    }
    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public void add(int value) {
        if(size == array.length) {
            array = Arrays.copyOf(array, size*2);
        }
        array[size] = value;
        int child = size;
        int parent = (child - 1)/2;
        while(array[parent] > array[child]) {
            swap(child, parent);
            child = parent;
            parent = (parent - 1)/2;
        }
        size++;
    }
    public int remove() {
        int root = array[0];
        size--;
        swap(0, size);
        array[size] = 0;
        int parent = 0;
        while(parent < size) {
            int left = 2*parent + 1;
            int right = 2*parent + 2;
            int min = parent;
            if(left < size) {
                min = left;
            }
            if(right < size && array[left] > array[right]) {
                min = right;
            }
            if(array[parent] > array[min]) {
                swap(parent, min);
                parent = min;
            }
            else {
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Heap heap = new ArrayHeap();
        heap.add(5);
        heap.add(4);
        heap.add(6);
        heap.add(3);
        heap.add(2);
        for(int i=0; i<5; i++) {
            System.out.println(heap.remove());
        }
        System.out.println(heap);
    }
}
       
