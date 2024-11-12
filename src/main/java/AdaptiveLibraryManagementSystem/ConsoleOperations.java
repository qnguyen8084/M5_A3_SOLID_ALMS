/*
 * Quy Nguyen - Dhruv Shah
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * ConsoleOperations.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

// Interface for book-related operations via console, such as adding, removing, and listing books.
interface ConsoleBookOperations {
    void addBook(); // Method to add a book via console input.
    void removeBook(); // Method to remove a book via console input.
    void listBooks(); // Method to list all books via console.
    void searchBook();
}

// Interface for user-related operations via console, such as adding, removing, and listing members.
interface ConsoleMemberOperations {
    void addMember(); // Method to add a member via console input.
    void removeMember(); // Method to remove a member via console input.
    void listMembers(); // Method to list all members via console.
    void searchMember();
}

// Interface for loan-related operations via console, such as borrowing, returning books, and listing loans.
interface ConsoleLoanOperations {
    void borrowBook(); // Method to borrow a book via console input.
    void returnBook(); // Method to return a book via console input.
    void listLoans(); // Method to list all loans via console.
    void searchLoan();
}

interface ConsoleSearchOperation {
    void search(); // Method to search for a specific item in the database.
}

interface ConsoleHistoryOperation {
    void listHistory(); // Method to list the transaction history.
}