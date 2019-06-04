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
    Integer[] accessible = new Integer[]{1, 5};
    t = new Theater("one", 5, 6, accessible);
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyAccessibleRows() {
    Integer[] accessible = new Integer[]{};
    t = new Theater("one", 5, 6, accessible);
  }

  @Test(expected = IllegalArgumentException.class)
  public void NoValidAccessibleRows() {
    Integer[] accessible = new Integer[]{7, 9, 10, 8};
    t = new Theater("one", 5, 6, accessible);
  }

  @Test
  public void oneValidAccessibleRow() {
    Integer[] accessible = new Integer[]{7, 9, 1, 8};
    t = new Theater("one", 5, 6, accessible);
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
        + "ABCDEF : Row 1♿\n"
        + "ABCDEF : Row 2\n"
        + "ABCDEF : Row 3\n"
        + "ABCDEF : Row 4\n"
        + "ABCDEF : Row 5♿\n";
    assertEquals(result, t.toString());

    t.reserveSeat(3, 'C', "Evan");
    result = "======\n"
        + "ABCDEF : Row 1♿\n"
        + "ABCDEF : Row 2\n"
        + "AB-DEF : Row 3\n"
        + "ABCDEF : Row 4\n"
        + "ABCDEF : Row 5♿\n";
    assertEquals(result, t.toString());
  }

  @Test
  public void equals1() {
    assertEquals(t, t);
    assertNotEquals(null, t);
    assertNotEquals("Hello", t);

    Integer[] accessible = new Integer[]{1, 5};
    Theater t1 = new Theater("one", 5, 6, accessible);
    assertEquals(t1, t);
    t1 = new Theater("two", 5, 6, accessible);
    assertNotEquals(t1, t);
    t1 = new Theater("one", 3, 6, accessible);
    assertNotEquals(t1, t);
    t1 = new Theater("one", 5, 9, accessible);
    assertNotEquals(t1, t);
    t1 = new Theater("two", 9, 2, accessible);
    assertNotEquals(t1, t);
    accessible[0] = 2;
    t1 = new Theater("one", 5, 6, accessible);
    assertNotEquals(t1, t);
  }

  @Test
  public void hashCode1() {
    Integer[] accessible = new Integer[]{1, 5};
    Theater t1 = new Theater("one", 5, 6, accessible);
    assertEquals(t1.hashCode(), t.hashCode());

    t1 = new Theater("two", 5, 6, accessible);
    assertNotEquals(t1.hashCode(), t.hashCode());
  }

  @Test
  public void getName() {
    assertEquals("one", t.getName());
  }

  @Test
  public void getRows() {
    ArrayList<Row> rows1 = t.getRows();
    Row row;

    row = rows1.get(0);
    assertEquals(new Row(6, 1, true), row);
    row = rows1.get(4);
    assertEquals(new Row(6, 5, true), row);

    for (int i = 1; i < 4; i++) {
      row = rows1.get(i);
      assertEquals(new Row(6, i + 1, false), row);
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