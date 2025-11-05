package library.models;

import java.util.ArrayList;
import java.util.List;

public class Member extends BaseEntity {
    private String name;
    private String email;
    private MembershipType membershipType;
    private List<Book> borrowedBooks;

    // Composition - Member HAS-A Address
    private Address address;

    // Constructor
    public Member(String id, String name, String email, MembershipType membershipType) {
        super(id);
        this.name = name;
        this.email = email;
        this.membershipType = membershipType;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public MembershipType getMembershipType() { return membershipType; }
    public List<Book> getBorrowedBooks() { return new ArrayList<>(borrowedBooks); } // Return copy
    public Address getAddress() { return address; }

    // Setters
    public void setAddress(Address address) {
        this.address = address;
    }

    // Business methods
    public void borrowBook(Book book) {
        // Check if member can borrow more books
        if (borrowedBooks.size() >= membershipType.getMaxBooks()) {
            throw new IllegalStateException(
                    "Cannot borrow more books. Maximum limit: " + membershipType.getMaxBooks());
        }

        // Check if book is available
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is not available for borrowing");
        }

        // Borrow the book
        book.borrowBook();
        borrowedBooks.add(book);

        System.out.println("Book '" + book.getTitle() + "' borrowed successfully!");
    }

    public void returnBook(Book book) {
        if (!borrowedBooks.contains(book)) {
            throw new IllegalStateException("This book was not borrowed by this member");
        }

        book.returnBook();
        borrowedBooks.remove(book);

        System.out.println("Book '" + book.getTitle() + "' returned successfully!");
    }

    // Implement abstract method from BaseEntity
    @Override
    public void displayInfo() {
        System.out.println("=== MEMBER INFO ===");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Membership: " + membershipType);
        System.out.println("Borrowed Books: " + borrowedBooks.size() + "/" + membershipType.getMaxBooks());

        if (address != null) {
            address.displayAddress();
        }

        System.out.println("ID: " + getId());
        System.out.println("Registered: " + getCreateAt());
    }

    // Method overloading - same method name, different parameters
    public void displayBorrowedBooks() {
        displayBorrowedBooks(false);
    }

    public void displayBorrowedBooks(boolean showDetails) {
        System.out.println("=== BOOKS BORROWED BY " + name.toUpperCase() + " ===");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            for (int i = 0; i < borrowedBooks.size(); i++) {
                Book book = borrowedBooks.get(i);
                if (showDetails) {
                    System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor());
                } else {
                    book.displayInfo();
                }
            }
        }
    }
}
