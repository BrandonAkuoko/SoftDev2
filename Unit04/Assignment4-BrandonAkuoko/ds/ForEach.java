package ds;

public class ForEach {
    public static void main(String[] args) {
        // int[] array = {10,20,30};

        // for(int elements : array){
        //     System.out.println(elements);
        // }z
        List<Integer> list = new ArrayList<>();
        list.append(10);
        list.append(20);
        list.append(30);

        for(int elements : list){
            System.out.println(elements);
        }
    }
    
}
