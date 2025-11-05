package library.models;

public class Book extends BaseEntity {
        private String title;
        private String author;
        private String isbn;
        private boolean isAvailable;

        // Constructor
        public Book(String id, String title, String author, String isbn) {
            super(id); // Call parent constructor
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.isAvailable = true; // By default, book is available
        }

        // Getters
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getIsbn() { return isbn; }
        public boolean isAvailable() { return isAvailable; }

        // Setters with validation
        public void setTitle(String title) {
            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Title cannot be empty");
            }
            this.title = title;
        }

        public void setAuthor(String author) {
            if (author == null || author.trim().isEmpty()) {
                throw new IllegalArgumentException("Author cannot be empty");
            }
            this.author = author;
        }

        // Business methods
        public void borrowBook() {
            if (!isAvailable) {
                throw new IllegalStateException("Book is already borrowed");
            }
            this.isAvailable = false;
        }

        public void returnBook() {
            this.isAvailable = true;
        }

        // Implement abstract method from BaseEntity
        @Override
        public void displayInfo() {
            System.out.println("=== BOOK INFO ===");
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
            System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
            System.out.println("ID: " + getId());
      //      System.out.println("Added: " + getCreateAt();
        }

    public void setAvailable(boolean b) {
    }
};


