package edu.neu.khoury.cs5004.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarineTest {

  @Test
  public void toString1() throws IncorrectAgeRangeException {
    Marine s = new Marine (
        new Name("Evan", "Douglass"),
        new Age(28),
        45.0
    );

    String exp = "Marine{Evan Douglass, Age{28}, stamina=45.00}";
    assertEquals(exp, s.toString());
  }
}