package AdaptiveLibraryManagementSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * The DBLoanManagerTest class contains unit tests for the DBLoanManager class,
 * using Mockito to mock the behavior of DBLoanManager methods and verify that
 * they are called as expected.
 */
class LoanServicandDAOTest {

    // Mock object for DBLoanManager to simulate its behavior in tests
    @Mock
    LoanService loanService;
    @Mock
    DBLoanDAO dbLoanDAO;

    /**
     * Initializes the mock objects before each test runs.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initializes Mockito annotations
    }

    /**
     * Test the borrowBook method to ensure it is called with the correct parameters.
     */
    @Test
    void testBorrowBook() {
        Loan loan = new Loan(123,456);

        // Set up the mock to do nothing when borrowBook is called
        doNothing().when(loanService).borrowBook(loan);

        // Call the method being tested
        loanService.borrowBook(loan);

        // Verify that borrowBook was called exactly once with the correct parameters
        verify(loanService, times(1)).borrowBook(loan);
    }

    /**
     * Test the returnBook method to ensure it is called with the correct parameters.
     */
    @Test
    void testReturnBook() {
        int memberId = 123;
        int bookId = 456;

        // Set up the mock to do nothing when returnBook is called
        doNothing().when(loanService).returnBook(memberId, bookId);

        // Call the method being tested
        loanService.returnBook(memberId, bookId);

        // Verify that returnBook was called exactly once with the correct parameters
        verify(loanService, times(1)).returnBook(memberId, bookId);
    }

    /**
     * Test the listLoans method to ensure it is called.
     */
    @Test
    void testListLoans() {
        // Set up the mock to do nothing when listLoans is called
        doNothing().when(loanService).listLoans();

        // Call the method being tested
        loanService.listLoans();

        // Verify that listLoans was called exactly once
        verify(loanService, times(1)).listLoans();
    }

    /**
     * Test the isBookAvailable method to ensure it returns the correct value
     * and is called with the correct parameters.
     */
    @Test
    void testIsBookAvailable() throws SQLException {
        int bookId = 456;

        // Set up the mock to return true when isBookAvailable is called
        when(dbLoanDAO.isBookAvailable(bookId)).thenReturn(true);

        // Call the method being tested and capture the result
        boolean result = dbLoanDAO.isBookAvailable(bookId);

        // Assert that the result is true
        assertTrue(result);

        // Verify that isBookAvailable was called exactly once with the correct parameter
        verify(dbLoanDAO, times(1)).isBookAvailable(bookId);
    }

    /**
     * Test the setBookAvailability method to ensure it is called with the correct parameters.
     */
    @Test
    void testSetBookAvailability() throws SQLException{
        int availability = 1;
        int bookId = 456;

        // Set up the mock to do nothing when setBookAvailability is called
        doNothing().when(dbLoanDAO).setBookAvailability(availability, bookId);

        // Call the method being tested
        dbLoanDAO.setBookAvailability(availability, bookId);

        // Verify that setBookAvailability was called exactly once with the correct parameters
        verify(dbLoanDAO, times(1)).setBookAvailability(availability, bookId);
    }

    /**
     * Test the addLoan method to ensure it is called with the correct parameters.
     */
    @Test
    void testAddLoan() throws SQLException {
        int memberId = 123;
        int bookId = 456;
        Loan loan = new Loan(memberId, bookId);

        // Set up the mock to do nothing when addLoan is called
        doNothing().when(dbLoanDAO).addLoan(loan);

        // Call the method being tested
        dbLoanDAO.addLoan(loan);

        // Verify that addLoan was called exactly once with the correct parameters
        verify(dbLoanDAO, times(1)).addLoan(loan);
    }

    /**
     * Test the removeLoan method to ensure it is called with the correct parameters.
     */
    @Test
    void testRemoveLoan() throws SQLException {
        int memberId = 123;
        int bookId = 456;

        // Set up the mock to do nothing when removeLoan is called
        doNothing().when(dbLoanDAO).removeLoan(bookId, memberId);

        // Call the method being tested
        dbLoanDAO.removeLoan(bookId, memberId);

        // Verify that removeLoan was called exactly once with the correct parameters
        verify(dbLoanDAO, times(1)).removeLoan(bookId, memberId);
    }
}
