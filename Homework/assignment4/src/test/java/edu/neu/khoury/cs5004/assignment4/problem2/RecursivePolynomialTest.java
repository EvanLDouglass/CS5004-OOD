package edu.neu.khoury.cs5004.assignment4.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    assertTrue(poly3.isSame(expected));
    poly3 = poly2.add(poly);
    assertTrue(poly3.isSame(expected));
  }

  @Test
  public void add_OneEmpty() {
    IPolynomial poly2 = new RecursivePolynomial();
    IPolynomial expected = new RecursivePolynomial(-4, 3,
        new RecursivePolynomial(2, 2,
            new RecursivePolynomial(-3, 1,
                new RecursivePolynomial(5, 0,
                    new RecursivePolynomial()
                )
            )
        )
    );
    IPolynomial poly3 = poly.add(poly2);
    assertTrue(poly3.isSame(expected));
    poly3 = poly2.add(poly);
    assertTrue(poly3.isSame(expected));
  }

  @Test
  public void add_DiffPowers() {
    IPolynomial poly2 = new RecursivePolynomial(-4, 10,
        new RecursivePolynomial(2, 9,
            new RecursivePolynomial(-3, 8,
                new RecursivePolynomial(5, 7,
                    new RecursivePolynomial()
                )
            )
        )
    );
    IPolynomial expected = new RecursivePolynomial(-4, 3,
        new RecursivePolynomial(2, 2,
            new RecursivePolynomial(-3, 1,
                new RecursivePolynomial(5, 0,
                    new RecursivePolynomial(-4, 10,
                        new RecursivePolynomial(2, 9,
                            new RecursivePolynomial(-3, 8,
                                new RecursivePolynomial(5, 7,
                                    new RecursivePolynomial()
                                )
                            )
                        )
                    )
                )
            )
        )
    );
    IPolynomial poly3 = poly.add(poly2);
    assertTrue(poly3.isSame(expected));
    poly3 = poly2.add(poly);
    assertTrue(poly3.isSame(expected));
  }

  @Test
  public void add_SomeSameSomeDiff() {
    IPolynomial poly2 = new RecursivePolynomial(-4, 3,
        new RecursivePolynomial(2, 9,
            new RecursivePolynomial(-3, 1,
                new RecursivePolynomial(5, 7,
                    new RecursivePolynomial()
                )
            )
        )
    );
    IPolynomial expected = new RecursivePolynomial(-8, 3,
        new RecursivePolynomial(2, 2,
            new RecursivePolynomial(-6, 1,
                new RecursivePolynomial(5, 0,
                    new RecursivePolynomial(2, 9,
                        new RecursivePolynomial(5, 7,
                            new RecursivePolynomial()
                        )
                    )
                )
            )
        )
    );
    IPolynomial poly3 = poly.add(poly2);
    assertTrue(poly3.isSame(expected));
    poly3 = poly2.add(poly);
    assertTrue(poly3.isSame(expected));
  }

  @Test
  public void add_MakeAZeroCoeff() {
    IPolynomial poly2 = new RecursivePolynomial(-4, 3,
        new RecursivePolynomial(2, 9,
            new RecursivePolynomial(3, 1,
                new RecursivePolynomial(5, 7,
                    new RecursivePolynomial()
                )
            )
        )
    );
    IPolynomial expected = new RecursivePolynomial(-8, 3,
        new RecursivePolynomial(2, 2,
            new RecursivePolynomial(5, 0,
                new RecursivePolynomial(2, 9,
                    new RecursivePolynomial(5, 7,
                        new RecursivePolynomial()
                    )
                )
            )
        )
    );
    IPolynomial poly3 = poly.add(poly2);
    assertTrue(poly3.isSame(expected));
    poly3 = poly2.add(poly);
    assertTrue(poly3.isSame(expected));
  }

  @Test
  public void multiply() {
    poly = new RecursivePolynomial(2, 2,
        new RecursivePolynomial(2, 0,
            new RecursivePolynomial()
        )
    );
    IPolynomial poly2 = new RecursivePolynomial(1, 3,
        new RecursivePolynomial(-3, 1,
            new RecursivePolynomial()
        )
    );
    IPolynomial result = new RecursivePolynomial(2, 5,
        new RecursivePolynomial(-4, 3,
            new RecursivePolynomial(-6, 1,
                new RecursivePolynomial()
            )
        )
    );
    assertTrue(result.isSame(poly.multiply(poly2)));
  }

  @Test
  public void multiply1() {
    poly = new RecursivePolynomial(1, 1,
        new RecursivePolynomial(5, 0,
            new RecursivePolynomial()
        )
    );
    IPolynomial poly2 = new RecursivePolynomial(1, 1,
        new RecursivePolynomial(-3, 0,
            new RecursivePolynomial()
        )
    );
    IPolynomial result = new RecursivePolynomial(1, 2,
        new RecursivePolynomial(2, 1,
            new RecursivePolynomial(-15, 0,
                new RecursivePolynomial()
            )
        )
    );
    assertTrue(result.isSame(poly2.multiply(poly)));
  }

  @Test
  public void multiply2() {
    poly = new RecursivePolynomial(1, 1,
        new RecursivePolynomial(5, 0,
            new RecursivePolynomial(4, 7,
                new RecursivePolynomial()
            )
        )
    );
    IPolynomial poly2 = new RecursivePolynomial(1, 1,
        new RecursivePolynomial(-3, 0,
            new RecursivePolynomial()
        )
    );
    IPolynomial result = new RecursivePolynomial(4, 8,
        new RecursivePolynomial(-12, 7,
            new RecursivePolynomial(1, 2,
                new RecursivePolynomial(2, 1,
                    new RecursivePolynomial(-15, 0,
                        new RecursivePolynomial()
                    )
                )
            )
        )
    );
    assertTrue(result.isSame(poly.multiply(poly2)));
  }

  @Test
  public void multiplyWithEmpty() {
    IPolynomial empty = new RecursivePolynomial();
    assertTrue(empty.isSame(poly.multiply(empty)));
    assertTrue(empty.isSame(empty.multiply(poly)));
  }

  @Test
  public void toString1() {
    poly = poly.addTerm(1, 4);
    poly = poly.addTerm(-1, 5);
    String expected = "-x^5 + x^4 - 4x^3 + 2x^2 - 3x + 5";
    assertEquals(expected, poly.toString());
  }

  @Test
  public void toStringPositiveStarts() {
    poly = new RecursivePolynomial(4, 3,
        new RecursivePolynomial(2, 9,
            new RecursivePolynomial(-3, 1,
                new RecursivePolynomial(5, 7,
                    new RecursivePolynomial()
                )
            )
        )
    );
    String expected = "2x^9 + 5x^7 + 4x^3 - 3x";
    assertEquals(expected, poly.toString());
  }

  @Test
  public void toStringEmptyPoly() {
    poly = new RecursivePolynomial();
    assertEquals("", poly.toString());
  }

  @Test
  public void toStringMoreOnes() {
    poly = new RecursivePolynomial(-1, 3,
        new RecursivePolynomial(1, 9,
            new RecursivePolynomial(1, 1,
                new RecursivePolynomial(-1, 0,
                    new RecursivePolynomial()
                )
            )
        )
    );
    String expected = "x^9 - x^3 + x - 1";
    assertEquals(expected, poly.toString());
  }

  @Test
  public void toStringSlightlyMoreOnes() {
    poly = new RecursivePolynomial(1, 3,
        new RecursivePolynomial(-1, 9,
            new RecursivePolynomial(-1, 1,
                new RecursivePolynomial(1, 0,
                    new RecursivePolynomial()
                )
            )
        )
    );
    String expected = "-x^9 + x^3 - x + 1";
    assertEquals(expected, poly.toString());
  }
}