package Librarymanagement.src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Libraryapp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        boolean using = true;

        System.out.println("Welcome to the Library Management System!");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\n💾 Saving data to files...");
            library.saveAllData();
        }));

        while (using) {
            printMenu();
            int choice = getchoice(sc);
            sc.nextLine();

            switch (choice) {
                case 1 -> library.displayAllBooks();
                case 2 -> addNewBook(sc, library);
                case 3 -> registerNewUser(sc, library);
                case 4 -> checkoutBook(sc, library);
                case 5 -> returnBook(sc, library);
                case 6 -> library.displayAllUsers();
                case 7 -> {
                    System.out.println("Thank you");
                    using = false;
                }
                default -> System.out.println("Invalid choice");

            }

        }

        sc.close();
        System.out.println("End of the program");

    }

    private static void printMenu() {
        System.out.println("\n=========Main Menu==========");
        System.out.println("1  view All books");
        System.out.println("2  Add new Book");
        System.out.println("3  Register new User");
        System.out.println("4 Borrow a Book");
        System.out.println("5 Return a Book");
        System.out.println("6 Display all users");
        System.out.println("7 Exit");
        System.out.print("\n Enter a choice between (1-7):");
    }

    private static int getchoice(Scanner sc) {
        try {
            return sc.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input please enter a number");
            sc.nextLine();
            return -1;
        } catch (NumberFormatException e) {
            System.out.println("invalid number");
            return -1;
        }
    }

    private static void addNewBook(Scanner sc, Library library) {
        System.out.print("Enter the bookId: ");
        String bookId = sc.nextLine();
        System.out.print("enter the Title: ");
        String title = sc.nextLine();
        System.out.print("Enter the author: ");
        String author = sc.nextLine();

        Book book = new Book(bookId, title, author);
        library.addBook(book);
    }

    private static void registerNewUser(Scanner sc, Library library) {
        System.out.print("Enter the user Id: ");
        String userId = sc.nextLine();
        System.out.print("Enter the user name: ");
        String name = sc.nextLine();

        User newuser = new User(userId, name);
        library.registerUsers(newuser);
    }

    private static void checkoutBook(Scanner sc, Library library) {
        System.out.print("Enter the UserId: ");
        String userId = sc.nextLine();
        System.out.print("Enter the bookId: ");
        String bookId = sc.nextLine();

        library.checkoutBook(userId, bookId);
    }

    private static void returnBook(Scanner sc, Library library) {
        System.out.print("Enter the UserId: ");
        String userId = sc.nextLine();
        System.out.print("Enter the bookId: ");
        String bookId = sc.nextLine();

        library.returnBook(userId, bookId);
    }

}
