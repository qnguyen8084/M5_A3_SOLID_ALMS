/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * HistoryConsoleAdapter.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

public class HistoryConsoleAdapter implements HistoryOperations {
    @Override
    public void listHistory() {
        DBHistoryLogger.listHistory();
    }
}
