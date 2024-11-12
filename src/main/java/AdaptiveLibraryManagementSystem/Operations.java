/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * Operations.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;



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
interface ConsoleMemberOperations {
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
