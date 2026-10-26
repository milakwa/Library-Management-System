package library.system;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {

    protected int MemberID;
    protected String Name;
    protected String Password;
    protected List<Book> BorrowedBooks;
    protected int MaxBorrowLimit;

    public LibraryMember(int MemberID, String Name, String Password, int MaxBorrowLimit) {
        this.MemberID = MemberID;
        this.Name = Name;
        this.Password = Password;
        this.MaxBorrowLimit = MaxBorrowLimit;
        this.BorrowedBooks = new ArrayList<>();
    }

    public boolean login(int id, String password) {
        return this.MemberID == id && this.Password.equals(password);
    }

    public boolean canBorrow() {
        return BorrowedBooks.size() < MaxBorrowLimit;
    }

    public boolean borrowBook(Book book) {
        if (!canBorrow()) {
            System.out.println("\nBorrow limit reached.");
            return false;
        }
        if (!book.isAvailable()) {
            System.out.println("\nBook is not available.");
            return false;
        }
        if (book.calculateBorrowDuration() == 0) {
            System.out.println("\nThis book cannot be borrowed.");
            return false;
        }

        BorrowedBooks.add(book);
        book.setAvailable(false);

        System.out.println("\nBorrowed the book with the title \"" + book.getTitle() + "\" for " + book.calculateBorrowDuration() + " days.\n");
        return true;
    }

    public boolean returnBook(Book book) {

        if (!BorrowedBooks.contains(book)) {
            System.out.println("\nThis book was not borrowed by you\n");
            return false;
        }
        if (book.isAvailable() == true) {
            System.out.println("\nThis book already exists.");
            return false;
        }

        BorrowedBooks.remove(book);
        book.setAvailable(true);

        System.out.println("\nBook with title \"" + book.getTitle() + "\" returned successfully.\n");
        return true;
    }

    public void showBorrowedBooks() {

        if (BorrowedBooks.isEmpty()) {
            System.out.println("No borrowed books");
            return;
        }

        for (Book book : BorrowedBooks) {
            System.out.println("\n"+
                    book.getBookID() + " | "
                    + book.getTitle() + " | "
                    + book.getCategory() + " | "
                    + book.getBookType()
            );
        }

    }

    public void showInfo() {
        System.out.println("\nMember ID: " + MemberID);
        System.out.println("Name: " + Name);
        System.out.println("Borrowed Books:");
        showBorrowedBooks();
    }

}
