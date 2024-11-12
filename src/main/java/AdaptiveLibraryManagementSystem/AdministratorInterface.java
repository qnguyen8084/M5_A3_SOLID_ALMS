/*
 * Quy Nguyen
 * Dhruv Shah
 * CSC635
 * Adaptive Library Management System
 * AdministratorInterface.java
 * Sun, Sep 29 2024
 */

package AdaptiveLibraryManagementSystem;

import java.util.Scanner;

public class AdministratorInterface implements ConsoleBookOperations, ConsoleMemberOperations, ConsoleLoanOperations,
        ConsoleHistoryOperation, ConsoleSearchOperation {

    DBHistoryLogger logger = new DBHistoryLogger();
    // Adapter for database operations
    // Added use of dependency injection
    DBConsoleAdapter adaptor = new DBConsoleAdapter(
            new BookConsoleAdapter(new DBBookManager(logger)),
            new MemberConsoleAdapter(new DBMemberManager(logger)),
            new LoanConsoleAdapter(new DBLoanManager(logger)),
            new HistoryConsoleAdapter(),
            new SearchConsoleAdapter(new DBManager())
    );
    // Scanner for user input from the console
    Scanner scanner = new Scanner(System.in);

    // Method to add a new book
    @Override
    public void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        Book book = new Book(title, author);
        adaptor.addBook(book); // Add the book using the adapter
    }

    // Method to remove an existing book
    @Override
    public void removeBook() {
        System.out.print("Enter book ID: ");
        int bookId = Integer.parseInt(scanner.nextLine());
        adaptor.removeBook(bookId); // Remove the book using the adapter
    }

    // Method to list all available books
    @Override
    public void listBooks() {
        adaptor.listBooks(); // List books using the adapter
    }

    // Method to add a new member
    @Override
    public void addMember() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Member member = new Member(name); // Create a new Member object
        adaptor.addMember(member); // Add the member using the adapter
    }

    // Method to remove an existing member
    @Override
    public void removeMember() {
        System.out.print("Enter member ID: ");
        int memberId = Integer.parseInt(scanner.nextLine());
        adaptor.removeMember(memberId); // Remove the member using the adapter
    }

    // Method to list all members
    @Override
    public void listMembers() {
        adaptor.listMembers(); // List members using the adapter
    }

    // Method to allow a member to borrow a book
    @Override
    public void borrowBook() {
        int bookId;
        System.out.print("Enter memberId of borrower: ");
        int memberId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter bookID to loan: ");
        bookId = Integer.parseInt(scanner.nextLine());
        Loan loan = new Loan(memberId, bookId);
        adaptor.borrowBook(loan); // Borrow the book using the adapter
    }

    // Method to allow a member to return a borrowed book
    @Override
    public void returnBook() {
        int bookId;
        int memberId;
        System.out.print("Enter memberID of returner: ");
        memberId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter bookID to be return: ");
        bookId = Integer.parseInt(scanner.nextLine());
        adaptor.returnBook(memberId, bookId); // Return the book using the adapter
    }

    // Method to list all current loans
    @Override
    public void listLoans() {
        adaptor.listLoans(); // List loans using the adapter
    }

    // Method to list the loan history
    @Override
    public void listHistory() {
        adaptor.listHistory(); // List loan history using the adapter
    }

    // Method to search for records in the database
    @Override
    public void search() {
        String searchTable;
        String searchField;
        String searchString;
        System.out.print("Enter search table: ");
        searchTable = scanner.nextLine();
        System.out.print("Enter search field: ");
        searchField = scanner.nextLine();
        System.out.print("Enter search string: ");
        searchString = scanner.nextLine();
        adaptor.search(searchTable, searchField, searchString); // Perform the search using the adapter
    }
}
