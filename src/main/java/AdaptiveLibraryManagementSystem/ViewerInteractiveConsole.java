/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * ViewerInteractiveConsole.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

import java.util.Scanner;

// Declaration of InteractiveConsole used for user interface
public class ViewerInteractiveConsole implements ViewerConsole {
    private final AdminConsoleCommander commander;
    // Constructor for interactive console
    public ViewerInteractiveConsole() {
        this.commander = new AdminConsoleCommander();
        System.out.println("Hello Administrator!\n" +
                "Welcome to the Adaptive Library Management System!");
        adminConsole();
    }

    public ViewerInteractiveConsole(int test) {
        this.commander = new AdminConsoleCommander();
        return;
    }

    @Override
    public void adminConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please choose an option \n" +
            "(addBook, removeBook, listBooks,\n" +
            "addMember, removeMember, listMembers,\n" +
            "borrowBook, returnBook, listLoans, \n" +
            "search, listHistory, exit): ");
            commander.execute(scanner.nextLine());
        }
    }
}
