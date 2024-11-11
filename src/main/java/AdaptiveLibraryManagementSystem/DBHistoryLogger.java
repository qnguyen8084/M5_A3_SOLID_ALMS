/*
 * Quy Nguyen
 * Dhruv Shah
 * CS635
 * Adaptive Library Management System
 * DBHistoryLogger.java
 * Sun, Sep 29 2024
 */


package AdaptiveLibraryManagementSystem;

import java.sql.*;

interface Logger {
    void log(String message);
}

public class DBHistoryLogger implements Logger{

    private static final String HISTORY_DB_URL = "jdbc:sqlite:myLibraryHistory.db";
    private static final String CREATE_TRANSACTION_HISTORY_TABLE = """
                    CREATE TABLE IF NOT EXISTS history(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    operation TEXT NOT NULL)""";


    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(HISTORY_DB_URL);
    }

    public static void initializeDatabase() {

        // Initialize Connection conn object to be initialized with Connection object
        // returned from DriverManager.getConnection(URL);
        // Statements are passed to try because I learned somewhere this will also
        // close conn connection after method is done with execution.
        // This try block will create the tables in the database if they don't exist
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(CREATE_TRANSACTION_HISTORY_TABLE);
        } catch (SQLException e) { // throws an exception if SQL exception is caught.
            throw new RuntimeException(e);
        }
    }

    public static void logTransaction(String query) {
        String sql = "INSERT INTO history (operation) VALUES (?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, query);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void listHistory() {
        String sql = "SELECT * FROM history";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", operation: " + rs.getString("operation"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void log(String message) {
        String sql = "INSERT INTO history (operation) VALUES (?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, message);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
