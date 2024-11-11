/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * User.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

public abstract class User {
    private final String name;
    private int Id;

    public User(String name) {
        this.name = name;
    }

    public User(String name, int Id) {
        this.name = name;
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }
}

class Employee extends User {
    private int employeeId;

    public Employee(String name) {
        super(name);
    }

    public Employee(String name, int employeeId) {
        super(name);
        this.employeeId = employeeId;
    }

    @Override
    public int getId() {
        return employeeId;
    }
}

class Member extends User {
    private int memberId;

    public Member(String name) {
        super(name);
    }

    public Member(String name, int memberId) {
        super(name);
        this.memberId = memberId;
    }

    @Override
    public int getId() {
        return memberId;
    }
}