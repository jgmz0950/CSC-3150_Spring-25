package Class_01_30.DB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    IDBInterface dbInterface;
    BookService bookService;


    @BeforeEach
    void setUp() {
        dbInterface = new dbForTest();
        bookService = new BookService(dbInterface);
    }

    @Test
    void testBookService_fantasy_expected30() throws SQLException {
            int id = 1;
        // HashMap<String, String> result = dbInterface.selectByIdAsMap("Blah", id);
        int expectedFantasy = 30;
        assertEquals(expectedFantasy, bookService.getBookCheckOutDays(id));
    }

    @Test
    void testBookService_adventure_expected35() throws SQLException {
        int id = 2;
        int expectedAdventure = 35;
        assertEquals(expectedAdventure, bookService.getBookCheckOutDays(id));
    }
}