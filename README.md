# Library Management System 📚
A console-based Java application that manages library operations including books, users, and borrowing transactions. 
Built to demonstrate object-oriented programming, collections framework, and file-based data persistence.

## Features

### Book Management
- Add new books with unique ID, title, and author
- View all books with availability status
- Search books by ID
- Track book availability (available/checked out)

### User Management
- Register new users with unique ID and name
- View all registered users
- Track books borrowed by each user

### Borrowing System
- Checkout books to users with availability validation
- Return books from users
- Prevent borrowing of unavailable books
- Track which user has borrowed which books

### Data Persistence
- All data saved to text files in data folder
- Books saved to: books.txt
- Users and their borrowed books saved to: users.txt
- Automatic loading on startup
- Automatic saving on exit

### Input Validation
- Prevents duplicate IDs
- Validates user and book existence
- Checks book availability before checkout
- Handles invalid menu choices

## Technologies Used

- Java
- Collections Framework (HashMap, ArrayList)
- File I/O (FileWriter, BufferedReader)
- Exception Handling
- OOP Principles
- Scanner for user input

## Project Structure
LibraryManagementSystem/
├── LibraryApp.java # Main application with menu interface
├── Library.java # Core library logic and data management
├── Book.java # Book model class
├── User.java # User model class with borrowed books
├── FileHandler.java # File I/O operations
├── exceptions/
│ ├── BookNotFoundException.java
│ ├── UserNotFoundException.java
│ └── BookUnavailableException.java
├── data/
│ ├── books.txt # Saved book data
│ └── users.txt # Saved user data
└── .gitignore


## How to Run

1. **Clone the repository**
   ```bash
 git clone https://github.com/YOUR-USERNAME/library-management-system-java.git

2.Navigate to the Project
  cd library-management-system-java

3.Compile all Java Files
  javac *.java exceptions/*.java

4.Run the application
  javac *.java exceptions/*.java



