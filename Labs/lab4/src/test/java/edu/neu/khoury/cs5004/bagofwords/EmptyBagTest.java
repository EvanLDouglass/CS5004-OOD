package edu.neu.khoury.cs5004.bagofwords;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyBagTest {

  private BagOfWords bag;

  @Before
  public void setUp() throws Exception {
    bag = BagOfWords.emptyBagOfWords();
  }

  @Test
  public void isEmpty() {
    assertTrue(bag.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(0, (int) bag.size());
  }

  @Test
  public void contains() {
    assertFalse(bag.contains("hello"));
    assertFalse(bag.contains(""));
    assertFalse(bag.contains("12345"));
  }

  @Test
  public void hashCode1() {
    assertEquals(1234, bag.hashCode());
  }

  @Test
  public void equals1() {
    assertEquals(bag, bag);
    assertNotEquals(bag, null);
    assertNotEquals(bag, "Hello");
    assertEquals(bag, new EmptyBag());
  }
}