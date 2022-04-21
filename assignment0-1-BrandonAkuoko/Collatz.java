import java.util.Scanner;

public class Collatz {
    public static String Sequence(int n){
        String temp = "" + n + " ";
        if (n <=  1){
        }
        else{
            while(n != 1){
                if(n % 2 == 0){
                    n = n / 2;
                }
                else{
                    n = (3 * n) + 1;
                }
                if (n != 1){
                    temp += n + " ";  
                }
                else{
                    temp += n;
                }
            }
        }
        return temp;
    }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a number...");
            int n = scanner.nextInt();
            if(n < 1){

            }
            else{
                System.out.print(Sequence(n));
            }
            scanner.close();
        }
    }
