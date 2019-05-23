package edu.neu.khoury.cs5004.lab3.shapes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PosnTest {

  private Posn p;

  @Before
  public void setUp() {
    p = new Posn(3.0, 4.0);
  }

  @Test
  public void distToOrigin() {
    assertEquals(5.0, p.distToOrigin(), 0.0001);
  }

  @Test
  public void getX() {
    assertEquals(3.0, p.getX(), 0);
  }

  @Test
  public void getY() {
    assertEquals(4.0, p.getY(), 0);
  }
}