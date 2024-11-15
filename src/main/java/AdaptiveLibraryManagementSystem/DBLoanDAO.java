/*
 * Quy Nguyen - Dhruv Shah
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * DBLoanDAO.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBLoanDAO implements LoanDAO {
    private final DBConnection dbConnection;
    private final DBHistoryLogger logger;

    public DBLoanDAO(DBConnection dbConnection, DBHistoryLogger logger) {
        this.dbConnection = dbConnection;
        this.logger = logger;
    }

    @Override
    public void addLoan(Loan loan) throws SQLException {
        String sql = "INSERT INTO loans (memberId, bookId) VALUES (?, ?)";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loan.getMemberId());
            stmt.setInt(2, loan.getBookId());
            stmt.executeUpdate();
        }
        logger.logEvent(sql.replaceFirst("\\?", String.valueOf(loan.getMemberId()))
                .replaceFirst("\\?", String.valueOf(loan.getBookId())));
    }

    @Override
    public void removeLoan(int bookId, int memberId) throws SQLException {
        String sql = "DELETE FROM loans WHERE (memberId, bookId) = (?, ?)";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, memberId);
            stmt.setInt(2, bookId);
            stmt.executeUpdate();
        }
        logger.logEvent(sql.replaceFirst("\\?", String.valueOf(memberId))
                .replaceFirst("\\?", String.valueOf(bookId)));
    }

    @Override
    public List<Loan> listLoans() throws SQLException {
        List<Loan> loans = new ArrayList<>();
        String sql = "SELECT * FROM loans";
        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                loans.add(new Loan(rs.getInt("id"), rs.getInt("memberId"), rs.getInt("bookId")));
            }
        }
        return loans;
    }

    @Override
    public Loan searchLoan(int loanId) throws SQLException {
        String sql = "SELECT * FROM loans WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, loanId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Loan(rs.getInt("id"), rs.getInt("memberId"), rs.getInt("bookId"));
                }
            }
        }
        return null;
    }

    @Override
    public boolean bookExists(int bookId) throws SQLException {
        String sql = "SELECT * FROM books WHERE ID = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    @Override
    public boolean memberExists(int memberId) throws SQLException {
        String sql = "SELECT * FROM members WHERE ID = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, memberId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    @Override
    public boolean isBookAvailable(int bookId) throws SQLException {
        String sql = "SELECT isAvailable FROM books WHERE id = " + bookId;
        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            rs.next();
            return rs.getInt("isAvailable") == 1;
        }
    }

    @Override
    public void setBookAvailability(int availability, int bookId) throws SQLException {
        String sql = "UPDATE books SET isAvailable = ? WHERE id = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, availability);
            stmt.setInt(2, bookId);
            stmt.executeUpdate();
        }
        logger.logEvent(sql.replaceFirst("\\?", String.valueOf(availability))
                .replaceFirst("\\?", String.valueOf(bookId)));
    }
}
