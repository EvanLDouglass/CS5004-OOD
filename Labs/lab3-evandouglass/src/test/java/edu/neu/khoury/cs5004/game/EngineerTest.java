package edu.neu.khoury.cs5004.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class EngineerTest {

  @Test
  public void toString1() throws Exception {
    Engineer e = new Engineer(
        new Name("Evan", "Douglass"),
        new Age(28),
        1000000.0
    );

    String exp = "Engineer{Evan Douglass, Age{28}, $1000000.00}";
    assertEquals(exp, e.toString());
  }
}