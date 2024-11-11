/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * DBConsoleAdapter.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

public class DBConsoleAdapter implements AdapterOperations, BookAdapterOperations,
        UserAdapterOperations, LoanAdapterOperations {

    // Instances of managers responsible for database operations
    DBManager dbManager = new DBManager();
    DBHistoryLogger historyLogger = new DBHistoryLogger();
    DBBookManager bookManager = new DBBookManager(historyLogger);
    DBUserManager userManager = new DBUserManager(historyLogger);
    DBLoanManager loanManager = new DBLoanManager(historyLogger);

    // Method to add a book by passing its details to the DBBookManager
    @Override
    public void addBook(Book book) {
        bookManager.add(book); // Call method to add book
    }

    // Method to remove a book by its ID
    @Override
    public void removeBook(int bookId) {
        bookManager.remove(bookId); // Call method to remove the book by ID
    }

    // Method to list all books in the library
    @Override
    public void listBooks() {
        bookManager.list(); // Call method to list all books
    }

    // Method to add a member by passing their details to the DBUserManager
    @Override
    public void addMember(Member member) {
        userManager.add(member); // Call method to add the member
    }

    // Method to remove a member by their ID
    @Override
    public void removeMember(int memberId) {
        userManager.remove(memberId); // Call method to remove member by ID
    }

    // Method to list all members in the library
    @Override
    public void listMembers() {
        userManager.list(); // Call method to list all members
    }

    // Method to allow a member to borrow a book
    @Override
    public void borrowBook(Loan loan) {
        loanManager.borrowBook(loan); // Call method to record borrowing of a book
    }

    // Method to allow a member to return a book
    @Override
    public void returnBook(int memberId, int bookId) {
        loanManager.returnBook(memberId, bookId); // Call method to record the return of a book
    }

    // Method to list all loans in the library system
    @Override
    public void listLoans() {
        loanManager.list(); // Call method to list all loans
    }

    // Method to search the database based on the provided parameters
    @Override
    public void search(String table, String searchField, String searchString) {
        dbManager.search(table, searchField, searchString); // Perform a search in the specified table
    }

    // Method to list all transaction history from the database
    @Override
    public void listHistory() {
        DBHistoryLogger.listHistory(); // Call method to list transaction history
    }
}
