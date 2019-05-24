package edu.neu.khoury.cs5004.game;

import static org.junit.Assert.assertEquals;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class WealthTest {

  private Wealth w;

  @Before
  public void setUp() throws Exception {
    w = new Wealth(30.0);
  }

  @Test(expected = IncorrectWealthValueException.class)
  public void badWealthAmount() throws Exception {
    w = new Wealth(-0.1);
  }

  @Test
  public void toString1() {
    assertEquals("$30.00", w.toString());
  }

  @Test
  public void equals1() throws Exception {
    assertEquals(new Wealth(30.0), w);
  }

  @Test
  public void hashCode1() {
    int hash = Objects.hash(new Double(30.0));
    assertEquals(hash, w.hashCode());
  }

  @Test
  public void getGold() {
    assertEquals(30.0, w.getWealth(), 0.0);
  }
}