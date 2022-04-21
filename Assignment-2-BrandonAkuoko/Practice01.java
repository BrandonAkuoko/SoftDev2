import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;

public class Practice01 {
    public static String arrayToString(int [] array){ 
        String result = Arrays.toString(array); // takes the array and converts it into the string return
        return result;
    }
    public static void main(String[] args) throws IOException {
        printLines("data/alice.txt", "y");
    }
    public static int printLines(String filename, String letter)throws IOException{
        try{
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            int count = 0; // counter that picks up each letters appearances in the text.
            while(line != null){
                if(line.length() == 0){
                }
                else if(line.toLowerCase().charAt(0) == letter.charAt(0)){
                    System.out.println(line); // Prints the line that starts with the certain character
                    count++; // adds to the count
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            System.out.println("There are " + count + " sentences that start with the letter " + letter);
            return count;
        }
        catch(IOException e){ // Error that is caught 
            System.out.println("Error: Could not find file " + filename);
        }
        return 0;
    }
}
    
        
        
