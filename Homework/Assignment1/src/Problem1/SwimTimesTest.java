package Problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for class SwimTimes.
 *
 * Only non-negative numbers are tested for get methods in this class because we have not
 * yet covered testing with error handling.
 *
 * @author evandouglass
 */
public class SwimTimesTest {
    private SwimTimes timesMain;
    private SwimTimes timesDefault;

    @Before
    public void setUp() {
        timesMain = new SwimTimes(1.0, 2.1, 3.2, 4.3);
        timesDefault = new SwimTimes();
    }

    @Test
    public void getBest50mBackstrokeTime() {
        assertEquals(1.0, timesMain.getBest50mBackstrokeTime(), 0.0);
        assertEquals(-1.0, timesDefault.getBest50mBackstrokeTime(), 0.0);
    }

    @Test
    public void setBest50mBackstrokeTime() {
        timesDefault.setBest50mBackstrokeTime(55.555);
        assertEquals(55.555, timesDefault.getBest50mBackstrokeTime(), 0.0);
        timesDefault.setBest50mBackstrokeTime(0.0);
        assertEquals(0.0, timesDefault.getBest50mBackstrokeTime(), 0.0);
    }

    @Test
    public void getBest50mBreaststrokeTime() {
        assertEquals(2.1, timesMain.getBest50mBreaststrokeTime(), 0.0);
        assertEquals(-1.0, timesDefault.getBest50mBreaststrokeTime(), 0.0);
    }

    @Test
    public void setBest50mBreaststrokeTime() {
        timesDefault.setBest50mBreaststrokeTime(0.1234567);
        assertEquals(0.1234567, timesDefault.getBest50mBreaststrokeTime(), 0.0);
        timesDefault.setBest50mBreaststrokeTime(0.0);
        assertEquals(0.0, timesDefault.getBest50mBreaststrokeTime(), 0.0);
    }

    @Test
    public void getBest50mButterflyTime() {
        assertEquals(3.2, timesMain.getBest50mButterflyTime(), 0.0);
        assertEquals(-1.0, timesDefault.getBest50mButterflyTime(), 0.0);
    }

    @Test
    public void setBest50mButterflyTime() {
        timesDefault.setBest50mButterflyTime(1234.5678);
        assertEquals(1234.5678, timesDefault.getBest50mButterflyTime(), 0.0);
        timesDefault.setBest50mButterflyTime(0.0);
        assertEquals(0.0, timesDefault.getBest50mButterflyTime(), 0.0);
    }

    @Test
    public void getBest50mFreestyleTime() {
        assertEquals(4.3, timesMain.getBest50mFreestyleTime(), 0.0);
        assertEquals(-1.0, timesDefault.getBest50mFreestyleTime(), 0.0);
    }

    @Test
    public void setBest50mFreestyleTime() {
        timesDefault.setBest50mButterflyTime(44.567);
        assertEquals(44.567, timesDefault.getBest50mButterflyTime(), 0.0);
        timesDefault.setBest50mButterflyTime(0.0);
        assertEquals(0.0, timesDefault.getBest50mButterflyTime(), 0.0);
    }
}