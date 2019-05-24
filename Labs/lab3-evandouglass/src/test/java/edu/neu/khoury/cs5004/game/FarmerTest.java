package edu.neu.khoury.cs5004.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class FarmerTest {

  @Test
  public void toString1() throws Exception {
    Farmer f = new Farmer(
        new Name("Evan", "Douglass"),
        new Age(28),
        100.34321
    );

    String exp = "Farmer{Evan Douglass, Age{28}, $100.34}";
    assertEquals(exp, f.toString());
  }
}