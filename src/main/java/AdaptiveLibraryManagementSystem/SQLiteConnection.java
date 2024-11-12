/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * SQLiteConnection.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection implements DBConnection{
    private static final String URL = "jdbc:sqlite:myLibrary.db";

    @Override
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
