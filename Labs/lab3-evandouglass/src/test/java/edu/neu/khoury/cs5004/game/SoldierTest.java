package edu.neu.khoury.cs5004.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SoldierTest {

  private class ConcreteSoldier extends Soldier {

    public ConcreteSoldier(Name name, Age age, Double stamina) {
      super(name, age, stamina);
    }
  }

  private ConcreteSoldier cs;

  @Before
  public void setUp() throws Exception {
    cs = new ConcreteSoldier(
        new Name("Evan", "Douglass"),
        new Age(28),
        50.0
    );
  }

  @Test
  public void addToStamina() {
    cs.addToStamina(25.0);
    assertEquals(new Stamina(75.0), cs.getStamina());

    try {
      cs.addToStamina(25.1);
      fail("stamina made it above 100");
    } catch (IllegalArgumentException e) {
      // test passed
    }
  }

  @Test
  public void decreaseStamina() {
    cs.decreaseStamina(25.0);
    assertEquals(new Stamina(25.0), cs.getStamina());

    try {
      cs.decreaseStamina(25.1);
      fail("stamina made it below 0");
    } catch (IllegalArgumentException e) {
      // test passed
    }
  }
}