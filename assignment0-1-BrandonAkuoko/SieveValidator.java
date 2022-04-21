import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class SieveValidator {
    public static int[] readSieve(String filename){
        try(FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);){
        
        String line = bufferedReader.readLine(); // this gets the first line
        int size = Integer.parseInt(line); // looks at the first line for the area size
        int [] sieve = new int[size]; // creates array with that size
        line = bufferedReader.readLine();

        int count = 0; // temp count

        while(line != null){// while the line that were on doesnt equal null
            for(int i = 0; i < line.length(); i++){
                int a = line.charAt(i); // prints out the ascii
                sieve[count] = Character.getNumericValue(a); // converts the asci to a numeric value
                count += 1;
            }
            line = bufferedReader.readLine();

        }
        fileReader.close();
        bufferedReader.close();
        return sieve;
    }
    catch(IOException e){
        System.out.println("Could not read: " + e.getMessage());
        return null;
    }
}
public static int repairSieve(int[] sieve){
    System.out.println("Validating a sieve of size " + sieve.length);
    int count = 0;
    for(int n = 2; n < sieve.length; n++){
        if(sieve[n] == 0 && !Primes.isPrime(n)){
            System.out.println(" " + n + " is incorrectly marked as prime.");
            sieve[n] = 1;
            count += 1;
        }
        else if (sieve[n] == 1 && Primes.isPrime(n)){
            System.out.println("  " + n + " is incorrectly marked as NOT prime.");
            sieve[n] = 0;
            count += 1;
        }
    }
    if(count == 0){
        System.out.println("Sieve contained 0 errors");
    }
    else{
        System.out.println("Sieve contained " + count + " error(s)");
    }
    return count;
}
public static void main(String[] args) {
    int[] sieve = readSieve("data/sieve_5.txt");
    int[] sieve2 = readSieve("data/sieve_10.txt");
    int[] sieve3 = readSieve("data/sieve_55.txt");
    int[] sieve4 = readSieve("data/sieve_100.txt");
    int[] sieve5 = readSieve("data/sieve_1000.txt");
    int[] sieve6 = readSieve("data/sieve_10000.txt");
    
    repairSieve(sieve);
    repairSieve(sieve2);
    repairSieve(sieve3);
    repairSieve(sieve4);
    repairSieve(sieve5);
    repairSieve(sieve6);

    
}
}
