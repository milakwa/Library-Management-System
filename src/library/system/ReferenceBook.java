package library.system;

public class ReferenceBook extends Book {

    public ReferenceBook(int bookID, String title, String author, String category) {
        super(bookID, title, author, category);
    }

    @Override
    public String getBookType() {
        return "Reference Book";
    }

    @Override
    public int calculateBorrowDuration() {
        return 0; 
    }
}

