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
    poly = poly.addTerm(6, 7);
    assertEquals(6, (int) poly.getCoefficient(7));
    assertEquals(0, (int) poly.getCoefficient(8));
    assertEquals(0, (int) poly.getCoefficient(6));
  }

  @Test
  public void addZero() {
    poly = poly.addTerm(0, 6);
    assertEquals(0, (int) poly.getCoefficient(6));
  }

  @Test
  public void addToExisting() {
    assertEquals(-4, (int) poly.getCoefficient(3));
    poly = poly.addTerm(10, 3);
    // should replace the old term
    assertEquals(10, (int) poly.getCoefficient(3));
  }

  @Test
  public void removeTerm() {
    assertEquals(-4, (int) poly.getCoefficient(3));
    poly = poly.removeTerm(3);
    assertEquals(0, (int) poly.getCoefficient(3));
    assertEquals(2, (int) poly.getDegree());
  }

  @Test
  public void removeTermNotInPoly() {
    poly = poly.removeTerm(10);
    assertEquals(3, (int) poly.getDegree());
    assertEquals(0, (int) poly.getCoefficient(10));
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
    IPolynomial poly2 = new RecursivePolynomial(-4, 3,
        new RecursivePolynomial(2, 2,
            new RecursivePolynomial(-3, 1,
                new RecursivePolynomial(5, 0,
                    new RecursivePolynomial()
                )
            )
        )
    );
    assertTrue(poly.isSame(poly2));
    poly = poly.removeTerm(2);
    assertFalse(poly.isSame(poly2));
  }

  @Test
  public void evaluate() {
    Double result = poly.evaluate(2.0);
    assertEquals(-25.0, result, 0.0);
  }

  @Test
  public void add_SamePowers() {
    IPolynomial poly2 = new RecursivePolynomial(-4, 3,
        new RecursivePolynomial(2, 2,
            new RecursivePolynomial(-3, 1,
                new RecursivePolynomial(5, 0,
                    new RecursivePolynomial()
                )
            )
        )
    );
    IPolynomial expected = new RecursivePolynomial(-8, 3,
        new RecursivePolynomial(4, 2,
            new RecursivePolynomial(-6, 1,
                new RecursivePolynomial(10, 0,
                    new RecursivePolynomial()
                )
            )
        )
    );
    IPolynomial poly3 = poly.add(poly2);
    assertEquals(-8, (int) poly3.getCoefficient(3));
    assertEquals(4, (int) poly3.getCoefficient(2));
    assertEquals(-6, (int) poly3.getCoefficient(1));
    assertEquals(10, (int) poly3.getCoefficient(0));
    assertEquals(0, (int) poly3.getCoefficient(15));
  }

  // TODO: Test Add with diff len polys and mixed power polys

  @Test
  public void multiply() {
  }

  @Test
  public void toString1() {
    String expected = "-4x^3 + 2x^2 - 3x + 5";
    assertEquals(expected, poly.toString());
  }
}