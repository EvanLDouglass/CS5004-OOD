package Problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BicyclistTest {
    private Bicyclist b;
    private Time start;
    private Time end;

    @Before
    public void setUp() {
        start = new Time();  // zeroed
        end = new Time(15, 25, 35);
        b = new Bicyclist("Evan", "Douglass", start, end);
    }

    @Test
    public void getDuration() {
        Time duration = b.getDuration();
        assertEquals(end, duration);

        b.setStartTime(new Time(10, 5, 45));
        assertEquals(new Time(10, 5, 45), b.getStartTime());
        duration = b.getDuration();  // 15:25:35 - 10:05:45
        assertEquals(new Time(5, 19, 50), duration);

        b.setEndTime(new Time(10, 40, 59));
        assertEquals(new Time(10, 40, 59), b.getEndTime());
        duration = b.getDuration();  // 10:40:59 - 10:05:45
        assertEquals(new Time(0, 35, 14), duration);
    }

    @Test(expected = IllegalArgumentException.class)
    public void endIsAlwaysLargerThanStart() {
        Bicyclist test = new Bicyclist("Test", "McTesterson");
        test.setStartTime(new Time(23, 0, 0));
        test.setEndTime(new Time());
    }

    @Test(expected = IllegalArgumentException.class)
    public void startIsAlwaysSmallerThanEnd() {
        Bicyclist test = new Bicyclist("Test", "McTesterson Jr.");
        test.setEndTime(new Time());
        test.setStartTime(new Time(23, 0, 0));
    }

    @Test
    public void getFirstName() {
        assertEquals("Evan", b.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Douglass", b.getLastName());
    }
}