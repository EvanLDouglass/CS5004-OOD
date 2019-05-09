import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private Person p;

    @Before
    public void setUp() {
        p = new Person("Evan", "Douglass");
    }

    @Test
    public void getFirst() {
        assertEquals("Evan", p.getFirst());
    }

    @Test
    public void getLast() {
        assertEquals("Douglass", p.getLast());
    }
}