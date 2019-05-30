package edu.neu.khoury.sc5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AgeTest {
  private Age age;

  @Before
  public void setUp() throws Exception {
    age = new Age(28);
  }

  @Test
  public void badInits() {
    try {
      age = new Age(-1);
      fail("Age allowed to be negative");
    } catch (IllegalArgumentException e) {
      // test passed
    }

    try {
      age = new Age(129);
      fail("Age greater than 128");
    } catch (IllegalArgumentException e) {
      // test passed
    }

    try {
      age = new Age(0);
    } catch (IllegalArgumentException e) {
      fail("Age not allowed to be 0");
    }

    try {
      age = new Age(128);
    } catch (IllegalArgumentException e) {
      fail("Age not allowed to be 128");
    }
  }

  @Test
  public void toString1() {
    assertEquals("Age: 28", age.toString());
  }

  @Test
  public void equals1() {
    Age a2 = new Age(28);
    assertEquals(age, a2);

    a2 = new Age(0);
    assertNotEquals(age, a2);
  }

  @Test
  public void getAge() {
    assertEquals(28, (int)age.getAge());
  }
}