package library;

import library.models.*;
import library.services.LibraryService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryService library = new LibraryService();

        System.out.println("🚀 LIBRARY MANAGEMENT SYSTEM");

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1️⃣  Add Book");
            System.out.println("2️⃣  Register Member");
            System.out.println("3️⃣  Borrow Book");
            System.out.println("4️⃣  Return Book");
            System.out.println("5️⃣  Search Books by Title");
            System.out.println("6️⃣  Display All Books");
            System.out.println("7️⃣  Display Available Books");
            System.out.println("8️⃣  Display All Members");
            System.out.println("9️⃣  Exit");
            System.out.print("👉 Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1: // Add book
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();

                    library.addBook(title, author, isbn);
                    break;

                case 2: // Register member
                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Membership Type (1 = STANDARD, 2 = PREMIUM): ");
                    int mt = sc.nextInt();
                    sc.nextLine();

                    MembershipType membership = (mt == 2) ? MembershipType.PREMIUM : MembershipType.STANDARD;
                    library.registerMember(name, email, membership);
                    break;

                case 3: // Borrow book
                    System.out.print("Enter Member ID: ");
                    String memberId1 = sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    String bookId1 = sc.nextLine();

                    try {
                        library.borrowBook(memberId1, bookId1);
                    } catch (Exception e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                    break;

                case 4: // Return book
                    System.out.print("Enter Member ID: ");
                    String memberId2 = sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    String bookId2 = sc.nextLine();

                    try {
                        library.returnBook(memberId2, bookId2);
                    } catch (Exception e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                    break;

                case 5: // Search books
                    System.out.print("Enter Title keyword: ");
                    String key = sc.nextLine();

                    var found = library.findBooksByTitle(key);
                    System.out.println("\nFound " + found.size() + " book(s):");
                    for (Book b : found) {
                        System.out.println("- " + b.getTitle() + " (" + b.getId() + ")");
                    }
                    break;

                case 6:
                    library.displayAllBooks();
                    break;

                case 7:
                    library.displayAvailableBooks();
                    break;

                case 8:
                    library.displayAllMembers();
                    break;

                case 9:
                    System.out.println("👋 Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice. Try again!");
            }
        }
    }
}
