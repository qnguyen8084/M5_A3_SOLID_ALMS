/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * SearchConsoleAdapter.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

public class SearchConsoleAdapter implements SearchOperations {
    private final DBManager dbManager;

    public SearchConsoleAdapter(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public void search(String table, String searchField, String searchString) {
        dbManager.search(table, searchField, searchString);
    }
}