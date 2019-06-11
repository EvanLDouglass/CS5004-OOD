package edu.neu.khoury.cs5004.assignment4.problem2;

/**
 * Represents an empty polynomial (i.e. 0) for the {@code RecursivePolynomial}
 * implementation.
 *
 * @author evandouglass
 */
public class EmptyPolynomial implements IPolynomial {

  @Override
  public IPolynomial addTerm(Integer coefficient, Integer power) {
    return new RecursivePolynomial(coefficient, power, this);
  }

  @Override
  public IPolynomial removeTerm(Integer power) {
    return this;
  }

  @Override
  public Integer getDegree() {
    return 0;
  }

  @Override
  public Integer getCoefficient(Integer power) {
    return 0;
  }

  @Override
  public Boolean isSame(IPolynomial other) {
    return null;
  }

  @Override
  public Double evaluate(Double value) {
    return 0.0;
  }

  @Override
  public IPolynomial add(IPolynomial other) {
    return other;
  }

  @Override
  public IPolynomial multiply(IPolynomial other) {
    return this;
  }

  @Override
  public String toString() {
    return "0";
  }
}
