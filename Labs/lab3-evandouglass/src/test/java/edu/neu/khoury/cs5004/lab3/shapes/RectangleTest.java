package edu.neu.khoury.cs5004.lab3.shapes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {

  private Rectangle r;

  @Before
  public void setUp() throws Exception {
    r = new Rectangle(5.0, 5.0, 10.0, 5.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeWidth() {
    r = new Rectangle(3.0, 3.0, -4.0, 5.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeHeight() {
    r = new Rectangle(3.0, 3.0, 4.0, -5.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void zeroWidth() {
    r = new Rectangle(3.0, 3.0, 0.0, 5.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void zeroHeight() {
    r = new Rectangle(3.0, 3.0, 4.0, 0.0);
  }

  @Test
  public void area() {
    assertEquals(50.0, r.area(), 0);
  }

  @Test
  public void perimeter() {
    assertEquals(30.0, r.perimeter(), 0);
  }

  @Test
  public void resize() {
    r = r.resize(2.0);
    assertEquals(5.0, r.getX(), 0);
    assertEquals(5.0, r.getY(), 0);
    assertEquals(20.0, r.getWidth(), 0);
    assertEquals(10.0, r.getHeight(), 0);
  }

  @Test
  public void toString1() {
    String expected = "Rectangle: LL corner (5.000,5.000) width 10.000 height 5.000";
    assertEquals(expected, r.toString());
  }
}