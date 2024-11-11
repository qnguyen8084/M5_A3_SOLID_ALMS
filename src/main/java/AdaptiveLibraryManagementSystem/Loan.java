/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * Loan.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

/**
 * The Loan class represents a loan record in the library management system.
 * It stores information about which member has borrowed which book.
 */
public class Loan {
    // Instance variables
    private int id;                // Unique ID for the loan record
    private final int bookId;      // ID of the book being borrowed
    private final int memberId;    // ID of the member borrowing the book

   // Constructs a Loan object with a specified loan ID, book ID, and member ID.
    public Loan(int id, int memberId, int bookId) {
        this.id = id;               // Initialize loan ID
        this.bookId = bookId;       // Initialize book ID
        this.memberId = memberId;   // Initialize member ID
    }

    // Constructs a Loan object without specifying the loan ID (for creating new loan records).
    public Loan(int memberId, int bookId) {
        this.bookId = bookId;       // Initialize book ID
        this.memberId = memberId;   // Initialize member ID
    }

    /**
     * Gets the ID of the loan.
     * 
     * @return The loan ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the ID of the book being borrowed.
     * 
     * @return The book ID.
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Gets the ID of the member borrowing the book.
     * 
     * @return The member ID.
     */
    public int getMemberId() {
        return memberId;
    }
}
