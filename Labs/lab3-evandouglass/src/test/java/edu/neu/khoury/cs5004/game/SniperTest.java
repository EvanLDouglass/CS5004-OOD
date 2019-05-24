package edu.neu.khoury.cs5004.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class SniperTest {

  @Test
  public void toString1() throws IncorrectAgeRangeException {
    Sniper s = new Sniper(
        new Name("Evan", "Douglass"),
        new Age(28),
        45.0
    );

    String exp = "Sniper{Evan Douglass, Age{28}, stamina=45.00}";
    assertEquals(exp, s.toString());
  }
}