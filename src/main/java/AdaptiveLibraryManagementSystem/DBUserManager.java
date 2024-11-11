/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * DBUserManager.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

import java.sql.*;

import static AdaptiveLibraryManagementSystem.DBManager.connect;

/*
 * The DBUserManager class implements the DBUserOperations interface and
 * manages the database operations for library members, such as adding,
 * removing, and listing members.
 */
public class DBUserManager implements Addable<Member>, Removable, Searchable, Listable  {
    private final Logger logger;

    public DBUserManager(Logger logger) {
        this.logger = logger;
    }
    /*
     * Adds a new member to the members table in the database.
     * 
     * @param name The name of the new member to be added.
     */
    @Override
    public void add(Member member) {
        String sql = "INSERT INTO members (name) VALUES (?)";  // SQL query to add a new member
        try (Connection conn = DBManager.connect();              // Establish database connection
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepare SQL statement with the given query
            stmt.setString(1, member.getName());                              // Set the name parameter in the query
            stmt.executeUpdate();                                 // Execute the query to insert the member
        } catch (SQLException e) {
            System.out.println(e.getMessage());                   // Print SQL error if any occurs
        }

        // Log the transaction to history by replacing the first '?' with the member name
        logger.logEvent(sql.replaceFirst("\\?", member.getName()));
    }

    /*
     * Removes a member from the members table in the database based on the member ID.
     * 
     * @param memberId The ID of the member to be removed.
     */
    @Override
    public void remove(int memberId) {
        String sql = "DELETE FROM members WHERE ID = (?)";        // SQL query to delete a member by ID
        try (Connection conn = DBManager.connect();              // Establish database connection
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepare SQL statement with the given query
            stmt.setInt(1, memberId);                            // Set the memberId parameter in the query
            stmt.executeUpdate();                                // Execute the query to delete the member
        } catch (SQLException e) {
            System.out.println(e.getMessage());                  // Print SQL error if any occurs
        }

        // Log the transaction to history by replacing the first '?' with the member ID
        logger.logEvent(sql.replaceFirst("\\?", String.valueOf(memberId)));
    }
    /*
     * Lists all the members in the members table by retrieving their details from the database.
     */
    @Override
    public void list() {
        String sql = "SELECT * FROM members";                    // SQL query to retrieve all members
        try (Connection conn = DBManager.connect();              // Establish database connection
             Statement stmt = conn.createStatement();            // Create a statement object for executing the query
             ResultSet rs = stmt.executeQuery(sql)) {            // Execute the query and get the result set
            while (rs.next()) {
                // Loop through the result set and print member details
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());                  // Print SQL error if any occurs
        }
    }

    @Override
    public void search(String searchString) {
        String table = "members";
        String searchField = "name";
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
