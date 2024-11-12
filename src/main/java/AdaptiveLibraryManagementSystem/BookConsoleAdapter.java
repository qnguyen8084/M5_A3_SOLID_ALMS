/*
 * Quy Nguyen - Dhruv Shah
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * BookConsoleAdapter.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

public class BookConsoleAdapter implements BookOperations {
    private final DBBookManager bookManager;

    public BookConsoleAdapter(DBBookManager bookManager) {
        this.bookManager = bookManager;
    }

    @Override
    public void addBook(Book book) {
        bookManager.add(book);
    }

    @Override
    public void removeBook(int bookId) {
        bookManager.remove(bookId);
    }

    @Override
    public void listBooks() {
        bookManager.list();
    }

    @Override
    public void searchBook(String title) {
        bookManager.search(title);
    }
}
