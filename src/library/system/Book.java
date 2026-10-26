package library.system;

public abstract class Book {

    protected int BookID;
    protected String Title;
    protected String Author;
    protected String Category;
    protected boolean Available;

    public Book(int BookID, String Title, String Author, String Category) {
        this.BookID = BookID;
        this.Title = Title;
        this.Author = Author;
        this.Category = Category;
        this.Available = true;
    }

    public int getBookID() {
        return BookID;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getCategory() {
        return Category;
    }

    public boolean isAvailable() {
        return Available;
    }

    public void setAvailable(boolean Available) {
        this.Available = Available;
    }

    public abstract String getBookType();

    public abstract int calculateBorrowDuration();
    

}
