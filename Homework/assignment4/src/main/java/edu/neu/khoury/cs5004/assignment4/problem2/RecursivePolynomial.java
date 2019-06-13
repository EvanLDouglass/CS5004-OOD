package edu.neu.khoury.cs5004.assignment4.problem2;

public class RecursivePolynomial implements IPolynomial {

  private final Integer coefficient;
  private final Integer power;
  private final IPolynomial rest;

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

  /*
   * Next constructor is required in the assignment write up, making the use of an empty
   * polynomial class more difficult to make work. The write up also mentions only using "one"
   * implementation.
   */

  /**
   * Empty constructor for {@code RecursivePolynomial}. Creates a zero polynomial (i.e. just zero).
   */
  public RecursivePolynomial() {
    this.coefficient = null;
    this.power = null;
    this.rest = null;
  }

  /* ===== Methods ===== */

  @Override
  public IPolynomial addTerm(Integer coefficient, Integer power) {
    if (coefficient.equals(0)) {
      // ignore 0 valued
      return this;
    }
    // remove current term with this power if there is one
    IPolynomial rest = removeTerm(power);
    // replace the term with the new coefficient
    return new RecursivePolynomial(coefficient, power, rest);
  }

  @Override
  public IPolynomial removeTerm(Integer power) {
    if (isEmpty() || power == null) {
      return this;
    }
    if (this.power.equals(power)) {
      return rest.removeTerm(power);
    }
    return new RecursivePolynomial(this.coefficient, this.power, rest.removeTerm(power));
  }

  @Override
  public Integer getDegree() {
    if (isEmpty()) {
      return -1;
    }
    return Math.max(power, rest.getDegree());
  }

  @Override
  public Integer getCoefficient(Integer power) {
    if (isEmpty() || power == null) {
      return 0;
    }
    if (power.equals(this.power)) {
      return coefficient;
    }
    return rest.getCoefficient(power);
  }

  @Override
  public Boolean isSame(IPolynomial other) {
    if (other.getDegree() == -1) {
      if (isEmpty()) {
        // both are empty
        return true;
      }
      // this is not empty
      return false;
    }
    Integer otherCoef = other.getCoefficient(power);
    // remove this term from other so the polys shrink together
    other = other.removeTerm(power);
    return (otherCoef.equals(coefficient)) && rest.isSame(other);
  }

  @Override
  public Double evaluate(Double value) {
    if (isEmpty()) {
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
    if (isEmpty()) {
      return other;
    }
    // get new coefficient and remove that power from other so it doesn't end up in the final poly
    Integer newCoeff = coefficient + other.getCoefficient(power);
    other = other.removeTerm(power);
    // ignore zero values
    if (newCoeff.equals(0)) {
      return rest.add(other);
    }
    return new RecursivePolynomial(newCoeff, power, rest.add(other));
  }

  @Override
  public IPolynomial multiply(IPolynomial other) {
    if (isEmpty() || other == null) {
      // "zero" multiplication
      return new RecursivePolynomial();
    }
    Integer deg = other.getDegree();
    // For each possible power, add a new term to a polynomial
    IPolynomial poly = new RecursivePolynomial();
    for (int i = 0; i <= deg; i++) {
      // multiply coefficients in other with this one
      // add powers in other with this one
      // if other.getCoefficient returns 0 (that power is not in other),
      // the term is ignored in addTerm
      poly = poly.addTerm(coefficient * other.getCoefficient(i), power + i);
    }
    return poly.add(rest.multiply(other));
  }

  @Override
  public String toString() {
    String result = toStringHelper(this);
    // result will start with " - " or " + "
    if (result.startsWith(" - ")) {
      // remove spaces around minus sign on first term
      result = "-" + result.substring(3);
    } else if (result.startsWith(" + ")) {
      // remove spaces and plus sign on first term
      result = result.substring(3);
    }
    return result;
  }

  /**
   * Recursive helper for the toString method.
   *
   * @param poly a polynomial to turn into a string
   * @return a string representation of this object
   */
  private String toStringHelper(IPolynomial poly) {
    Integer degree = poly.getDegree();
    if (degree == -1) {
      return "";
    }
    // Get highest power term and remove it
    Integer coEff = poly.getCoefficient(degree);
    poly = poly.removeTerm(degree);

    // format the term
    String result;
    if (degree > 1) {
      result = formatPowerTwoOrMore(coEff, degree);
    } else if (degree == 1) {
      result = formatPowerIsOne(coEff);
    } else if (degree == 0) {
      result = formatPowerIsZero(coEff);
    } else {
      // unexpected, something is wrong!
      result = "???";
    }
    // return the term and the rest of poly (with this term removed)
    return result + toStringHelper(poly);
  }

  /**
   * Formats a term with a power greater than one.
   *
   * @param coEff the coefficient
   * @param power the power (must be two or more)
   * @return a string of the form "+/- ax^b", where a == coEff and b == power
   */
  private String formatPowerTwoOrMore(Integer coEff, Integer power) {
    String result;
    if (coEff < -1) {
      // the coefficient is negative
      result = String.format(" - %dx^%d", -coEff, power);
    } else if (coEff > 1) {
      // the coefficient is positive (no zero terms stored)
      result = String.format(" + %dx^%d", coEff, power);
    } else if (coEff == -1) {
      result = String.format(" - x^%d", power);
    } else {  // coEff == 1
      result = String.format(" + x^%d", power);
    }
    return result;
  }

  /**
   * Formats a term with a power equal to one.
   *
   * @param coEff the coefficient
   * @return a string of the form " +/- ax" where a == coEff
   */
  private String formatPowerIsOne(Integer coEff) {
    String result;
    if (coEff < -1) {
      result = " - " + (-coEff) + "x";
    } else if (coEff > 1) {
      result = " + " + coEff + "x";
    } else if (coEff == -1) {
      result = " - x";
    } else {
      result = " + x";
    }
    return result;
  }

  /**
   * Formats a term with a power equal to zero.
   *
   * @param coEff the coefficient
   * @return a string of the form " +/- a" where a == coEff
   */
  private String formatPowerIsZero(Integer coEff) {
    if (coEff < 0) {
      return " - " + (-coEff);
    } else {
      return " + " + coEff;
    }
  }

  /**
   * Checks if any field is null, indicating an empty list.
   *
   * @return true if any field is null, else false
   */
  private Boolean isEmpty() {
    return coefficient == null || power == null || rest == null;
  }
}
