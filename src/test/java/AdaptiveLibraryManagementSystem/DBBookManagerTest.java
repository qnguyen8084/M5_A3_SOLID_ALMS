package AdaptiveLibraryManagementSystem;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.SubstringMatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DBBookManagerTest {
    DBConnection dbConnection = new SQLiteConnection();
    DBHistoryLogger historyLogger = new DBHistoryLogger(new SQLiteHistoryConnection());
    DBBookManager dbBookManager = new DBBookManager(historyLogger, dbConnection);
    ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(outStream);
    PrintStream originalOutStream = System.out;
    Random rand = new Random();
    int randomNum = rand.nextInt((100 - 1) + 1) + 1;
    String bookTitle = STR."TestTitle\{randomNum}";

    // Redirects System.out from console to ByteArrayOutputStream before the start of each test.
    @BeforeEach
    public void setUp() {
        System.setOut(ps);
    }

    // Restores System.out from ByteArrayOutputStream to original stream after each test.
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOutStream);
    }

    @Test
    void addTest() {
        Book testBook = new Book(bookTitle, "Example Author");
        dbBookManager.add(testBook);
        dbBookManager.search(bookTitle);
        System.out.println(outStream.toString());
        MatcherAssert.assertThat(outStream.toString(), containsString(bookTitle));
    }

    @Test
    void removeTest() {
        String entryId = "";
        Book testBook = new Book(bookTitle, "Example Author");
        dbBookManager.add(testBook);
        dbBookManager.search(bookTitle);
        Pattern p = Pattern.compile("id:.(\\d+).");
        Matcher m = p.matcher(outStream.toString());
        if(m.find()) {
            entryId = m.group(1);
        }
        dbBookManager.remove(Integer.parseInt(entryId));
        dbBookManager.list();
        assertFalse(outStream.toString().contains(STR."id. \{m.group(1)}"));
        // additional assertions or verifications here
    }

    @Test
    void searchTest() {
        Book testBook = new Book(bookTitle, "Example Author");
        dbBookManager.add(testBook);
        dbBookManager.search(bookTitle);
        MatcherAssert.assertThat(outStream.toString(), containsString(bookTitle));
    }

    @Test
    void listTest() {
        Book testBook = new Book(bookTitle, "Example Author");
        dbBookManager.add(testBook);
        dbBookManager.list();
        MatcherAssert.assertThat(outStream.toString(), containsString(bookTitle));
    }
}