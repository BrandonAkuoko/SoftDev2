import java.rmi.server.Operation;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculator
 */
public class Calculator {    
    public interface Operation {public double execute(double left, double right);}
    public static Operation getOperation(String operator){
        //create an instance
        class Addition implements Operation{
            @Override
            public double execute(double left, double right) {
                return left + right;
            }
        }
        if(operator.equals("+")){return new Addition();}
        else if(operator.equals("-")){
            return new Operation(){
                @Override
                public double execute(double left, double right) {
                    return left - right;
                } 
            };
        }
        else if(operator.equals("*")){
            return (double left, double right) -> {return left*right;};
        }
        else if(operator.equals("/")) return (left,right)-> left/right;
        else if(operator.equals("^")){
            return Math::pow;
        }
        else{
            throw new UnsupportedOperationException("Unsupportred operation");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                double left = scanner.nextDouble();
                String operator = scanner.next();
                double right = scanner.nextDouble();

                Operation operation = getOperation(operator);

                double result = operation.execute(left, right);
                System.out.println(left + " " + operator + " " + right + " = " + result);
            }
            catch(InputMismatchException ex){
                break;
            }
        }
        System.out.println("Have a nice day!");
    }
}