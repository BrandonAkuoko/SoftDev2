package assignment2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Library library = new Library();
            library.fillLibrary("data/book_list.txt");

            
            System.out.println("Welcome to the Library, what would you like to do?" 
             + "\n - To checkout a book, enter: c \"Patron Name\" \"Book Name\""
             + "\n - To return a book, enter: c \"Patron Name\" \"Book Name\""
             + "\n - For a list of available commands, enter: help\"");

            // For example: C "Bruce Herring" "Lord of the Flies"

            boolean Quit = false;

            while (Quit == false) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("> ");
                String input = scanner.nextLine();
                String[] tokens = input.trim().split(" \"");

                if (tokens[0].equals("bye")) {
                    Quit = true;
                    scanner.close();
                    System.out.println("Goodbye!");
                    return;
            
                } 
                else if (tokens[0].equals("help")) {
                    System.out.println("Help Bar:" 
                    + "\n - To checkout a book, enter: c \"Patron Name\" \"Book Name\"" + "\n - To return a book, enter: r \"Patron Name\" \"Book Name\"");
            
                } 
                else if (tokens[0].equals("info")) {
                    System.out.println(library);
                }
                if (tokens.length > 1) {
                    if (tokens[0].equals("c")) {
                        library.checkout("\"" + tokens[1], "\"" + tokens[2]);
                
                    } 
                    else if (tokens[0].equals("r")) {
                        library.returnLibrary("\"" + tokens[1], "\"" + tokens[2]);
                        
                    }
                }
            }

        } catch (IOException ioe) {

        }
    }
    
}
