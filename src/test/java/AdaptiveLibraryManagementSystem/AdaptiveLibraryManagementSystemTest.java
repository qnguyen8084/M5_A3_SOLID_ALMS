package AdaptiveLibraryManagementSystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// These are the unit test for the AdaptiveLibraryManagementSystem
// It tests the printMessage message by comparing output to expected output.
// It testes DBManager class object instantiation by checking if object exists after instantiation call.
// It testes InteractiveConsole() class object instantiation by checking if object exists after
// instantiation call.

public class AdaptiveLibraryManagementSystemTest {

    // This is used to redirect output stream from console to ByteArray.
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private final PrintStream originalOutStream = System.out;

    // Redirects System.out from console to ByteArrayOutputStream before the start of each test.
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    // Restores System.out from ByteArrayOutputStream to original stream after each test.
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOutStream);
    }


    // Tests printMessage()
    @Test
    public void testPrint_Message() {
        String MESSAGE = "Welcome to Adaptive Library Management System!";
        AdaptiveLibraryManagementSystem.printMessage(MESSAGE);
        assertEquals(MESSAGE, outStream.toString().replaceAll("[\\n\\r]", ""));
    }

    // Test DBManager class object instantiation
    @Test
    public void testDBManager_Initialization_Expects_NotNull() {
        DBManager dbManager = new DBManager();
        assertNotNull(dbManager);
    }

    // Test InteractiveConsole class object instantiation
    @Test
    public void testInteractiveConsole_Initialization_Expects_NotNull() {
        int TEST = 1;
        InteractiveConsole interactiveConsole = new InteractiveConsole(TEST);
        assertNotNull(interactiveConsole);
    }

}