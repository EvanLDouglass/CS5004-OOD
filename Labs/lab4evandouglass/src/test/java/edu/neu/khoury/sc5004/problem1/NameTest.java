package edu.neu.khoury.sc5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  private Name name;

  @Before
  public void setUp() {
    name = new Name("Evan", "Douglass");
  }

  @Test
  public void testGetters() {
    assertEquals("Evan", name.getFirst());
    assertEquals("Douglass", name.getLast());
  }

  @Test
  public void testEquals() {
    Name n2 = new Name("Evan", "Douglass");
    assertEquals(name, n2);

    n2 = new Name("", "");
    assertNotEquals(name, n2);
  }

  @Test
  public void testToString() {
    assertEquals("Evan Douglass", name.toString());
  }
}