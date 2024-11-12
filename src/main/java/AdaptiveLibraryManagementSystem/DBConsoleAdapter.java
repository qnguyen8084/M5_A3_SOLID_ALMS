/*
 * Quy Nguyen - Dhruv Shah
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
    private final HistoryOperation historyOperation;
    private final SearchOperation searchOperation;

    public DBConsoleAdapter(BookOperations bookOperations, MemberOperations memberOperations,
                            LoanOperations loanOperations, HistoryOperation historyOperation,
                            SearchOperation searchOperation) {
        this.bookOperations = bookOperations;
        this.memberOperations = memberOperations;
        this.loanOperations = loanOperations;
        this.historyOperation = historyOperation;
        this.searchOperation = searchOperation;
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

    public void searchBook(String title) {
        bookOperations.searchBook(title);
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

    public void searchMember(String name) {
        memberOperations.searchMember(name);
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

    public void searchLoan(String id) {
        loanOperations.searchLoan(id);
    }

    public void search(String table, String searchField, String searchString) {
        searchOperation.search(table, searchField, searchString);
    }

    public void listHistory() {
        historyOperation.listHistory();
    }

}
