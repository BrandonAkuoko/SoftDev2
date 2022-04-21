package assignment2;

import java.util.Arrays;

public class Patron {
    private String name;
    private Book [] books;
    private int bookCount;


    public Patron(String name, int limit){
        this.name = name;
        books = new Book[limit]; // [null, null, null]
    }
    public Patron(String name){
        this(name, 3);
    }
    public String getName(){ // returns the name
        return name;
    }
    public Book[] getBooks(){
        return books;
    }
    
    @Override
    public String toString() {
        return "Patron " + name + " with "+ Arrays.toString(books);
    }
    public void addBook(Book book){
        if(book.getCopies() == 0){
            System.out.println("Could not be checked out: " + book.getTitle() + " is not in the library");
            throw new IllegalArgumentException("User tried to check out a book thats not in the library");
        }
        if(bookCount == books.length){
            throw new IndexOutOfBoundsException("Already have max books checked out");
        }
        for(int i = 0; i < books.length; i++){
            if(books[i] == null){
                books[i] = book;
                bookCount++;
                return;
            }
        }
    }
    public void returnBook(Book book){
        int i = 0;
        while(i <= books.length){
            if(i == books.length){
                throw new IllegalArgumentException("User does not own this book");
            }
            if(book == books[i]){
                books[i] = null; //[book, book, null] <-- returns book
                System.out.println(book.getTitle() + " has been returned");
                book.returnBookCopy(book);
                break;
            }
            i++;
        }
    }
}

