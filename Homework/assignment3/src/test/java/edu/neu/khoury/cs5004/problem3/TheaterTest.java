package edu.neu.khoury.cs5004.problem3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class TheaterTest {

  private Theater t;

  @Before
  public void setUp() throws Exception {
    t = new Theater("one", 5, 6);
  }

  @Test
  public void reserveSeat() {
    // good tests
    t.reserveSeat(3, 'C', "Evan");
    Seat seat = t.getRows().get(2).get(2);
    assertTrue(seat.isReserved());

    t.reserveSeat(3, 'c', "Evan");
    seat = t.getRows().get(2).get(2);
    assertTrue(seat.isReserved());
  }

  @Test
  public void reserveSeatBad() {
    try {
      t.reserveSeat(3, '-', "Evan");
      fail("seat given is not a letter");
    } catch (IndexOutOfBoundsException e) {
      // Passed
    }

    try {
      t.reserveSeat(3, '0', "Evan");
      fail("seat given is not a letter");
    } catch (IndexOutOfBoundsException e) {
      // Passed
    }

    try {
      t.reserveSeat(3, '0', "");
      fail("cant reserve a seat for no one");
    } catch (IllegalArgumentException e) {
      // Passed
    }

    try {
      t.reserveSeat(8, '0', "Evan");
      fail("row given is not in the theater");
    } catch (IndexOutOfBoundsException e) {
      // Passed
    }
  }

  @Test
  public void toString1() {
    String result = "======\n"
        + "ABCDEF : Row 1\n"
        + "ABCDEF : Row 2\n"
        + "ABCDEF : Row 3\n"
        + "ABCDEF : Row 4\n"
        + "ABCDEF : Row 5\n";
    assertEquals(result, t.toString());

    t.reserveSeat(3, 'C', "Evan");
    result = "======\n"
        + "ABCDEF : Row 1\n"
        + "ABCDEF : Row 2\n"
        + "AB-DEF : Row 3\n"
        + "ABCDEF : Row 4\n"
        + "ABCDEF : Row 5\n";
    assertEquals(result, t.toString());
  }

  @Test
  public void equals1() {
    assertEquals(t, t);
    assertNotEquals(null, t);
    assertNotEquals("Hello", t);

    Theater t1 = new Theater("one", 5, 6);
    assertEquals(t1, t);
    t1 = new Theater("two", 5, 6);
    assertNotEquals(t1, t);
    t1 = new Theater("one", 3, 6);
    assertNotEquals(t1, t);
    t1 = new Theater("one", 5, 9);
    assertNotEquals(t1, t);
    t1 = new Theater("two", 9, 2);
    assertNotEquals(t1, t);
  }

  @Test
  public void hashCode1() {
    Theater t1 = new Theater("one", 5, 6);
    assertEquals(t1.hashCode(), t.hashCode());

    t1 = new Theater("two", 5, 6);
    assertNotEquals(t1.hashCode(), t.hashCode());
  }

  @Test
  public void getName() {
    assertEquals("one", t.getName());
  }

  @Test
  public void getRows() {
    ArrayList<Row> rows1 = t.getRows();

    for (int i = 0; i < 5; i++) {
      Row row = rows1.get(i);
      assertEquals(new Row(6, i + 1), row);
    }
  }

  @Test
  public void getNumRows() {
    assertEquals(5, (int) t.getNumRows());
  }

  @Test
  public void getSeatsPerRow() {
    assertEquals(6, (int) t.getSeatsPerRow());
  }
}