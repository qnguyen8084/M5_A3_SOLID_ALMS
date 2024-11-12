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

    // This constructor is used for testing purposes
    public ViewerInteractiveConsole(int test) {
        this.commander = new AdminConsoleCommander();
    }

    @Override
    public void adminConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please choose an option \n" +
            "(addBook, removeBook, listBooks, searchBook\n" +
            "addMember, removeMember, listMembers,searchMember\n" +
            "borrowBook, returnBook, listLoans, searchLoan\n" +
            "search, listHistory, exit): ");
            commander.execute(scanner.nextLine());
        }
    }
}
