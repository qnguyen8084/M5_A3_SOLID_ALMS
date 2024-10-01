/*
 * Quy Nguyen
 * CSC635
 * Adaptive Library Management System
 * DBConsoleAdapter.java
 * Sun, Sep 29 2024
 */

package AdaptiveLibraryManagementSystem;

public class DBConsoleAdapter implements AdapterOperations, BookAdapterOperations,
        UserAdapterOperations, LoanAdapterOperations {

    // Instances of managers responsible for database operations
    DBManager dbManager = new DBManager();
    DBBookManager bookManager = new DBBookManager();
    DBUserManager userManager = new DBUserManager();
    DBLoanManager loanManager = new DBLoanManager();

    // Method to add a book by passing its details to the DBBookManager
    @Override
    public void addBook(Book book) {
        String title = book.getTitle(); // Get book title
        String author = book.getCreator(); // Get book author
        bookManager.addBook(title, author); // Call method to add book
    }

    // Method to remove a book by its ID
    @Override
    public void removeBook(int bookId) {
        bookManager.removeBook(bookId); // Call method to remove the book by ID
    }

    // Method to list all books in the library
    @Override
    public void listBooks() {
        bookManager.listBooks(); // Call method to list all books
    }

    // Method to add a member by passing their details to the DBUserManager
    @Override
    public void addMember(Member member) {
        String name = member.getName(); // Get member name
        userManager.addMember(name); // Call method to add the member
    }

    // Method to remove a member by their ID
    @Override
    public void removeMember(int memberId) {
        userManager.removeMember(memberId); // Call method to remove member by ID
    }

    // Method to list all members in the library
    @Override
    public void listMembers() {
        userManager.listMembers(); // Call method to list all members
    }

    // Method to allow a member to borrow a book
    @Override
    public void borrowBook(int memberId, int bookId) {
        loanManager.borrowBook(memberId, bookId); // Call method to record borrowing of a book
    }

    // Method to allow a member to return a book
    @Override
    public void returnBook(int memberId, int bookId) {
        loanManager.returnBook(memberId, bookId); // Call method to record the return of a book
    }

    // Method to list all loans in the library system
    @Override
    public void listLoans() {
        loanManager.listLoans(); // Call method to list all loans
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
