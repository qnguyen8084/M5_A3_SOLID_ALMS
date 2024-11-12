/*
 * Quy Nguyen - Dhruv Shah
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * AdministratorInterface.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

import org.sqlite.core.DB;

import java.util.Scanner;

public class AdministratorInterface implements ConsoleBookOperations, ConsoleMemberOperations, ConsoleLoanOperations,
        ConsoleHistoryOperation, ConsoleSearchOperation {

    private final DBConsoleAdapter adaptor;
    private final Scanner scanner = new Scanner(System.in);

    public AdministratorInterface() {
        DBHistoryLogger logger = new DBHistoryLogger(new SQLiteHistoryConnection());
        DBConnection dbConnection = new SQLiteConnection();
        this.adaptor = new DBConsoleAdapter(
                new BookConsoleAdapter(new DBBookManager(logger, dbConnection)),
                new MemberConsoleAdapter(new DBMemberManager(logger, dbConnection)),
                new LoanConsoleAdapter(new DBLoanManager(logger, dbConnection)),
                new HistoryConsoleAdapter(logger),
                new SearchConsoleAdapter(new DBManager(dbConnection))
        );
    }

    private String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    // Method to add a new book
    @Override
    public void addBook() {
        Book book = new Book(getInput("Enter title: "), getInput("Enter author: "));
        adaptor.addBook(book);
    }

    // Method to remove an existing book
    @Override
    public void removeBook() {
        int bookId = Integer.parseInt(getInput("Enter book ID: "));
        adaptor.removeBook(bookId);
    }

    // Method to list all available books
    @Override
    public void listBooks() {
        adaptor.listBooks(); // List books using the adapter
    }

    @Override
    public void searchBook(){
        adaptor.searchBook(getInput("Enter title of book to search: "));
    }

    // Method to add a new member
    @Override
    public void addMember() {
        Member member = new Member(getInput("Enter name: "));
        adaptor.addMember(member);
    }

    // Method to remove an existing member
    @Override
    public void removeMember() {
        int memberId = Integer.parseInt(getInput("Enter member ID: "));
        adaptor.removeMember(memberId);
    }

    // Method to list all members
    @Override
    public void listMembers() {
        adaptor.listMembers(); // List members using the adapter
    }

    @Override
    public void searchMember(){
        adaptor.searchMember(getInput("Enter member name: "));
    }

    // Method to allow a member to borrow a book
    @Override
    public void borrowBook() {
        int memberId = Integer.parseInt(getInput("Enter memberId of borrower: "));
        int bookId = Integer.parseInt(getInput("Enter bookID to loan: "));
        Loan loan = new Loan(memberId, bookId);
        adaptor.borrowBook(loan);
    }

    // Method to allow a member to return a borrowed book
    @Override
    public void returnBook() {
        int memberId = Integer.parseInt(getInput("Enter memberID of returner: "));
        int bookId = Integer.parseInt(getInput("Enter bookID to be return: "));
        adaptor.returnBook(memberId, bookId);
    }

    // Method to list all current loans
    @Override
    public void listLoans() {
        adaptor.listLoans(); // List loans using the adapter
    }

    @Override
    public void searchLoan(){
        adaptor.searchLoan(getInput("Enter loan ID to search: "));
    }

    // Method to list the loan history
    @Override
    public void listHistory() {
        adaptor.listHistory(); // List loan history using the adapter
    }

    // Method to search for records in the database
    @Override
    public void search() {
        String searchTable = getInput("Enter search table: ");
        String searchField = getInput("Enter search field: ");
        String searchString = getInput("Enter search string: ");
        adaptor.search(searchTable, searchField, searchString);
    }
}
