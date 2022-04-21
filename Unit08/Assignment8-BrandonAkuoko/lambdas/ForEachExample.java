package lambdas;
import java.util.*;
import java.util.function.Consumer;

public class ForEachExample {
    static int sum = 0;
    public static void main(String[] args) {

        List<Integer> grades = new ArrayList<>();
        grades.add (54);
        grades.add (85);
        grades.add (97);
        grades.add (72);

        // for each loop
        // for(Integer x : grades){
        //     System.out.println(x);
        // }

        //forEach method
        // class MyConsumer implements Consumer<Integer>{
        //     @Override
        //     public void accept(Integer t) {
        //         System.out.println(t);
        //     }
        // }
        // grades.forEach((t)->{System.out.println(t);});
        grades.forEach(System.out :: println); // lambda println
        grades.forEach((t)->{sum += t;}); // lambda add sum
        System.out.println ("Sum = " + sum);
        // grades.stream().filter((e) -> e > 80).forEach(action);

    }
}

