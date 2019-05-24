package edu.neu.khoury.cs5004.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CivilianTest {

  private class ConcreteCivilian extends Civilian {

    public ConcreteCivilian(Name name, Age age, Double wealth) throws Exception {
      super(name, age, wealth);
    }
  }

  private ConcreteCivilian cc;

  @Before
  public void setUp() throws Exception {
    cc = new ConcreteCivilian(new Name("Evan", "Douglass"),
        new Age(28), 45.00);
  }

  @Test
  public void addToWealth() throws Exception {
    cc.addToWealth(20.0);
    assertEquals(new Wealth(65.0), cc.getWealth());

    try {
      cc.addToWealth(-100.0);
      fail("wealth reached a negative number");
    } catch (IncorrectWealthValueException e) {
      // test passed
    }
  }

  @Test
  public void decreaseWealth() throws Exception {
    cc.decreaseWealth(30.0);
    assertEquals(new Wealth(15.0), cc.getWealth());

    cc.decreaseWealth(-10.0);
    assertEquals(new Wealth(25.0), cc.getWealth());

    try {
      cc.decreaseWealth(100.0);
      fail("wealth reached a negative number");
    } catch (IncorrectWealthValueException e) {
      // test passed
    }
  }
}