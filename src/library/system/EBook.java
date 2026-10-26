package library.system;

public class EBook extends Book {

    public EBook(int BookID, String Title, String Author, String Category) {
        super(BookID, Title, Author, Category);
        this.Available = true;
        
    }

    @Override
    public String getBookType() {
        return "E-Book";
    }

    @Override
    public int calculateBorrowDuration() {
        return 21;
    }
    
}
