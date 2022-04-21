import java.util.Scanner;

public class Primes {
    public static boolean isPrime(int n){// boolean function that test to see if the number is prime or not
        for(int count = 2; count <= n/2; count += 1){ 
            if((n % count) == 0){
                return false;
            }

        }
        return true;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a Prime Number: ");
        int number = scanner.nextInt();
        if(number < 1){
        }
        else{
            System.out.println(isPrime(number));
        }
        scanner.close();

    }
    
}
