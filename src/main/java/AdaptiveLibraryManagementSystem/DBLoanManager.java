/*
 * Quy Nguyen - Dhruv Shah
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * DBLoanManager.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

import java.sql.*;

public class DBLoanManager implements Addable<Loan>, Searchable, Listable {
    private final DBHistoryLogger logger;
    private final DBConnection dbConnection;

    public DBLoanManager(DBHistoryLogger logger, DBConnection dbConnection) {
        this.logger = logger;;
        this.dbConnection = dbConnection;
    }
    // Method to handle book borrowing process
    public void borrowBook(Loan loan) {
        if (!bookExists(loan.getBookId())) {
            System.out.println("Book does not exist!");
            return;
        }
        if (isBookAvailable(loan.getBookId())) {
            add(loan);
        } else {
            System.out.println("Book is not available!");
        }
    }

    // Method to handle book return process
    public void returnBook(int memberId, int bookId) {
        removeLoan(bookId, memberId);
    }

    // Method to list all loan records in the system
    @Override
    public void list() {
        String sql = "SELECT * FROM loans";
        try (Connection conn = dbConnection.connect();
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
        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            rs.next();
            boolean isAvailable = rs.getInt("isAvailable") == 1;
            System.out.println("isAvailable: " + (isAvailable ? "Yes" : "No"));// Check if the book is available
            return isAvailable;
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle SQL exceptions
        }
        return false; // If an error occurs, assume the book is unavailable
    }

    // Method to set the availability status of a book
    public void setBookAvailability(int availability, int bookId) {
        String sql = "UPDATE books SET isAvailable = ? WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, availability); // Set the availability status
            stmt.setInt(2, bookId); // Set the book ID
            stmt.executeUpdate(); // Execute the update
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle SQL exceptions
        }
        logger.logEvent(sql.replaceFirst("\\?", String.valueOf(availability))
                .replaceFirst("\\?", String.valueOf(bookId)));
    }

    // Method to add a loan record to the database
    @Override
    public void add(Loan loan) {
        String sql = "INSERT INTO loans (memberId, bookId) VALUES (?, ?)";
        if (!memberExists(loan.getMemberId()) || !bookExists(loan.getBookId())) {
            System.out.println("Member or book does not exist");
            return;
        }
        setBookAvailability(0, loan.getBookId());
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loan.getMemberId()); // Set the member ID
            stmt.setInt(2, loan.getBookId()); // Set the book ID
            stmt.executeUpdate();
            System.out.println("Loan added to table"); // Execute the insert
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle SQL exceptions
        }
        logger.logEvent(sql.replaceFirst("\\?", String.valueOf(loan.getMemberId()))
                .replaceFirst("\\?", String.valueOf(loan.getBookId())));
    }

    // Method to remove a loan record from the database
    public void removeLoan(int bookId, int memberId) {
        // Add logic to check if there is loan that has includes both bookId and memberId
        setBookAvailability(1, bookId);
        String sql = "DELETE FROM loans WHERE (memberId, bookId) = (?, ?)";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, memberId); // Set the member ID
            stmt.setInt(2, bookId); // Set the book ID
            stmt.executeUpdate(); // Execute the delete
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle SQL exceptions
        }
        logger.logEvent(sql.replaceFirst("\\?", String.valueOf(memberId))
                .replaceFirst("\\?", String.valueOf(bookId)));
    }

    @Override
    public void search(String searchString) {
        String sql = "SELECT * FROM loans WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(searchString));
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int columnCount = rs.getMetaData().getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(rs.getMetaData().getColumnName(i) + ": " + rs.getString(i) + "\t");
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
        try (Connection conn = dbConnection.connect();
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
        try (Connection conn = dbConnection.connect();
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
