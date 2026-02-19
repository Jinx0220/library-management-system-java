package Librarymanagement.src;

import java.util.ArrayList;

public class User {

    private String userId;
    private String name;
    private ArrayList<String> borrowedBooks = new ArrayList<>();

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean hasBorrowedBook(String bookId) {
        return borrowedBooks.contains(bookId);
    }

    public void borrowBook(String bookId) {
        borrowedBooks.add(bookId);
        System.out.println(name + " borrowed book of ID: " + bookId);
    }

    public void returnBook(String bookId) {
        if (borrowedBooks.remove(bookId)) {
            System.out.println(name + "returned books ID" + bookId);
        } else {
            System.out.println("the book hasnt been borrowed yet ");
        }

    }

    public void displayborrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has no books borrowed ");
        } else {
            System.out.println("\n" + name + " 's borrowed books are: ");
            for (int i = 0; i < borrowedBooks.size(); i++) {
                System.out.println("" + (i + 1) + " .BookID " + borrowedBooks.get(i));
            }
        }

    }
}