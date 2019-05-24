package edu.neu.khoury.cs5004.game;

import java.util.Objects;

/**
 * Wealth is a simple class that represents a Civilian's wealth.
 *
 * @author evandouglass
 */
public class Wealth {

  private Double wealth;

  /**
   * Constructor for <pre>Wealth</pre>. Note that wealth can be negative, representing a debt.
   *
   * @param wealth an amount of wealth in discrete amounts
   */
  public Wealth(Double wealth) throws IncorrectWealthValueException {
    validateWealth(wealth);
    this.wealth = wealth;
  }

  /**
   * Tests for a valid wealth amount.
   *
   * @param wealth the wealth amount to test
   * @throws IncorrectWealthValueException when wealth is negative
   */
  private void validateWealth(Double wealth) throws IncorrectWealthValueException {
    if (wealth < 0) {
      throw new IncorrectWealthValueException("wealth must be non-negative");
    }
  }

  /**
   * Generates a string representing this object.
   *
   * @return a string representation of this object
   */
  @Override
  public String toString() {
    return String.format("$%.2f", wealth);
  }

  /**
   * Tests equality.
   *
   * @param o another object
   * @return <pre>true</pre> if equal, else <pre>false</pre>
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Wealth wealth = (Wealth) o;
    return this.wealth.equals(wealth.wealth);
  }

  /**
   * Generates a hash code.
   *
   * @return a hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(wealth);
  }

  /**
   * Getter for wealth.
   *
   * @return an integer, wealth
   */
  public Double getWealth() {
    return wealth;
  }
}
