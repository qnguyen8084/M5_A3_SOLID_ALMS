/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * DBLoanManager.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

import java.sql.*;
import java.util.Arrays;

import static AdaptiveLibraryManagementSystem.DBManager.connect;

public class DBLoanManager implements Addable<Loan>, Searchable, Listable {
    private final Logger logger;

    public DBLoanManager(Logger logger) {
        this.logger = logger;
    }
    // Method to handle book borrowing process
    public void borrowBook(Loan loan) {
        // Check if the book is available before allowing it to be borrowed
        if (!bookExists(loan.getBookId())) {
            System.out.println("Book does not exist!");
            return;
        }
        if (isBookAvailable(loan.getBookId())) {
            // Set the book's availability to unavailable (0)
            setBookAvailability(0, loan.getBookId());
            // Add a loan record for the book and member
            add(loan);
        } else {
            System.out.println("Book is not available!");
        }
    }

    // Method to handle book return process
    public void returnBook(int memberId, int bookId) {
        // Set the book's availability to available (1)
        setBookAvailability(1, bookId);
        // Remove the loan record for the book and member
        removeLoan(bookId, memberId);
    }

    // Method to list all loan records in the system
    @Override
    public void list() {
        String sql = "SELECT * FROM loans";
        try (Connection conn = DBManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            // Loop through the result set and print each loan's details
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", memberID: " + rs.getInt("memberId") +
                        ", bookID: " + rs.getInt("bookId"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle SQL exceptions
        }
    }

    // Method to check if a book is available
    public boolean isBookAvailable(int bookId) {
        String sql = "SELECT isAvailable FROM books WHERE id = " + bookId;
        try {
            Connection conn = DBManager.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next(); // Move the cursor to the first result
            System.out.println("isAvailable: " + (rs.getInt("isAvailable") == 1 ? "Yes" : "No"));
            boolean isAvailable = rs.getInt("isAvailable") == 1; // Check if the book is available
            conn.close();
            return isAvailable;
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle SQL exceptions
        }
        return false; // If an error occurs, assume the book is unavailable
    }

    // Method to set the availability status of a book
    public void setBookAvailability(int availability, int bookId) {
        String sql = "UPDATE books SET isAvailable = ? WHERE id = ?";
        try (Connection conn = DBManager.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, availability); // Set the availability status
            stmt.setInt(2, bookId); // Set the book ID
            stmt.executeUpdate(); // Execute the update
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle SQL exceptions
        }
        // Replace placeholders in SQL query for logging purposes
        for (Integer s : Arrays.asList(availability, bookId)) {
            sql = sql.replaceFirst("\\?", String.valueOf(s));
        }
        logger.logEvent(sql); // Log the transaction
    }

    // Method to add a loan record to the database
    @Override
    public void add(Loan loan) {
        String sql = "INSERT INTO loans (memberId, bookId) VALUES (?, ?)";
        if(memberExists(loan.getMemberId()) && bookExists(loan.getBookId())) {
            System.out.println("Member and book exist");
        } else {
            System.out.println("Member or book does not exist");
            return;
        }
        try (Connection conn = DBManager.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loan.getMemberId()); // Set the member ID
            stmt.setInt(2, loan.getBookId()); // Set the book ID
            stmt.executeUpdate();
            System.out.println("Loan added to table"); // Execute the insert
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle SQL exceptions
        }
        // Replace placeholders in SQL query for logging purposes
        for (Integer s : Arrays.asList(loan.getMemberId(), loan.getBookId())) {
            sql = sql.replaceFirst("\\?", String.valueOf(s));
        }
        logger.logEvent(sql); // Log the transaction
    }

    // Method to remove a loan record from the database
    public void removeLoan(int bookId, int memberId) {
        // Add logic to check if there is loan that has includes both bookId and memberId
        String sql = "DELETE FROM loans WHERE (memberId, bookId) = (?, ?)";
        try (Connection conn = DBManager.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, memberId); // Set the member ID
            stmt.setInt(2, bookId); // Set the book ID
            stmt.executeUpdate(); // Execute the delete
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle SQL exceptions
        }
        // Replace placeholders in SQL query for logging purposes
        for (Integer s : Arrays.asList(memberId, bookId)) {
            sql = sql.replaceFirst("\\?", String.valueOf(s));
        }
        logger.logEvent(sql); // Log the transaction
    }

    @Override
    public void search(String searchString) {
        String table = "loans";
        String searchField = "id";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(
                     STR."SELECT * FROM \{table} WHERE \{searchField} = ?")) {
            pstmt.setInt(1, Integer.parseInt(searchString));
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Assuming the structure of the table is unknown, let's print out all columns
                    int columnCount = rs.getMetaData().getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(STR."\{rs.getMetaData().getColumnName(i)}: \{rs.getString(i)}\t");
                    }
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean bookExists(int bookId) {
        String sql = "SELECT * FROM books WHERE ID = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean memberExists(int memberId) {
        String sql = "SELECT * FROM members WHERE ID = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, memberId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
