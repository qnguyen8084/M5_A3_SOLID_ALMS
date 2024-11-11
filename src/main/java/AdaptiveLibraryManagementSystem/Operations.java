/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * Operations.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

// Interface for general operations related to the adapter, such as searching and listing transaction history.
interface AdapterOperations {
    void search(String table, String searchField, String searchString); // Method to search in a specified table with a given field and value.
    void listHistory(); // Method to list the transaction history.
}

// Interface for book-related operations using the adapter, such as adding, removing, and listing books.
interface BookAdapterOperations {
    void addBook(Book book); // Method to add a new book.
    void removeBook(int bookId); // Method to remove a book by its ID.
    void listBooks(); // Method to list all books.
}

// Interface for user-related operations using the adapter, such as adding, removing, and listing members.
interface UserAdapterOperations {
    void addMember(Member member); // Method to add a new member.
    void removeMember(int memberId); // Method to remove a member by their ID.
    void listMembers(); // Method to list all members.
}

// Interface for loan-related operations using the adapter, such as borrowing, returning books, and listing loans.
interface LoanAdapterOperations {
    void borrowBook(Loan loan); // Method for a member to borrow a book.
    void returnBook(int memberId, int bookId); // Method for a member to return a borrowed book.
    void listLoans(); // Method to list all current loans.
}

// Interface for general console operations related to searching and history display.
interface ConsoleOperations {
    void search(); // Method to initiate a search via console.
    void listHistory(); // Method to display transaction history via console.
}

// Interface for book-related operations via console, such as adding, removing, and listing books.
interface ConsoleBookOperations {
    void addBook(); // Method to add a book via console input.
    void removeBook(); // Method to remove a book via console input.
    void listBooks(); // Method to list all books via console.
}

// Interface for user-related operations via console, such as adding, removing, and listing members.
interface ConsoleUserOperations {
    void addMember(); // Method to add a member via console input.
    void removeMember(); // Method to remove a member via console input.
    void listMembers(); // Method to list all members via console.
}

// Interface for loan-related operations via console, such as borrowing, returning books, and listing loans.
interface ConsoleLoanOperations {
    void borrowBook(); // Method to borrow a book via console input.
    void returnBook(); // Method to return a book via console input.
    void listLoans(); // Method to list all loans via console.
}

// Interface for database operations related to searching in a specified table and field.
interface DBOperations {
    void search(String table, String searchField, String searchString); // Method to perform a search in the database.
}