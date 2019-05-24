package edu.neu.khoury.cs5004.game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AgeTest {

  private Age age;

  @Before
  public void setUp() throws Exception {
    age = new Age(28);
  }

  @Test
  public void getAge() {
    assertEquals(28, (int) age.getAge());
  }

  @Test(expected = IncorrectAgeRangeException.class)
  public void negativeAge() throws IncorrectAgeRangeException {
    age = new Age(-1);
  }

  @Test(expected = IncorrectAgeRangeException.class)
  public void ageOverMax() throws IncorrectAgeRangeException {
    age = new Age(129);
  }

  @Test
  public void toString1() {
    assertEquals("Age{28}", age.toString());
  }

  @Test
  public void equals1() throws IncorrectAgeRangeException {
    assertEquals(new Age(28), age);
  }
}