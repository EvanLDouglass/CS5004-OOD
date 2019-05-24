package edu.neu.khoury.cs5004.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {

  private Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Evan", "Douglass");
  }

  @Test
  public void getFirst() {
    assertEquals("Evan", name.getFirst());
  }

  @Test
  public void getLast() {
    assertEquals("Douglass", name.getLast());
  }

  @Test
  public void toString1() {
    assertEquals("Evan Douglass", name.toString());
  }

  @Test
  public void equals1() {
    assertEquals(new Name("Evan", "Douglass"), name);
  }
}