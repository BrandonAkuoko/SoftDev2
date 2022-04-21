import java.util.HashSet;

public class HashSetPractice {
    public static void main(String[] args) {
        HashSet<String> myset = new HashSet<>();
        myset.add("A");
        myset.add("B");
        myset.add("C");

        for(String ele : myset){
            System.out.println(ele);
        } 
        myset.contains("C"); // O(1) based on hashing
        
        
    }
    
}
