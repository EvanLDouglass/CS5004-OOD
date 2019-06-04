package edu.neu.khoury.cs5004.problem3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class RowTest {

  private Row rowMax;
  private Row rowMin;

  @Before
  public void setUp() throws Exception {
    rowMax = new Row(26, 1, true);
    rowMin = new Row(1, 30, false);
  }

  @Test
  public void badSetUp() {
    try {
      rowMax = new Row(27, 9, false);
      fail("number of seats in row is too big");
    } catch (IllegalArgumentException e) {
      // Passed
    }

    try {
      rowMax = new Row(0, 9, false);
      fail("number of seats in row is too small");
    } catch (IllegalArgumentException e) {
      // Passed
    }

    try {
      rowMax = new Row(15, 0, false);
      fail("row number is less than 1");
    } catch (IllegalArgumentException e) {
      // Passed
    }
  }

  @Test
  public void getIndexOfSeat() {
    Integer index = rowMax.getIndexOfSeat('Z');
    assertEquals(25, (int) index);

    index = rowMax.getIndexOfSeat('z');
    assertEquals(25, (int) index);

    index = rowMin.getIndexOfSeat('Z');
    assertEquals(-1, (int) index);

    index = rowMin.getIndexOfSeat('9');
    assertEquals(-1, (int) index);

  }

  @Test
  public void toString1() {
    String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ : Row 1♿";  // utf-8 wheelchair symbol included
    assertEquals(expected, rowMax.toString());

    expected = "A : Row 30";  // not wheelchair accessible
    assertEquals(expected, rowMin.toString());

    rowMin.get(0).setReservedFor("Evan");
    expected = "- : Row 30";
    assertEquals(expected, rowMin.toString());

    rowMax.get(2).setReservedFor("Evan");
    rowMax.get(3).setReservedFor("Rachel");
    rowMax.get(4).setReservedFor("Frankie");
    rowMax.get(25).setReservedFor("Bob");
    expected = "AB---FGHIJKLMNOPQRSTUVWXY- : Row 1♿";
    assertEquals(expected, rowMax.toString());
  }

  @Test
  public void equals1() {
    assertEquals(rowMax, rowMax);
    assertNotEquals(null, rowMax);
    assertNotEquals("A", rowMax);
    assertNotEquals(rowMax, rowMin);
  }

  @Test
  public void hashCode1() {
    assertNotEquals(rowMax.hashCode(), rowMin.hashCode());
    assertEquals(rowMin.hashCode(), new Row(1, 30, false).hashCode());
  }

  @Test
  public void getRowNum() {
    assertEquals(1, (int) rowMax.getRowNum());
    assertEquals(30, (int) rowMin.getRowNum());
  }

  @Test
  public void getAccessible() {
    assertTrue(rowMax.isAccessible());
    assertFalse(rowMin.isAccessible());
  }
}