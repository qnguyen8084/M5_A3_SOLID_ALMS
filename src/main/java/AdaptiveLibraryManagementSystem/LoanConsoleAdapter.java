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
    private final LoanService loanService;

    public LoanConsoleAdapter(LoanService loanService) {
        this.loanService = loanService;
    }

    @Override
    public void borrowBook(Loan loan) {
        loanService.borrowBook(loan);
    }

    @Override
    public void returnBook(int memberId, int bookId) {
        loanService.returnBook(memberId, bookId);
    }

    @Override
    public void listLoans() {
        loanService.listLoans();
    }

    @Override
    public void searchLoan(String id) {
        loanService.searchLoan(Integer.parseInt(id));
    }
}
