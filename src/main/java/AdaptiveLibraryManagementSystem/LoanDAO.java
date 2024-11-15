/*
 * Quy Nguyen - Dhruv Shah
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * DAOInterfaces.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;import java.sql.*;
import java.util.List;

public interface LoanDAO {
    void addLoan(Loan loan) throws SQLException;
    void removeLoan(int bookId, int memberId) throws SQLException;
    List<Loan> listLoans() throws SQLException;
    Loan searchLoan(int loanId) throws SQLException;
    boolean bookExists(int bookId) throws SQLException;
    boolean memberExists(int memberId) throws SQLException;
    boolean isBookAvailable(int bookId) throws SQLException;
    void setBookAvailability(int availability, int bookId) throws SQLException;
}