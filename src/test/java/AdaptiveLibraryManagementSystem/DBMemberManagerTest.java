package AdaptiveLibraryManagementSystem;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class DBMemberManagerTest {
    DBConnection dbConnection = new SQLiteConnection();
    DBHistoryLogger historyLogger = new DBHistoryLogger();
    DBMemberManager dbMemberManager = new DBMemberManager(historyLogger, dbConnection);
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
        dbMemberManager.add(testMember);
        dbMemberManager.search(memberName);
        System.out.println(outStream.toString());
        MatcherAssert.assertThat(outStream.toString(), containsString(memberName));
    }

    @Test
    void removeTest() {
        String entryId = "";
        Member testMember = new Member(memberName);
        dbMemberManager.add(testMember);
        dbMemberManager.search(memberName);
        Pattern p = Pattern.compile("id:.(\\d+).");
        Matcher m = p.matcher(outStream.toString());
        if(m.find()) {
            entryId = m.group(1);
        }
        dbMemberManager.remove(Integer.parseInt(entryId));
        dbMemberManager.list();
        assertFalse(outStream.toString().contains(STR."id. \{m.group(1)}"));
        // additional assertions or verifications here
    }

    @Test
    void searchTest() {
        Member testMember = new Member(memberName);
        dbMemberManager.add(testMember);
        dbMemberManager.search(memberName);
        MatcherAssert.assertThat(outStream.toString(), containsString(memberName));
    }

    @Test
    void listTest() {
        Member testMember = new Member(memberName);
        dbMemberManager.add(testMember);
        dbMemberManager.list();
        MatcherAssert.assertThat(outStream.toString(), containsString(memberName));
    }
}