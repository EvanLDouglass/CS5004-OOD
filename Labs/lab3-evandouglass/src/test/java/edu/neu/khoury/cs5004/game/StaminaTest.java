package edu.neu.khoury.cs5004.game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StaminaTest {

  private Stamina s;

  @Before
  public void setUp() throws Exception {
    s = new Stamina(30.4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void tooLow() {
    s = new Stamina(-0.1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void tooHigh() {
    s = new Stamina(100.1);
  }

  @Test
  public void toString1() {
    String exp = "stamina=30.40";
    assertEquals(exp, s.toString());
  }

  @Test
  public void getStamina() {
    assertEquals(30.4, s.getStamina(), 0);
  }
}