package edu.neu.khoury.cs5004.assignment4.problem2;

public class RecursivePolynomial implements IPolynomial {

  private Integer coefficient;
  private Integer power;
  private IPolynomial rest;

  /**
   * Constructor for a {@code RecursivePolynomial}.
   *
   * @param coefficient a term coefficient
   * @param power a term power
   * @param rest the rest of the terms, as a polynomial
   */
  public RecursivePolynomial(Integer coefficient, Integer power,
      IPolynomial rest) {
    this.coefficient = coefficient;
    this.power = power;
    this.rest = rest;
  }

  /**
   * Empty constructor for {@code RecursivePolynomial}. Creates a zero polynomial (i.e. just zero).
   */
  public RecursivePolynomial() {
  }

  /* ===== Methods ===== */

  @Override
  public IPolynomial addTerm(Integer coefficient, Integer power) {
    if (coefficient.equals(0)) {
      return this;
    }
    return new RecursivePolynomial(coefficient, power, this);
  }

  @Override
  public IPolynomial removeTerm(Integer power) {
    if (this.power == null) {
      return this;
    }
    if (!this.power.equals(power)) {
      return new RecursivePolynomial(this.coefficient, this.power, rest.removeTerm(power));
    }
    return rest.removeTerm(power);
  }

  @Override
  public Integer getDegree() {
    if (coefficient == null || power == null || rest == null) {
      return -1;
    }
    return Math.max(power, rest.getDegree());
  }

  @Override
  public Integer getCoefficient(Integer power) {
    if (this.power == null || coefficient == null || rest == null) {
      return 0;
    }
    if (power.equals(this.power)) {
      return coefficient;
    }
    return rest.getCoefficient(power);
  }

  @Override
  public Boolean isSame(IPolynomial other) {
    if (other.getDegree() == -1 && getDegree() == -1) {
      return true;
    }
    if (other.getDegree() == -1 || getDegree() == -1) {
      return false;
    }
    Integer otherCoeff = other.getCoefficient(power);
    return (otherCoeff.equals(coefficient)) && rest.isSame(other);
  }

  @Override
  public Double evaluate(Double value) {
    if (coefficient == 0 && power == 0) {
      return 0.0;
    }
    Double termVal = (coefficient * Math.pow(value, power));
    return termVal + rest.evaluate(value);
  }

  @Override
  public IPolynomial add(IPolynomial other) {
    if (other.getDegree() == -1) {
      return this;
    }
    if (coefficient == null || power == null || rest == null) {
      return other;
    }
    Integer newCoeff = coefficient + other.getCoefficient(power);
    return new RecursivePolynomial(newCoeff, power, rest.add(other));
  }

  @Override
  public IPolynomial multiply(IPolynomial other) {
    if (coefficient == null) {
      return this;
    }
    Integer deg = other.getDegree();
    IPolynomial poly = new RecursivePolynomial();
    for (int i = 0; i <= deg; i++) {
      // if other.getCoefficient returns 0 (that power is not in other), the term is ignored
      poly = poly.addTerm(coefficient * other.getCoefficient(i),
          power + i);
    }
    return poly.add(rest.multiply(other));
  }

  @Override
  public String toString() {
    if (coefficient == null || power == null || rest == null) {
      return "";
    }

    String term;
    if (coefficient >= 0) {
      term = String.format(" + %d", coefficient);
    } else {
      term = String.format(" - %d", -coefficient);
    }
    if (power > 0) {
      term += String.format("x^%d", power);
    }

    return term + rest.toString();
  }
}
