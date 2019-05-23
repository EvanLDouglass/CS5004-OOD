package edu.neu.khoury.cs5004.lab3.shapes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SquareTest {

  private Square s;

  @Before
  public void setUp() throws Exception {
    s = new Square(5.0, 5.0, 10.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeSide() {
    s = new Square(5.0, 5.0, -1.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void zeroSide() {
    s = new Square(5.0, 5.0, 0.0);
  }

  @Test
  public void resize() {
    s = s.resize(2.0);
    assertEquals(5.0, s.getX(), 0);
    assertEquals(5.0, s.getY(), 0);
    assertEquals(20.0, s.getSide(), 0);
  }

  @Test
  public void toString1() {
    String expected = "Square: LL corner (5.000,5.000) side 10.000";
    assertEquals(expected, s.toString());
  }
}