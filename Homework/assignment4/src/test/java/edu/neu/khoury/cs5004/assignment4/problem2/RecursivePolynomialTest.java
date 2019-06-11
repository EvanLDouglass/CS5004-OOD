package edu.neu.khoury.cs5004.assignment4.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecursivePolynomialTest {

  private IPolynomial poly;

  @Before
  public void setUp() throws Exception {
    poly = new RecursivePolynomial();
    poly = poly.addTerm(-4, 3);
    poly = poly.addTerm(2, 2);
    poly = poly.addTerm(-3, 1);
    poly = poly.addTerm(5, 0);
  }

  @Test
  public void addTerm() {

  }

  @Test
  public void removeTerm() {
  }

  @Test
  public void getDegree() {
    assertEquals(3, (int) poly.getDegree());
    poly = poly.addTerm(3, 9);
    assertEquals(9, (int) poly.getDegree());
  }

  @Test
  public void getCoefficient() {
    assertEquals(-4, (int) poly.getCoefficient(3));
    assertEquals(2, (int) poly.getCoefficient(2));
    assertEquals(-3, (int) poly.getCoefficient(1));
    assertEquals(5, (int) poly.getCoefficient(0));
    assertEquals(0, (int) poly.getCoefficient(15));
  }

  @Test
  public void isSame() {
  }

  @Test
  public void evaluate() {
  }

  @Test
  public void add() {
  }

  @Test
  public void multiply() {
  }

  @Test
  public void toString1() {
    String expected = "-4x^3 + 2x^2 - 3x + 5";
    assertEquals(expected, poly.toString());
  }
}