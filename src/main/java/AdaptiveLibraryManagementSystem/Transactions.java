/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * Transactions.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

interface Addable<T> {
    void add(T obj);
}

interface Removable {
    void remove(int id);
}
interface Listable {
    void list();
}

interface Searchable {
    void search(String searchTerm);
}

