/*
 * Quy Nguyen
 * Dhruv Shah
 * CS635
 * Adaptive Library Management System
 * AdminConsoleCommander.java
 * Sun, Sep 29 2024
 */

package AdaptiveLibraryManagementSystem;

import org.jetbrains.annotations.NotNull;

/**
 This is the AdminCommander that acts an interface between the user and the Adaptive Library Management
 System. It is responsible for evaluating the command input to decide what request to send to
 the adminInterface.
 */

// TODO: Decorator to add commands
public class AdminConsoleCommander {

    // This instantiates an AdministratorInterface class object
    private final AdministratorInterface adminInterface = new AdministratorInterface();

    // This class is instantiated the constructor will begin the case statement.
    public AdminConsoleCommander(String command) {
        execute(command);
    }

    // This case statement will be where the application logic makes the decision on which request to send
    // to or call from adminInterface. Case statement cases are pretty self-explanatory.
    private void execute(@NotNull String command) {
        switch (command) {
            case "addBook":
                adminInterface.addBook();
                break;
            case "removeBook":
                adminInterface.removeBook();
                break;
            case "listBooks":
                adminInterface.listBooks();
                break;
            case "addMember":
                adminInterface.addMember();
                break;
            case "removeMember":
                adminInterface.removeMember();
                break;
            case "listMembers":
                adminInterface.listMembers();
                break;
            case "borrowBook":
                adminInterface.borrowBook();
                break;
            case "returnBook":
                adminInterface.returnBook();
                break;
            case "listLoans":
                adminInterface.listLoans();
                break;
            case "search":
                adminInterface.search();
                break;
            case "listHistory":
                adminInterface.listHistory();
                break;
            case "exit":
                System.out.println("Thank you for using Adaptive Library Management System!");
                System.exit(0);
            default:
                System.out.println("Unknown command.");
                break;
        }
    }

}
