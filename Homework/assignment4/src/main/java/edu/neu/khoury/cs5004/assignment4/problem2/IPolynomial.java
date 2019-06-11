package edu.neu.khoury.cs5004.assignment4.problem2;

/**
 * Represents the functionality of a polynomial equation, including evaluation addition and
 * multiplication.
 *
 * @author evandouglass
 */
public interface IPolynomial {

  /**
   * Adds the term defined by the given coefficient and power to this polynomial.
   *
   * @param coefficient the coefficient of this term
   * @param power the power of this term
   */
  IPolynomial addTerm(Integer coefficient, Integer power);

  /**
   * Removes the term of the given power from this polynomial.
   *
   * @param power the power of the term to remove
   */
  IPolynomial removeTerm(Integer power);

  /**
   * Gets the degree of this polynomial (the largest power of any term).
   *
   * @return the power of this polynomial
   */
  Integer getDegree();

  /**
   * Gets the coefficient of the given power for this polynomial.
   *
   * @param power the power of the coefficient to return
   * @return the coefficient of the power, or zero if this polynomial does not contain the power
   */
  Integer getCoefficient(Integer power);

  /**
   * Determines if another polynomial is equivalent to this one.
   * Does not consider the ordering of the terms, as this does not matter
   * in mathematics.
   *
   * @param other the other polynomial to test
   * @return true if they are equivalent, else false
   */
  Boolean isSame(IPolynomial other);

  /**
   * Calculates the polynomial evaluated against the given value. In other words, substitutes the
   * given value for all the variables in the polynomial. For example, given a value of 2.0: 2x^2 ->
   * 2(2.0)^2 -> 8.0
   *
   * @param value the value at which to evaluate the polynomial
   * @return a value calculated from the polynomial and given value
   */
  Double evaluate(Double value);

  /**
   * Given another polynomial, adds it to this one.
   *
   * @param other the other polynomial
   * @return the resulting polynomial
   */
  IPolynomial add(IPolynomial other);

  /**
   * Given another polynomial, multiplies it with this one.
   *
   * @param other the other polynomial
   * @return the resulting polynomial
   */
  IPolynomial multiply(IPolynomial other);
}
