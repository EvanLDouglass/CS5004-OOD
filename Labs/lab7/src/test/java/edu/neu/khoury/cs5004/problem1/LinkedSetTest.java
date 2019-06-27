package edu.neu.khoury.cs5004.problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LinkedSetTest {

  private Set<Integer> ints;
  private Set<String> strs;

  @Before
  public void setUp() throws Exception {
    ints = Set.emptySet();
    strs = Set.emptySet();
  }

  @Test
  public void isEmpty() {
    ints = ints.add(1);
    strs = strs.add("test");
    assertFalse(ints.isEmpty());
    assertFalse(strs.isEmpty());
  }

  @Test
  public void addAndContainsInts() {
    ints = ints.add(1);
    ints = ints.add(90);
    ints = ints.add(30);
    assertTrue(ints.contains(1));
    assertTrue(ints.contains(90));
    assertTrue(ints.contains(30));

  }

  @Test
  public void addAndContainsStrs() {
    strs = strs.add("hello");
    strs = strs.add("test");
    strs = strs.add("another");
    assertTrue(strs.contains("hello"));
    assertTrue(strs.contains("test"));
    assertTrue(strs.contains("another"));

  }

  @Test
  public void removeFromMiddleStrs() {
    strs = strs.add("Hello");
    strs = strs.add("50");
    strs = strs.add(" ");
    assertTrue(strs.contains("50"));
    strs = strs.remove("50");
    assertFalse(strs.contains("50"));
  }

  @Test
  public void removeFromMiddleInts() {
    ints = ints.add(1);
    ints = ints.add(50);
    ints = ints.add(90);
    assertTrue(ints.contains(50));
    ints = ints.remove(50);
    assertFalse(ints.contains(50));
  }

  @Test
  public void removeFirst() {
    ints = ints.add(1);
    ints = ints.add(50);
    ints = ints.add(90);
    assertTrue(ints.contains(1));
    ints = ints.remove(1);
    assertFalse(ints.contains(1));
  }

  @Test
  public void removeLast() {
    ints = ints.add(1);
    ints = ints.add(50);
    ints = ints.add(90);
    assertTrue(ints.contains(90));
    ints = ints.remove(90);
    assertFalse(ints.contains(90));
  }

  @Test
  public void removeFromLengthOne() {
    ints = ints.add(90);
    assertTrue(ints.contains(90));
    ints = ints.remove(90);
    assertFalse(ints.contains(90));
    assertTrue(ints.isEmpty());
  }

  @Test
  public void size() {
    ints = ints.add(30);
    assertEquals(1, (int) ints.size());
    // Add same element
    ints = ints.add(30);
    assertEquals(1, (int) ints.size());
    ints = ints.add(30);
    assertEquals(1, (int) ints.size());
    // Add new elements
    ints = ints.add(40);
    assertEquals(2, (int) ints.size());
    ints = ints.add(-20);
    assertEquals(3, (int) ints.size());
  }
}