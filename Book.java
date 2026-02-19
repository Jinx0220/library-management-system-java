package Librarymanagement.src;

public class Book {

    private String id;
    private String title;
    private String author;
    private boolean isavailable;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isavailable = true;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isavailable;
    }

    public void setAvailable(boolean isavailable) {
        this.isavailable = isavailable;
    }

    public void displayInfo() {

        System.out.println("Book details are:");
        System.out.println("Book ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (isavailable ? "YES " : "NO"));
        System.out.println();
        System.out.println();

    }
}
