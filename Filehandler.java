package Librarymanagement.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Filehandler {
    private static final String Booksfile = "Librarymanagement\\data\\books.txt";
    private static final String Usersfile = "Librarymanagement\\data\\users.txt";

    public static void saveBooks(HashMap<String, Book> books) {
        try (FileWriter fw = new FileWriter(Booksfile)) {
            for (Book book : books.values()) {
                fw.write(book.getId() + "," +
                        book.getTitle() + "," +
                        book.getAuthor() + "," +
                        book.isAvailable() + "\n");
            }
            System.out.println("Book save to file sucessfully");
        } catch (FileNotFoundException e) {
            System.out.println("File was not found ");
        } catch (IOException e) {
            System.out.println("Error saving to the books File ");

        }
    }

    public static HashMap<String, Book> loadBooks() {
        HashMap<String, Book> books = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(Booksfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String title = parts[1];
                    String author = parts[2];
                    boolean isAvailable = Boolean.parseBoolean(parts[3]);

                    Book book = new Book(id, title, author);
                    book.setAvailable(isAvailable);
                    books.put(id, book);
                }

            }
            System.out.println("Books loaded from file sucessfully");
            System.out.println("Total books in File are: " + books.size());

        } catch (FileNotFoundException e) {
            System.out.println("Error finding the file location");
        } catch (IOException e) {
            System.out.println("Error loading books");
        }
        return books;

    }

    public static void saveUsers(HashMap<String, User> users) {
        try (FileWriter fw = new FileWriter(Usersfile)) {
            for (User user : users.values()) {

                StringBuilder line = new StringBuilder();
                line.append(user.getUserId()).append(",");
                line.append(user.getName()).append("|");

                ArrayList<String> borrowedbooks = user.getBorrowedBooks();
                for (int i = 0; i < borrowedbooks.size(); i++) {
                    line.append(borrowedbooks.get(i));
                    if (i < borrowedbooks.size() - 1) {
                        line.append(",");
                    }

                }

                fw.write(line.toString());
                fw.write(System.lineSeparator());
            }
            System.out.println("User saved sucessfully");
        } catch (IOException e) {
            System.out.println("error saving users");
        }
    }

    public static HashMap<String, User> loadUsers() {
        HashMap<String, User> users = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Usersfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 1) {
                    String[] userinfo = parts[0].split(",");
                    if (userinfo.length == 2) {
                        String userID = userinfo[0];
                        String name = userinfo[1];

                        User user = new User(userID, name);

                        if (parts.length == 2) {
                            String[] borrowedbooks = parts[1].split(",");
                            for (String bookId : borrowedbooks) {
                                if (!bookId.isEmpty()) {
                                    user.borrowBook(bookId);
                                }
                            }
                        }

                        users.put(userID, user);
                    }
                }

            }
            System.out.println("Users loaded from file sucessfully");
            System.out.println("Total number of users are: " + users.size());
        } catch (FileNotFoundException e) {
            System.out.println("No existing users ");
        } catch (IOException e) {
            System.out.println("error loading users");

        }
        return users;

    }

}
