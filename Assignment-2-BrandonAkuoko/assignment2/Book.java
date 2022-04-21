package assignment2;

public class Book {
    private String title;
    private String author;
    private int copies;
    private CheckedOut status;
    //private Book[] books;

    public Book(String title, String author, int copies){
        this.title = title;
        this.author = author;
        this.copies = copies;
        this.status = CheckedOut.AVAILABLE; 
    }

    public Book(String title, String author) {
        this(title, author, 1);
    }

    public void statusUpdate(Book book){
        if(copies <= 0){
            this.status = CheckedOut.CHECKEDOUT;
        }
        else{
            this.status = CheckedOut.AVAILABLE;
        }
    }
    public void checkOut(Book book){
        book.copies -= 1;
        statusUpdate(book);
    }
    public void returnBookCopy(Book book) {
        book.copies++;
        statusUpdate(book);
    }
    public CheckedOut getStatus(){
        return this.status;
    }
    public String getAuthor() {
        return author;
    }
    public String getTitle(){
        return title;
    }
    public int getCopies(){
        return copies;
    }
}

