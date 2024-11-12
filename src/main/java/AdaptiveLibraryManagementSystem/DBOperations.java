/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * DBOperations.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

// Interface for database operations related to searching in a specified table and field.
interface DBOperations {
    void search(String table, String searchField, String searchString); // Method to perform a search in the database.
}