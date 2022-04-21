import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.smartcardio.Card;
public class Files {
    public static void main(String[] args) {
            printFile("data/sieve_10.txt");
        // String path = file.getAbsolutePath();
        // long len = file.length();
        // boolean dir = file.isDirectory();
        // System.out.println("path = " + path);
        // System.out.println(len);
        // System.out.println(dir); // should be false

    public static int[] makeSieve(int n){
        //0 - prime
        //1 - not prime
        int [] sieve = new int[n];
        //init
        sieve[0] = 1; // 0- is not prime
        sieve[1] = 1; // 1 - is not prime
        for(int i = 2; i < n; i++){
            if(sieve[i] == 0){
            //multiples of i are not prime - set them to 1
            // 2 * i 
            for(int m = 2; (m * i) < n; m++){
                sieve[m*i] = 1;
                }
            }
        
        }
        return sieve; 
        
    }
    public static void printFile(String filename){
        // try with resources 
        try(FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);){

            while(true){
                String line = bufferedReader.readLine(); // IOexception returns nothing to read
                if(line == null){
                    break;
                }
                System.out.println(line);
            }

        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public static void printFile2(String filename) throws IOException{
            FileReader fileReader = new FileReader(filename); // basic reader [throw File not found exeception]
            BufferedReader bufferedReader = new BufferedReader(fileReader); // advanced reader
            String line = bufferedReader.readLine(); // IOexception
            System.out.println(line);
            fileReader.close(); // Ioexception
            bufferedReader.close();
    }
}
