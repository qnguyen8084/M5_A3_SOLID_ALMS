/*
 * Quy Nguyen
 * CS635
 * M5 Assignment: Assignment 3: SOLID Principle Application
 * Adaptive Library Management System - SOLID Edition
 * DBConsoleAdapter.java
 * Nov 11, 2024
 */

package AdaptiveLibraryManagementSystem;

public class DBConsoleAdapter {
    private final BookOperations bookOperations;
    private final MemberOperations memberOperations;
    private final LoanOperations loanOperations;
    private final HistoryOperations historyOperations;
    private final SearchOperations searchOperations;

    public DBConsoleAdapter(BookOperations bookOperations, MemberOperations memberOperations,
                            LoanOperations loanOperations, HistoryOperations historyOperations,
                            SearchOperations searchOperations) {
        this.bookOperations = bookOperations;
        this.memberOperations = memberOperations;
        this.loanOperations = loanOperations;
        this.historyOperations = historyOperations;
        this.searchOperations = searchOperations;
    }

    public void addBook(Book book) {
        bookOperations.addBook(book);
    }

    public void removeBook(int bookId) {
        bookOperations.removeBook(bookId);
    }

    public void listBooks() {
        bookOperations.listBooks();
    }

    public void addMember(Member member) {
        memberOperations.addMember(member);
    }

    public void removeMember(int memberId) {
        memberOperations.removeMember(memberId);
    }

    public void listMembers() {
        memberOperations.listMembers();
    }

    public void borrowBook(Loan loan) {
        loanOperations.borrowBook(loan);
    }

    public void returnBook(int memberId, int bookId) {
        loanOperations.returnBook(memberId, bookId);
    }

    public void listLoans() {
        loanOperations.listLoans();
    }

    public void search(String table, String searchField, String searchString) {
        searchOperations.search(table, searchField, searchString);
    }

    public void listHistory() {
        historyOperations.listHistory();
    }
}
