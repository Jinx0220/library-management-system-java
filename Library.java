package Librarymanagement.src;

import java.util.HashMap;

public class Library {
    private HashMap<String, Book> books = new HashMap<>();
    private HashMap<String, User> users = new HashMap<>();

    public Library() {
        this.books = Filehandler.loadBooks();
        this.users = Filehandler.loadUsers();

        if (books.isEmpty()) {
            System.out.println("Adding sample books.. ");
            addBook(new Book("B001", "Java Programming", "John Doe"));
            addBook(new Book("B002", "Data Structures", "Jane Smith"));
            addBook(new Book("B003", "Algorithms", "Robert Johnson"));
            // in this above way new book objects are created and instanly erased after run
            // use these when no other methods are required to be used
        }

    }

    public void saveAllData() {
        Filehandler.saveBooks(books);
        Filehandler.saveUsers(users);

    }

    public void addBook(Book book) {
        // Book=datatype book=variable to store data
        // book gets memory location and values from Bookclass this method and
        // add the values to books Hashmap
        // since datatype is of Book class and book is its variable
        // we can use Book class methods with this book variable
        books.put(book.getId(), book);
        System.out.println("Book added: " + book.getTitle());
    }

    public Book findBook(String bookId) {
        return books.get(bookId);
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in Library");
            return;
        } else {
            System.out.println("\n All books (" + books.size() + ")");
            for (Book book : books.values()) {
                book.displayInfo();
            }
        }

    }

    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("There are no users currently. ");
        } else {
            for (String user : users.keySet()) {
                System.out.println(user);

            }
        }
    }

    public void registerUsers(User user) {
        users.put(user.getUserId(), user);
        System.out.println("registered user: " + user.getName());
    }

    public User findUser(String userId) {
        return users.get(userId);
    }

    public void checkoutBook(String userId, String bookId) {

        if (!users.containsKey(userId)) {
            System.out.println(" Error: User not found!");
            return;
        }

        if (!books.containsKey(bookId)) {
            System.out.println(" Error: Book not found!");
            return;
        }
        User user = users.get(userId);
        Book book = books.get(bookId);

        if (books.containsKey(bookId) && book.isAvailable()) {
            book.setAvailable(false);
            user.borrowBook(bookId);
            System.out.println("sucessfully set the book: " + bookId + "to unavailable");
            System.out.println("added the book: " + bookId + "to users borrow book");
        } else {
            System.out.println("Error in finding book or is Unavailable at the moment");
        }

    }

    public void returnBook(String userId, String bookId) {
        if (!users.containsKey(userId)) {
            System.out.println("The user is not found");
            return;
        }

        if (!books.containsKey(bookId)) {
            System.out.println("Book not found");
            return;
        }

        User user = users.get(userId);
        Book book = books.get(bookId);

        if (user.hasBorrowedBook(bookId)) {
            System.out.println("The book" + bookId + "has been returned ");
            book.setAvailable(true);
            user.returnBook(bookId);
        } else {
            System.out.println("the user hasnt borrowed the book");
        }

    }

}
