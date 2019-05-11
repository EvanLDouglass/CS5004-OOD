package Problem1;

import static org.junit.Assert.*;

public class SwimmerTest {
    private Swimmer swimmer1;
    private Swimmer swimmer2;

    @org.junit.Before
    public void setUp() {
        this.swimmer1 = new Swimmer("Jeff", "Rouse", 25.13);
        this.swimmer2 = new Swimmer("Evan", "Douglass");
    }

    @org.junit.Test
    public void getFirstName() {
        assertEquals("Jeff", swimmer1.getFirstName());
        assertEquals("Evan", swimmer2.getFirstName());
    }

    @org.junit.Test
    public void getLastName() {
        assertEquals("Rouse", swimmer1.getLastName());
        assertEquals("Douglass", swimmer2.getLastName());
    }

    @org.junit.Test
    public void getBestBackstroke50mTime() {
        assertEquals(25.13, swimmer1.getBestBackstroke50mTime(), 0.0);
        assertEquals(-1.0, swimmer2.getBestBackstroke50mTime(), 0.0);
    }

    @org.junit.Test
    public void setBestBackstroke50mTime() {
        swimmer1.setBestBackstroke50mTime(25.10);
        assertEquals(25.10, swimmer1.getBestBackstroke50mTime(), 0.0);
    }
}