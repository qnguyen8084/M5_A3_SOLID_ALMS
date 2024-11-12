/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * Operations.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

// Interface for book-related operations using the adapter, such as adding, removing, and listing books.
interface BookOperations {
    void addBook(Book book); // Method to add a new book.
    void removeBook(int bookId); // Method to remove a book by its ID.
    void listBooks(); // Method to list all books.
}

// Interface for user-related operations using the adapter, such as adding, removing, and listing members.
interface MemberOperations {
    void addMember(Member member); // Method to add a new member.
    void removeMember(int memberId); // Method to remove a member by their ID.
    void listMembers(); // Method to list all members.
}

// Interface for loan-related operations using the adapter, such as borrowing, returning books, and listing loans.
interface LoanOperations {
    void borrowBook(Loan loan); // Method for a member to borrow a book.
    void returnBook(int memberId, int bookId); // Method for a member to return a borrowed book.
    void listLoans(); // Method to list all current loans.
}

interface HistoryOperations {
    void listHistory();
}

interface SearchOperations {
    void search(String table, String searchField, String searchString);
}