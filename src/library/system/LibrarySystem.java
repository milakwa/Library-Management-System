package library.system;

import java.util.Scanner;

public class LibrarySystem {

    static Scanner scan = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {

        while (true) {

            System.out.println("===================================");
            System.out.println("      LIBRARY MANAGEMENT SYSTEM     ");
            System.out.println("===================================");
            System.out.println("1 - Add Member");
            System.out.println("2 - Add Book");
            System.out.println("3 - Borrow Book");
            System.out.println("4 - Return Book");
            System.out.println("5 - Show Member Info");
            System.out.println("6 - Show Available Books");
            System.out.println("0 - Exit");
            System.out.println("===================================");

            int choice;
            while (true) {
                System.out.print("\nEnter your choice: ");

                try {
                    choice = Integer.parseInt(scan.nextLine());

                    if (choice < 0 || choice > 6) {
                        System.out.println("\nChoice must be between 0 and 6.");
                        continue;
                    }

                    break;

                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid input! Please enter numbers only.");
                }

            }
            switch (choice) {
                case 0:
                    System.out.println("\nExiting Library System...");
                    return;

                case 1:
                    addMember();
                    break;

                case 2:
                    addBook();
                    break;

                case 3:
                    borrowBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    showMemberInfo();
                    break;

                case 6:
                    library.showAvailableBooks();
                    break;
            }

        }

    }

    public static LibraryMember addMember() {
        int id;
        String name, pass;
        while (true) {
            try {
                System.out.print("\nEnter Member ID: ");
                id = Integer.parseInt(scan.nextLine());

                if (library.isMemberIdExists(id)) {
                    System.out.println("\nThis ID already exists. Try another one.");
                    continue;
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter numbers only.");
            }
        }
        while (true) {
            System.out.print("\nEnter Member Name: ");
            name = scan.nextLine();
            if (name != null && name.trim().isEmpty()) {
                System.out.println("\nName cannot be empty. Try again.");
                continue;
            }
            if (name.matches(".*[0-9].*")) {
                System.out.println("\nName cannot contain number. Try again.");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("\nEnter Member Password: ");
            pass = scan.nextLine();
            if (pass != null && pass.isBlank()) {
                System.out.println("\nName cannot be empty. Try again.");
                continue;
            }
            break;
        }
        System.out.println("\nSelect Member Type:");
        System.out.println("1 - Student");
        System.out.println("2 - Teacher");
        System.out.println("3 - Guest");
        int type;
        while (true) {
            System.out.print("\nEnter your choice: ");

            try {
                type = Integer.parseInt(scan.nextLine());

                if (type < 1 || type > 3) {
                    System.out.println("\nType must be between 1 and 3.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter numbers only.");
            }

        }
        LibraryMember member = null;
        switch (type) {
            case 1:
                member = new StudentMember(id, name, pass);
                break;
            case 2:
                member = new TeacherMember(id, name, pass);
                break;
            case 3:
                member = new GuestMember(id, name, pass);
                break;
        }
        library.addMember(member);
        return member;
    }

    public static void addBook() {
        int id;
        String title, author, category = null;
        while (true) {
            try {
                System.out.print("\nEnter Book ID: ");
                id = Integer.parseInt(scan.nextLine());

                if (library.isBookIdExists(id)) {
                    System.out.println("\nThis ID already exists. Try another one.");
                    continue;
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter numbers only.");
            }
        }
        while (true) {
            System.out.print("\nEnter Book Title: ");
            title = scan.nextLine();
            if (title != null && title.isBlank()) {
                System.out.println("\nTitle cannot be empty. Try again.");
                continue;
            }
            if (title.matches(".*[0-9].*")) {
                System.out.println("\nTitle cannot contain number. Try again.");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("\nEnter name of the book's author: ");
            author = scan.nextLine();
            if (author != null && author.isBlank()) {
                System.out.println("\nAuthor name cannot be empty. Try again.");
                continue;
            }
            if (author.matches(".*[0-9].*")) {
                System.out.println("\nAuthor name cannot contain number. Try again.");
                continue;
            }
            break;
        }

        System.out.println("\nSelect Book Category:");
        System.out.println("1 - Programming");
        System.out.println("2 - Science");
        System.out.println("3 - History");
        System.out.println("4 - Literature");
        System.out.println("5 - General");

        int catChoice;
        while (true) {
            System.out.print("\nEnter your choice: ");

            try {
                catChoice = Integer.parseInt(scan.nextLine());

                switch (catChoice) {
                    case 1:
                        category = "Programming";
                        break;
                    case 2:
                        category = "Science";
                        break;
                    case 3:
                        category = "History";
                        break;
                    case 4:
                        category = "Literature";
                        break;
                    case 5:
                        category = "General";
                        break;
                    default:
                        System.out.println("\nChoice must be between 1 and 5.");
                        continue;
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter numbers only.");
            }
        }
        System.out.println("\nSelect Book Type:");
        System.out.println("1 - Physical Book");
        System.out.println("2 - E-Book");
        System.out.println("3 - Reference Book");
        int type;
        while (true) {
            System.out.print("\nEnter your choice: ");

            try {
                type = Integer.parseInt(scan.nextLine());

                if (type < 1 || type > 3) {
                    System.out.println("\nType must be between 1 and 3.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter numbers only.");
            }

        }
        Book book = null;
        switch (type) {
            case 1:
                book = new PhysicalBook(id, title, author, category);
                break;
            case 2:
                book = new EBook(id, title, author, category);
                break;
            case 3:
                book = new ReferenceBook(id, title, author, category);
                break;
        }
        library.addBook(book);
    }

    public static void borrowBook() {

        int memberId, bookId;
        String pass;
        LibraryMember member = null;

        if (!library.AreThereAvailableBooks()) {
            System.out.println("\nYou cannot borrow books, no books are available.\n");
            return;
        }
        while (member == null) {

            while (true) {
                try {
                    System.out.print("\nEnter Member ID: ");
                    memberId = Integer.parseInt(scan.nextLine());

                    break;

                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid input! Please enter numbers only.");
                }
            }
            while (true) {
                System.out.print("\nEnter Member Password: ");
                pass = scan.nextLine();
                if (pass != null && pass.isBlank()) {
                    System.out.println("\nName cannot be empty. Try again.");
                    continue;
                }
                break;
            }

            member = library.authenticate(memberId, pass);

            if (member == null) {
                System.out.println("\nAuthentication failed. You must be a member to borrow");
                System.out.println("1 - Try again");
                System.out.println("2 - Become a member");
                System.out.println("0 - Back to main menu");

                String choice;
                while (true) {
                    System.out.print("Enter your choice: ");
                    choice = scan.nextLine();

                    if (choice.equals("1")) {
                        break;
                    } else if (choice.equals("2")) {
                        member = addMember();
                        break;
                    } else if (choice.equals("0")) {
                        return;
                    } else {
                        System.out.println("\nInvalid choice. Try again.");
                    }
                }

                if (member == null) {
                    continue;
                }
            }

            System.out.println("\n---- Available Books ----");
            library.showAvailableBooks();

            while (true) {
                try {
                    System.out.print("\nEnter Book ID: ");
                    bookId = Integer.parseInt(scan.nextLine());

                    if (!library.borrowBook(member, bookId)) {
                        System.out.println("\nBorrowing failed. Try again.");
                        if(!member.canBorrow()){
                            return;
                        }
                        continue;
                    }
                    return;

                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid input! Please enter numbers only.");
                }
            }

        }

    }

    public static void returnBook() {
        int memberId, bookId;
        String pass;
        LibraryMember member = null;

        if (!library.allBooks()) {
            System.out.println("\nNo books were borrowed.\n");
            return;
        }
        while (true) {

            while (true) {
                try {
                    System.out.print("\nEnter Member ID: ");
                    memberId = Integer.parseInt(scan.nextLine());

                    break;

                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid input! Please enter numbers only.");
                }
            }

            while (true) {
                System.out.print("\nEnter Member Password: ");
                pass = scan.nextLine();
                if (pass != null && pass.isBlank()) {
                    System.out.println("\nName cannot be empty. Try again.");
                    continue;
                }
                break;
            }

            member = library.authenticate(memberId, pass);

            if (member == null) {
                System.out.println("\nAuthentication failed. Only registered members can return books.");
                System.out.println("1 - Try again");
                System.out.println("0 - Back to main menu");

                String option;
                while (true) {
                    System.out.print("\nEnter your choice: ");
                    option = scan.nextLine();

                    if (option.equals("1")) {
                        break;
                    } else if (option.equals("0")) {
                        return;
                    } else {
                        System.out.println("\nInvalid choice. Try again.");
                    }
                }
                continue;
            }

            while (true) {
                try {
                    System.out.print("\nEnter Book ID: ");
                    bookId = Integer.parseInt(scan.nextLine());

                    if (!library.returnBook(member, bookId)) {
                        System.out.println("\nBook return failed. Try again.");
                        continue;
                    }
                    return;

                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid input! Please enter numbers only.");
                }
            }

        }

    }

    public static void showMemberInfo() {
        int memberId;
        String pass;
        LibraryMember member = null;

        while (true) {

            while (true) {
                try {
                    System.out.print("\nEnter Member ID: ");
                    memberId = Integer.parseInt(scan.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid input! Please enter numbers only.");
                }
            }

            while (true) {
                System.out.print("\nEnter Member Password: ");
                pass = scan.nextLine();
                if (pass.isBlank()) {
                    System.out.println("\nPassword cannot be empty.");
                    continue;
                }
                break;
            }

            member = library.authenticate(memberId, pass);

            if (member == null) {
                System.out.println("\nAuthentication failed. You must be a member");
                System.out.println("1 - Try again");
                System.out.println("0 - Back to main menu");

                String choice;
                while (true) {
                    System.out.print("Enter your choice: ");
                    choice = scan.nextLine();

                    if (choice.equals("1")) {
                        break;
                    } else if (choice.equals("0")) {
                        return;
                    } else {
                        System.out.println("\nInvalid choice. Try again.");
                    }
                }

                continue;
            }
            
            member.showInfo();
            return;
        }

    }

}
