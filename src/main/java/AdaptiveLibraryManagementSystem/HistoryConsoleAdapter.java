/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * HistoryConsoleAdapter.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

public class HistoryConsoleAdapter implements HistoryOperation {
    private final DBHistoryLogger dbHistoryLogger;

    public HistoryConsoleAdapter(DBHistoryLogger dbHistoryLogger) {
        this.dbHistoryLogger = dbHistoryLogger;
    }

    @Override
    public void listHistory() {
        dbHistoryLogger.listHistory();
    }
}
