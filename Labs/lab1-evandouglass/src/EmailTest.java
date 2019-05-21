import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTest {

    private Email e;
    @Before
    public void setUp() {
        e = new Email("hello", "gmail.com");
    }

    @Test
    public void getLogin() {
        assertEquals("hello", e.getLogin());
    }

    @Test
    public void getDomain() {
        assertEquals("gmail.com", e.getDomain());
    }
}