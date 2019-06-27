package edu.neu.khoury.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptySetTest {

  private Set<Double> dbls;

  @Before
  public void setUp() throws Exception {
    dbls = new EmptySet<>();
  }

  @Test
  public void isEmpty() {
    assertTrue(dbls.isEmpty());
  }

  @Test
  public void add() {
    dbls = dbls.add(4.123);
    assertFalse(dbls.isEmpty());
    assertEquals(1, (int) dbls.size());
    assertTrue(dbls.contains(4.123));
  }

  @Test
  public void contains() {
    assertFalse(dbls.contains(4.5));
  }

  @Test
  public void remove() {
    dbls = dbls.remove(3.902);
    assertTrue(dbls.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(0, (int) dbls.size());
  }
}