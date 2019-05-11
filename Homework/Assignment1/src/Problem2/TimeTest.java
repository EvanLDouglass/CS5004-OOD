package Problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
    private Time t1;
    private Time t2;

    @Before
    public void setUp() {
        t1 = new Time();
        t2 = new Time(1, 30, 59);
    }

    @Test
    public void TestBadSets() {
        Time test = new Time(0, 0, -1);
        // test should be 00:00:59
        assertEquals(59, test.getSec());  // second
        assertEquals(0, test.getMin());  // minute
        assertEquals(0, test.getHour()); // hour

        test = new Time(-1, -1, -1);
        // test should be 23:59:59
        assertEquals(59, test.getSec());  // second
        assertEquals(59, test.getMin());  // minute
        assertEquals(23, test.getHour()); // hour
    }

    @Test
    public void equals() {
        Time newTest = new Time();
        assertTrue(newTest.equals(t1));

        assertTrue(t2.equals(new Time(1, 30, 59)));
    }

    @Test
    public void getHour() {
        assertEquals(0, t1.getHour());
        assertEquals(1, t2.getHour());
    }

    @Test
    public void setHour() {
        t2.setHour(23);
        assertEquals(23, t2.getHour());
        t2.setHour(15);
        assertEquals(15, t2.getHour());

        t2.setHour(44);
        assertEquals(20, t2.getHour());
        t2.setHour(-30);
        assertEquals(18, t2.getHour());
    }

    @Test
    public void getMin() {
        assertEquals(0, t1.getMin());
        assertEquals(30, t2.getMin());
    }

    @Test
    public void setMin() {
        t2.setMin(59);
        assertEquals(59, t2.getMin());
        t2.setMin(0);
        assertEquals(0, t2.getMin());

        t2.setMin(77);
        assertEquals(17, t2.getMin());
        t2.setMin(-30);
        assertEquals(30, t2.getMin());
    }

    @Test
    public void getSec() {
        assertEquals(0, t1.getSec());
        assertEquals(59, t2.getSec());
    }

    @Test
    public void setSec() {
        t2.setSec(0);
        assertEquals(0, t2.getSec());
        t2.setSec(30);
        assertEquals(30, t2.getSec());

        t2.setSec(250);
        assertEquals(10, t2.getSec());
        t2.setSec(-999);
        assertEquals(21, t2.getSec());
    }
}