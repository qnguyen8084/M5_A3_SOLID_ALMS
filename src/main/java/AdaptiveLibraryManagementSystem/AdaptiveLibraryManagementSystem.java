/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * AdaptiveLibraryManagementSystem.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

// Declaration of Main class
public class AdaptiveLibraryManagementSystem {

    // Defining main driver code
    // Definition of main() and entrypoint into the AdaptiveLibraryManagementSystem application.0
    // It first instantiates a DBManager object with new DBManager() to initialize the database and it's
    // tables if it does not already exist.
    // It then instantiates an InteractiveConsole with new Interactive console to output prompts to the
    // user.
    public static void main(String[] args) {
        String WELCOME_MESSAGE = "Welcome to Adaptive Library Management System!";

        DBManager dbManager = new DBManager(new SQLiteConnection());
        DBHistoryLogger dbHistoryLogger = new DBHistoryLogger(new SQLiteHistoryConnection());
        dbManager.initializeDatabase();
        dbHistoryLogger.initializeDatabase();
        printMessage(WELCOME_MESSAGE);

        new ViewerInteractiveConsole();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

}