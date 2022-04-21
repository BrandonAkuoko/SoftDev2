package ds;

public interface Range extends Iterable<Integer>{
    int size();
    int get(int index);
    
}
// Range range = new IntRange(1,100,2)