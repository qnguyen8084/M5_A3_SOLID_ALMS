/*
 * Quy Nguyen
 * Dhruv Shah
 * CS635
 * Adaptive Library Management System
 * User.java
 * Sun, Sep 29 2024
 */

package AdaptiveLibraryManagementSystem;

/**
 * The User class is an abstract base class that represents a user in the library system.
 * It holds the basic attribute 'name' for any type of user (e.g., member, employee).
 */
public abstract class User {
    // Name of the user
    private final String name;

    /**
     * Constructor to initialize the name of the user.
     * 
     * @param name The name of the user.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the user.
     * 
     * @return The user's name.
     */
    public String getName() {
        return name;
    }
}

/**
 * The FetchId interface declares a method for fetching the ID of a user.
 * It is implemented by classes that represent specific types of users with unique IDs.
 */
interface FetchId {
    /**
     * Gets the unique ID of the user.
     * 
     * @return The user's ID.
     */
    int getId();
}

/**
 * The Employee class represents an employee of the library, inheriting from the User class
 * and implementing the FetchId interface to provide a unique employee ID.
 */
class Employee extends User implements FetchId {
    // Unique ID for the employee
    private int employeeId;

    // Constructor to create an Employee object with just the name (used when the employeeId is not yet known).
     
    public Employee(String name) {
        super(name);  // Call the User class constructor to set the name
    }

    // Constructor to create an Employee object with both the employee ID and name.
    
    public Employee(int employeeId, String name) {
        super(name);  // Call the User class constructor to set the name
        this.employeeId = employeeId;  // Initialize the employee's unique ID
    }

    /**
     * Gets the unique ID of the employee.
     * 
     * @return The employee's ID.
     */
    @Override
    public int getId() {
        return employeeId;
    }
}

class Member extends User implements FetchId {
    // Unique ID for the member
    private int memberId;

    //Constructor to create a Member object with just the name (used when the memberId is not yet known).

    public Member(String name) {
        super(name);  // Call the User class constructor to set the name
    }

    // Constructor to create a Member object with both the member ID and name.

    public Member(int memberId, String name) {
        super(name);  // Call the User class constructor to set the name
        this.memberId = memberId;  // Initialize the member's unique ID
    }

    /**
     * Gets the unique ID of the member.
     *
     * @return The member's ID.
     */
    @Override
    public int getId() {
        return memberId;
    }
}