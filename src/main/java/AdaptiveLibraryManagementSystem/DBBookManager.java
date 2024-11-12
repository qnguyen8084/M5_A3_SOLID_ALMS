/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * DBBookManager.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

import java.sql.*;

public class DBBookManager implements Addable<Book>, Removable, Searchable, Listable {
    private final Logger logger;
    private final DBConnection dbConnection;

    public DBBookManager(Logger logger, DBConnection dbConnection) {
        this.logger = logger;
        this.dbConnection = dbConnection;
    }
    // Method to add a new book to the database
    @Override
    public void add(Book book) {
        // SQL query for inserting a book into the books table
        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
        try (Connection conn = dbConnection.connect(); // Establish connection
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepare the statement
            stmt.setString(1, book.getTitle()); // Set the title parameter
            stmt.setString(2, book.getCreator()); // Set the author parameter
            stmt.executeUpdate(); // Execute the update to add the book
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle any SQL exceptions
        }
        // Log the transaction with the book's title and author replaced in the SQL query
        logger.logEvent(sql.replaceFirst("\\?", book.getTitle()).replaceFirst("\\?", book.getCreator())); // Log the transaction with the updated SQL query
    }

    // Method to remove a book from the database by its ID
    @Override
    public void remove(int bookId) {
        // SQL query for deleting a book from the books table by its ID
        if (!entryExists(bookId)) {
            System.out.println("Book with bookId " + bookId + " does not exist");
            return;
        }
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = dbConnection.connect(); // Establish connection
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepare the statement
            stmt.setInt(1, bookId); // Set the book ID parameter
            stmt.executeUpdate();// Execute the update to remove the book
            System.out.println("Book with bookId " + bookId + " has been removed");
        } catch (SQLException e) {
            System.out.println("Item does not exist"); // Handle any SQL exceptions
        }
        // Log the transaction with the book ID replaced in the SQL query
        logger.logEvent(sql.replaceFirst("\\?", String.valueOf(bookId)));
    }

    // Method to list all books in the database

    @Override
    public void search(String searchString) {
        String sql = "SELECT * FROM books WHERE title = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, searchString);
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

    @Override
    public void list() {
        // SQL query for selecting all books from the books table
        String sql = "SELECT * FROM books";
        try (Connection conn = dbConnection.connect(); // Establish connection
             Statement stmt = conn.createStatement(); // Create a statement
             ResultSet rs = stmt.executeQuery(sql)) { // Execute the query and get the result set
            // Iterate through the result set and display each book's details
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Title: " + rs.getString("title") +
                        ", Author: " + rs.getString("author") +
                        ", Available: " + (rs.getInt("isAvailable") == 1 ? "Yes" : "No"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle any SQL exceptions
        }
    }

    public boolean entryExists(int bookId) {
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
}
