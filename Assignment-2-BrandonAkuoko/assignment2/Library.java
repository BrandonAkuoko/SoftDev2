package assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Library {
    private Book[] libraryBooks;
    private Patron[] patrons;
    private static final int list = 50;

    public Library(){
        patrons = new Patron[list];
        libraryBooks = new Book[0];
    }
    public String getPatronList(){
        return Arrays.toString(patrons);
    }
    public void getBooks(){
        int k = 1;
        for(Book book : libraryBooks){
            System.out.println(book + " is located at: " + k);
            k++;
        }
    }
    public void checkout(String patron, String book){
        int i = 0;
        while (i < libraryBooks.length){
            if (libraryBooks[i].getTitle().equals(book) && libraryBooks[i].getCopies() != 0){
                for (int j = 0; j < patrons.length; j++){
                    if (patrons[j] == null) {
                        patrons[j] = new Patron(patron);
                        System.out.println(patrons[j].getName() + " is now added to our patrons!");
                        patrons[j].addBook(libraryBooks[i]);
                        return;
                    } 
                    else if (patrons[j].getName().equals(patron)){
                        boolean duplicate = isDup(patrons[j], libraryBooks[i]);  
                        if (!(duplicate)) { // Finds if the user already owns the book
                            patrons[j].addBook(libraryBooks[i]);
                            return;
                        } 
                        else {
                            System.out.println("Cannot checkout the same book.");
                            return;
                        }
                    } 
                }
            }
            i++;
        }
        System.out.println(book + " doesn't exist in the library.");
    }

    public boolean isDup(Patron patron, Book book){
        for (int i = 0; i < patron.getBooks().length; i++){
            try {
                if (patron.getBooks()[i].getTitle() == null){
                } 
                else if (patron.getBooks()[i].getTitle().equals(book.getTitle())) {
                    return true;
                }

            }catch (NullPointerException nullp){
                return false;
            }
        }
        return false;
    }

    public void fillLibrary(String filename) throws IOException{

        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int limit = Integer.parseInt(line);
            
            libraryBooks = new Book[limit];
            line = br.readLine();

            int count = 0;
            while (line != null) {
                line = line.trim();
                String[] tokens = line.split(",");

                if (tokens.length >= 3) {
                    libraryBooks[count] = new Book(tokens[0] + "," + tokens[1], "\"" + tokens[2] + "\"");

                } 
                else {
                    libraryBooks[count] = new Book("\"" + tokens[0] + "\"", "\"" + tokens[1] + "\"");

                }
                count++;
                line = br.readLine();
            }


        } 
        catch (IOException i){
            System.out.println("Cannot read the file.");
        }
    }
    public void returnLibrary(String patron, String book){
        //System.out.println(Arrays.toString(patrons));

        for (int j = 0; j < patrons.length; j++) {
            if (patrons[j] == null) {
                System.out.println(patron + " doesn't seem to exist.");
                return;
            } 
            else if (patrons[j].getName().equals(patron)){
                for (int i = 0; i < patrons[j].getBooks().length; i++){
                    try {
                        if (patrons[j].getBooks()[i].getTitle().equals(book)){
                            for (int k = 0; k < libraryBooks.length; k++){
                                if(patrons[j].getBooks()[i] == libraryBooks[k]){ 
                                    patrons[j].returnBook(patrons[j].getBooks()[i]);
                                    return;
                                }
                            }
                        }
                    } 
                    catch (NullPointerException npe){
                    }
                }
                return;
            }
        }
    }
}
