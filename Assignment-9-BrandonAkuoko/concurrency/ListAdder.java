import java.util.ArrayList;
import java.util.List;

public class ListAdder implements Runnable{
    private List<Integer> sharedList;
    private int num;

    public ListAdder(List<Integer> sharedList, int num){
        this.sharedList = sharedList;
        this.num = num;
    }

    @Override
    public void run() {
        sharedList.add(num);
    }
    
    public static void main(String[] args) {
        int number = 100;
        Thread[] thread = new Thread[number];
        List<Integer> sharedList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Runnable r = new ListAdder(sharedList, i);
            thread[i] = new Thread(r);
            thread[i].start();
        }

        System.out.println("Size of the list: " + sharedList.size());
    }
}
