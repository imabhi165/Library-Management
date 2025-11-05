package library.models;

public enum MembershipType {
BASIC(3), //can borrow 3 Books
STANDARD(5), //can borrow 5 books
PREMIUM(10); //can borrow 10 Books

    private final int maxBooks;

    MembershipType(int maxBooks) {
        this.maxBooks = maxBooks;
    }
    public int getMaxBooks(){
        return maxBooks;
    }
}
