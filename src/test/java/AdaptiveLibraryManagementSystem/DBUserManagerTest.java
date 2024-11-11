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
class DBUserManagerTest {
    DBHistoryLogger historyLogger = new DBHistoryLogger();
    DBUserManager dbUserManager = new DBUserManager(historyLogger);
    ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(outStream);
    PrintStream originalOutStream = System.out;
    Random rand = new Random();
    int randomNum = rand.nextInt((100 - 1) + 1) + 1;
    String memberName = STR."member\{randomNum}";


    @BeforeEach
    public void setUp() {
        System.setOut(ps);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOutStream);
    }

    @Test
    void addTest() {
        Member testMember = new Member(memberName);
        dbUserManager.add(testMember);
        dbUserManager.search(memberName);
        System.out.println(outStream.toString());
        MatcherAssert.assertThat(outStream.toString(), containsString(memberName));
    }

    @Test
    void removeTest() {
        String entryId = "";
        Member testMember = new Member(memberName);
        dbUserManager.add(testMember);
        dbUserManager.search(memberName);
        Pattern p = Pattern.compile("id:.(\\d+).");
        Matcher m = p.matcher(outStream.toString());
        if(m.find()) {
            entryId = m.group(1);
        }
        dbUserManager.remove(Integer.parseInt(entryId));
        dbUserManager.list();
        assertFalse(outStream.toString().contains(STR."id. \{m.group(1)}"));
        // additional assertions or verifications here
    }

    @Test
    void searchTest() {
        Member testMember = new Member(memberName);
        dbUserManager.add(testMember);
        dbUserManager.search(memberName);
        MatcherAssert.assertThat(outStream.toString(), containsString(memberName));
    }

    @Test
    void listTest() {
        Member testMember = new Member(memberName);
        dbUserManager.add(testMember);
        dbUserManager.list();
        MatcherAssert.assertThat(outStream.toString(), containsString(memberName));
    }
}