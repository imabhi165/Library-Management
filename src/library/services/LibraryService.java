package library.services;

import library.exceptions.BookNotFoundException;
import library.exceptions.MemberNotFoundException;
import library.models.Book;
import library.models.Member;
import library.models.MembershipType;

import java.util.*;

public class LibraryService {
    // Using Map for fast lookup by ID
    private final Map<String, Book> books;
    private final Map<String, Member> members;

    // Counters for generating IDs
    private int bookCounter;
    private int memberCounter;

    public LibraryService() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
        this.bookCounter = 1;
        this.memberCounter = 1;
    }

    // === BOOK MANAGEMENT METHODS ===

    public Book addBook(String title, String author, String isbn) {
        String bookId = "B" + bookCounter++;
        Book book = new Book(bookId, title, author, isbn);
        books.put(bookId, book);
        System.out.println("Book added successfully! ID: " + bookId);
        return book;
    }

    public Book findBookById(String bookId) {
        Book book = books.get(bookId);
        if (book == null) {
            throw new BookNotFoundException("Book not found with ID: " + bookId);
        }
        return book;
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                result.add(book);
            }
        }
        return result;
    }

    // === MEMBER MANAGEMENT METHODS ===

    public void registerMember(String name, String email, MembershipType membershipType) {
        String memberId = "M" + memberCounter++;
        Member member = new Member(memberId, name, email, membershipType);
        members.put(memberId, member);
        System.out.println("Member registered successfully! ID: " + memberId);
    }

    public Member findMemberById(String memberId) {
        Member member = members.get(memberId);
        if (member == null) {
            throw new MemberNotFoundException("Member not found with ID: " + memberId);
        }
        return member;
    }

    // === BORROWING AND RETURNING ===

    public void borrowBook(String memberId, String bookId) {
        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);

        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is already borrowed: " + book.getId());
        }

        member.borrowBook(book);
        book.setAvailable(false);
        System.out.println("Book borrowed successfully: " + book.getTitle());
    }

    public void returnBook(String memberId, String bookId) {
        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);

        member.returnBook(book);
        book.setAvailable(true);
        System.out.println("Book returned successfully: " + book.getTitle());
    }

    // === DISPLAY METHODS ===

    public void displayAllBooks() {
        System.out.println("\n=== ALL BOOKS IN LIBRARY ===");
        if (books.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            for (Book book : books.values()) {
                book.displayInfo();
                System.out.println("---");
            }
        }
    }

    public void displayAllMembers() {
        System.out.println("\n=== ALL LIBRARY MEMBERS ===");
        if (members.isEmpty()) {
            System.out.println("No members registered.");
        } else {
            for (Member member : members.values()) {
                member.displayInfo();
                System.out.println("---");
            }
        }
    }

    public void displayAvailableBooks() {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        List<Book> availableBooks = getAvailableBooks();
        if (availableBooks.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : availableBooks) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor() +
                        " (ID: " + book.getId() + ")");
            }
        }
    }

    // === GETTERS FOR STATISTICS ===
    public int getTotalBooks() { return books.size(); }
    public int getTotalMembers() { return members.size(); }
    public Collection<Book> getAllBooks() { return books.values(); }
    public Collection<Member> getAllMembers() { return members.values(); }
}
