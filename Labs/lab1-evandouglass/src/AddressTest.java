import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
    private Address a;

    @Before
    public void setUp() throws Exception {
        a = new Address(
                "12345",
                "67th St. NW",
                "Seattle",
                "WA",
                98117,
                "USA"
        );
    }

    @Test
    public void getStreetNum() {
        assertEquals("12345", a.getStreetNum());
    }

    @Test
    public void getStreetName() {
        assertEquals("67th St. NW", a.getStreetName());
    }

    @Test
    public void getCity() {
        assertEquals("Seattle", a.getCity());
    }

    @Test
    public void getState() {
        assertEquals("WA", a.getState());
    }

    @Test
    public void getCountry() {
        assertEquals("USA", a.getCountry());
    }

    @Test
    public void getZip() {
        assertEquals(98117, a.getZip());
    }
}