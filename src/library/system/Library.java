package library.system;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> Books;
    private List<LibraryMember> Members;

    public Library() {
        Books = new ArrayList<>();
        Members = new ArrayList<>();
    }

    public boolean isMemberIdExists(int memberID) {
        for (LibraryMember m : Members) {
            if (m.MemberID == memberID) {
                return true;
            }
        }
        return false;
    }

    public void addMember(LibraryMember member) {

        Members.add(member);
        System.out.println("\nMember " + member.Name + " added successfully");

    }

    public boolean isBookIdExists(int BookID) {
        for (Book b : Books) {
            if (b.getBookID() == BookID) {
                return true;
            }
        }
        return false;
    }

    public void addBook(Book book) {

        Books.add(book);
        System.out.println("\nBook with Title \"" + book.getTitle() + "\" added successfully.\n");

    }

    public LibraryMember authenticate(int memberID, String password) {

        for (LibraryMember member : Members) {
            if (member.login(memberID, password)) {
                return member;
            }
        }
        return null;
    }

    private Book findBook(int bookID) {

        for (Book book : Books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }

    public boolean borrowBook(LibraryMember member, int bookID) {

        Book book = findBook(bookID);
        if (book == null) {
            System.out.println("\nBook not found\n");
            return false;
        }

        return member.borrowBook(book);
    }

    public boolean returnBook(LibraryMember member, int bookID) {

        Book book = findBook(bookID);
        if (book == null) {
            System.out.println("\nBook not found.");
            return false;
        }

        return member.returnBook(book);
    }

    public void showAvailableBooks() {

        boolean found = false;

        for (Book book : Books) {
            if (book.isAvailable()) {
                System.out.println("\n"
                        + book.getBookID() + " | "
                        + book.getTitle() + " | "
                        + book.getAuthor() + " | "
                        + book.getCategory() + " | "
                        + book.getBookType()
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo available books.");

        }

    }

    public boolean AreThereAvailableBooks() {
        for (Book book : Books) {
            if (book.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    public boolean allBooks() {
        if (Books.isEmpty()) {
            return false;
        }
        int c = 0;
        for (Book book : Books) {
            if (book instanceof ReferenceBook) {
                c++;
            }
        }
        if (c == Books.size()) {
            return false;
        }
        return true;
    }

}
