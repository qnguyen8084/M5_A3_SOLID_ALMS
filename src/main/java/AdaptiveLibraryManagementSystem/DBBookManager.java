/*
 * Quy Nguyen
 * Dhruv Shah
 * CS635
 * Adaptive Library Management System
 * DBBookManager.java
 * Sun, Sep 29 2024
 */

package AdaptiveLibraryManagementSystem;

import java.sql.*;
import java.util.Arrays;

import static AdaptiveLibraryManagementSystem.DBManager.connect;

public class DBBookManager implements Addable<Book>, Removable, Searchable, Listable {
    private final Logger logger;

    public DBBookManager(Logger logger) {
        this.logger = logger;
    }
    // Method to add a new book to the database
    @Override
    public void add(Book book) {
        // SQL query for inserting a book into the books table
        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
        try (Connection conn = connect(); // Establish connection
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepare the statement
            stmt.setString(1, book.getTitle()); // Set the title parameter
            stmt.setString(2, book.getCreator()); // Set the author parameter
            stmt.executeUpdate(); // Execute the update to add the book
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle any SQL exceptions
        }

        // Replace placeholders in the SQL query with actual values for logging
        for (String s : Arrays.asList(book.getTitle(), book.getCreator())) {
            sql = sql.replaceFirst("\\?", s);
        }
        logger.logEvent(sql); // Log the transaction with the updated SQL query
    }

    // Method to remove a book from the database by its ID
    @Override
    public void remove(int bookId) {
        // SQL query for deleting a book from the books table by its ID
        String sql = "DELETE FROM BOOKS WHERE ID = (?)";
        try (Connection conn = connect(); // Establish connection
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepare the statement
            stmt.setInt(1, bookId); // Set the book ID parameter
            stmt.executeUpdate(); // Execute the update to remove the book
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle any SQL exceptions
        }
        // Log the transaction with the book ID replaced in the SQL query
        logger.logEvent(sql.replaceFirst("\\?", String.valueOf(bookId)));
    }

    // Method to list all books in the database

    @Override
    public void search(String searchString) {
        String table = "books";
        String searchField = "title";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(
                     STR."SELECT * FROM \{table} WHERE \{searchField} = ?")) {
            pstmt.setString(1, searchString);
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

    @Override
    public void list() {
        // SQL query for selecting all books from the books table
        String sql = "SELECT * FROM books";
        try (Connection conn = connect(); // Establish connection
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
}
