/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * LoanConsoleAdapter.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

public class LoanConsoleAdapter implements LoanOperations {
    private final DBLoanManager loanManager;

    public LoanConsoleAdapter(DBLoanManager loanManager) {
        this.loanManager = loanManager;
    }

    @Override
    public void borrowBook(Loan loan) {
        loanManager.borrowBook(loan);
    }

    @Override
    public void returnBook(int memberId, int bookId) {
        loanManager.returnBook(memberId, bookId);
    }

    @Override
    public void listLoans() {
        loanManager.list();
    }

    @Override
    public void searchLoan(String id) {
        loanManager.search(id);
    }
}
