/*
 * Quy Nguyen - Dhruv Shah
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * AdminConsoleCommander.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 This is the AdminCommander that acts an interface between the user and the Adaptive Library Management
 System. It is responsible for evaluating the command input to decide what request to send to
 the adminInterface.
 */

interface Command {
    void execute();
}

public class AdminConsoleCommander {
    private final Map<String, Command> commandMap = new HashMap<>();
    private final AdministratorInterface adminInterface = new AdministratorInterface();
    // This class is instantiated the constructor will begin the case statement.
    public AdminConsoleCommander() {
        commandMap.put("addBook", adminInterface::addBook);
        commandMap.put("removeBook", adminInterface::removeBook);
        commandMap.put("listBooks", adminInterface::listBooks);
        commandMap.put("searchBook", adminInterface::searchBook);
        commandMap.put("addMember", adminInterface::addMember);
        commandMap.put("removeMember", adminInterface::removeMember);
        commandMap.put("listMembers", adminInterface::listMembers);
        commandMap.put("searchMember", adminInterface::searchMember);
        commandMap.put("borrowBook", adminInterface::borrowBook);
        commandMap.put("returnBook", adminInterface::returnBook);
        commandMap.put("listLoans", adminInterface::listLoans);
        commandMap.put("searchLoan", adminInterface::searchLoan);
        commandMap.put("search", adminInterface::search);
        commandMap.put("listHistory", adminInterface::listHistory);
        commandMap.put("exit", () -> System.exit(0));
    }

    // This case statement will be where the application logic makes the decision on which request to send
    // to or call from adminInterface. Case statement cases are pretty self-explanatory.
    public void execute(@NotNull String command) {
        Command cmd = commandMap.get(command);
        if (cmd != null) {
            cmd.execute();
        } else {
            System.out.println("Unknown command.");
        }
    }

}
