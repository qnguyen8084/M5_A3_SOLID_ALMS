/*
 * Quy Nguyen - Dhruv Shah
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * LoanService.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

import java.sql.SQLException;
import java.util.List;

public class LoanService {
    private final LoanDAO loanDAO;

    public LoanService(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }

    public void borrowBook(Loan loan) {
        try {
            if (!loanDAO.bookExists(loan.getBookId())) {
                System.out.println("Book does not exist!");
                return;
            }
            if (loanDAO.isBookAvailable(loan.getBookId())) {
                loanDAO.addLoan(loan);
                loanDAO.setBookAvailability(0, loan.getBookId());
            } else {
                System.out.println("Book is not available!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(int memberId, int bookId) {
        try {
            loanDAO.removeLoan(bookId, memberId);
            loanDAO.setBookAvailability(1, bookId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listLoans() {
        try {
            List<Loan> loans = loanDAO.listLoans();
            for (Loan loan : loans) {
                System.out.println("ID: " + loan.getId() +
                        ", memberID: " + loan.getMemberId() +
                        ", bookID: " + loan.getBookId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchLoan(int loanId) {
        try {
            Loan loan = loanDAO.searchLoan(loanId);
            if (loan != null) {
                System.out.println("ID: " + loan.getId() +
                        ", memberID: " + loan.getMemberId() +
                        ", bookID: " + loan.getBookId());
            } else {
                System.out.println("Loan not found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
