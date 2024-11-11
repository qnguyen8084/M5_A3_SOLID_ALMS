/*
 * Quy Nguyen
 * Dhruv Shah
 * CS635
 * Adaptive Library Management System
 * DBManager.java
 * Sun, Sep 29 2024
 */

package AdaptiveLibraryManagementSystem;
// imported libraries needed to interact with SQLite database
import java.sql.*;

// Definition of DBManager
public class DBManager implements DBOperations {
    // Declare and initialize private static final String URL with location of myLibrary.db
    private static final String URL = "jdbc:sqlite:myLibrary.db";

    // Initialize a String variable createBooksTable with an SQL string to create
    // a table named books with 4 columns; id, title, author, and isAvailable
    // if table does not exist
    private static final String CREATE_BOOKS_TABLE = """
            CREATE TABLE IF NOT EXISTS books(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            title TEXT NOT NULL,
            author TEXT NOT NULL,
            isAvailable INTEGER NOT NULL DEFAULT 1)""";

    // Initialize a String variable createMembersTable with an SQL string to create
    // a table named members with 2 col umns; id and name if table does not exist
    private static final String CREATE_MEMBERS_TABLE = """
            CREATE TABLE IF NOT EXISTS members(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL)""";

    // Initialize a String variable createLoansTable with an SQL string to create
    // a table named loans with 3 columns; id, bookId, and memberId where this bookId,
    // memberId will be referenced to id entries in books and members table, respectively.
    private static final String CREATE_LOANS_TABLE = """
            CREATE TABLE IF NOT EXISTS loans(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            bookId INTEGER NOT NULL,
            memberId INTEGER NOT NULL,
            FOREIGN KEY (bookId) REFERENCES books(id),
            FOREIGN KEY (memberId) REFERENCES members(id))""";

    // Definition of createTables method that creates 3 tables in our relational database
    // for persistent storage.

    public static void initializeDatabase() {

        // Initialize Connection conn object to be initialized with Connection object
        // returned from DriverManager.getConnection(URL);
        // Statements are passed to try because I learned somewhere this will also
        // close conn connection after method is done with execution.
        // This try block will create the tables in the database if they don't exist
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(CREATE_BOOKS_TABLE);
            stmt.execute(CREATE_MEMBERS_TABLE);
            stmt.execute(CREATE_LOANS_TABLE);
        } catch (SQLException e) { // throws an exception if SQL exception is caught.
            throw new RuntimeException(e);
        }
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Search function to search.
    @Override
    public void search(String table, String searchField, String searchString) {
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

}
