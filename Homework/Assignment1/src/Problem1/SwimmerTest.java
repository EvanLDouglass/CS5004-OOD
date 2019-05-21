package Problem1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for class Swimmer.
 * @author evandouglass
 */
public class SwimmerTest {
    private Swimmer swimmer1;
    private Swimmer swimmer2;
    private SwimTimes times;

    @Before
    public void setUp() {
        times = new SwimTimes(3.4, 4.5, 1.0, 333.333);
        this.swimmer1 = new Swimmer("Jeff", "Rouse", times);
        this.swimmer2 = new Swimmer("Evan", "Douglass");
    }

    @Test
    public void getFirstName() {
        assertEquals("Jeff", swimmer1.getFirstName());
        assertEquals("Evan", swimmer2.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Rouse", swimmer1.getLastName());
        assertEquals("Douglass", swimmer2.getLastName());
    }

    @Test
    public void getTimes() {
        assertEquals(times, swimmer1.getTimes());
    }

    @Test
    public void setTimes() {
        SwimTimes newTimes = new SwimTimes(1.0, 2.3, 4.5, 90.1);
        swimmer2.setTimes(newTimes);
        assertEquals(newTimes, swimmer2.getTimes());
        SwimTimes defaultTimes = new SwimTimes();
        swimmer2.setTimes(defaultTimes);
        assertEquals(defaultTimes, swimmer2.getTimes());
    }

    @Test
    public void getBest50mBackstrokeTime() {
        assertEquals(3.4, swimmer1.getBest50mBackstrokeTime(), 0.0);
        assertEquals(-1.0, swimmer2.getBest50mBackstrokeTime(), 0.0);
    }

    @Test
    public void setBest50mBackstrokeTime() {
        swimmer1.setBest50mBackstrokeTime(25.10);
        assertEquals(25.10, swimmer1.getBest50mBackstrokeTime(), 0.0);
    }

    @Test
    public void getBest50mBreaststrokeTime() {
        assertEquals(4.5, swimmer1.getBest50mBreaststrokeTime(), 0.0);
        assertEquals(-1.0, swimmer2.getBest50mBreaststrokeTime(), 0.0);
    }

    @Test
    public void setBest50mBreaststrokeTime() {
        swimmer1.setBest50mBreaststrokeTime(0.0);
        assertEquals(0.0, swimmer1.getBest50mBreaststrokeTime(), 0.0);
    }

    @Test
    public void getBest50mButterflyTime() {
        assertEquals(1.0, swimmer1.getBest50mButterflyTime(), 0.0);
        assertEquals(-1.0, swimmer2.getBest50mButterflyTime(), 0.0);
    }

    @Test
    public void setBest50mButterflyTime() {
        swimmer1.setBest50mButterflyTime(12.345);
        assertEquals(12.345, swimmer1.getBest50mButterflyTime(), 0.0);
    }

    @Test
    public void getBest50mFreestyleTime() {
        assertEquals(333.333, swimmer1.getBest50mFreestyleTime(), 0.0);
        assertEquals(-1.0, swimmer2.getBest50mFreestyleTime(), 0.0);
    }

    @Test
    public void setBest50mFreestyleTime() {
        swimmer1.setBest50mFreestyleTime(0.192837465);
        assertEquals(0.192837465, swimmer1.getBest50mFreestyleTime(), 0.0);
    }
}