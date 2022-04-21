import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculon {
    public static float add(float x, float y){
        return x + y;
    }
    public static float divide(float x, float y){
        return x/y;
    }
    public static float raise(float base, int exponent){
        float result = 1; // 1 ---> 1.0F
        for(int i = 0; i < exponent; i++){
            result *= base;
        }
        return result;

    }
    public static void main(String[] args) throws InputMismatchException{
        /*
        1. Try/Catch methods
        2. Rethrow Exception
        */
        System.out.print("Enter a floating point value: ");

        Scanner scanner = new Scanner(System.in);
        //try{
            float op1 = scanner.nextFloat();
            float op2 = scanner.nextFloat(); // InputMismatchException
            float sum = add(op1, op2);
            System.out.println("Sum = " + sum);
            scanner.close();
        // }
        // catch(InputMismatchException e){
        //     // If something wrong happens 
        //     System.out.print(e);
        // }
        // catch(IllegalStateException e){
        //     System.out.print(e);
        // }
        
    //}
}
