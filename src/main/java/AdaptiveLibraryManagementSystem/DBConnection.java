/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * DBConnection.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnection {
    Connection connect() throws SQLException;
}
