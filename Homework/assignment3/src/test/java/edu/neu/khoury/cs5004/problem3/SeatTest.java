package edu.neu.khoury.cs5004.problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeatTest {

  private Seat reserved;
  private Seat open;

  @Before
  public void setUp() throws Exception {
    reserved = new Seat("A", "Evan");
    open = new Seat("B");
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyName() {
    open = new Seat("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void longName() {
    open = new Seat("AB");
  }

  @Test
  public void nonAlphaForName() {
    try {
      open = new Seat("4");
      fail("number for name");
    } catch (IllegalArgumentException e) {
      // Passed test
    }

    try {
      open = new Seat("-");
      fail("symbol for name");
    } catch (IllegalArgumentException e) {
      // Passed test
    }

    try {
      open = new Seat(" ");
      fail("space for name");
    } catch (IllegalArgumentException e) {
      // Passed test
    }
  }

  @Test
  public void testWhiteSpaceInName() {
    try {
      open = new Seat(" Z ");
    } catch (Exception e) {
      fail("whitespace wasn't trimmed");
    }
  }

  @Test
  public void testLowerCaseConversion() {
    try {
      open = new Seat("c");
    } catch (Exception e) {
      fail("name wasn't converted to upper case");
    }
  }

  @Test
  public void isReserved() {
    assertTrue(reserved.isReserved());
    assertFalse(open.isReserved());
  }

  @Test
  public void toString1() {
    assertEquals("Seat A Reserved for Evan", reserved.toString());
    assertEquals("Seat B", open.toString());
  }

  @Test
  public void equals1() {
    assertEquals(open, open);
    assertEquals(reserved, reserved);
    assertEquals(new Seat("B"), open);
    assertEquals(new Seat("A", "Evan"), reserved);

    assertNotEquals(open, reserved);
    assertNotEquals("B", open);
    assertNotEquals(new Seat("B", "Evan"), reserved);
  }

  @Test
  public void hashCode1() {
    assertEquals(new Seat("A", "Evan").hashCode(), reserved.hashCode());
    assertNotEquals(open.hashCode(), reserved.hashCode());
  }

  @Test
  public void getName() {
    assertEquals("A", reserved.getName());
    assertEquals("B", open.getName());
  }

  @Test
  public void getAndSetReservedFor() {
    assertEquals("Evan", reserved.getReservedFor());
    assertNull(open.getReservedFor());

    open.setReservedFor("Evan");
    assertEquals("Evan", open.getReservedFor());

    reserved.setReservedFor(null);
    assertNull(reserved.getReservedFor());
  }
}