package edu.neu.khoury.cs5004.game;

import java.util.Objects;

/**
 * Stamina represents an attribute of a Soldier game piece.
 *
 * @author evandouglass
 */
public class Stamina {

  private Double stamina;

  /**
   * Constructor for Stamina. Must be in the range [0, 100].
   *
   * @param stamina the value of stamina
   */
  public Stamina(Double stamina) {
    validateStamina(stamina);
    this.stamina = stamina;
  }

  /**
   * Checks that stamina is in the range [0, 100].
   *
   * @param stamina stamina to check
   * @throws IllegalArgumentException if stamina is not in range
   */
  private void validateStamina(Double stamina) throws IllegalArgumentException {
    checkLowBound(stamina);
    checkHighBound(stamina);
  }

  /**
   * Checks the low bound of stamina.
   *
   * @param stamina stamina to check
   * @throws IllegalArgumentException when stamina is above 100
   */
  private void checkHighBound(Double stamina) throws IllegalArgumentException {
    if (stamina > 100.0) {
      throw new IllegalArgumentException("stamina is too high");
    }
  }

  /**
   * Checks the high bound of stamina.
   *
   * @param stamina stamina to check
   * @throws IllegalArgumentException when stamina is below 0
   */
  private void checkLowBound(Double stamina) throws IllegalArgumentException {
    if (stamina < 0) {
      throw new IllegalArgumentException("stamina is too low");
    }
  }

  /**
   * Makes a string.
   *
   * @return a string of this object
   */
  @Override
  public String toString() {
    return String.format("stamina=%.2f", stamina);
  }

  /**
   * Checks equality.
   *
   * @param o object to test
   * @return true or false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stamina stamina1 = (Stamina) o;
    return stamina.equals(stamina1.stamina);
  }

  /**
   * Makes a hash code.
   *
   * @return a hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(stamina);
  }

  /**
   * Getter for class.
   *
   * @return stamina
   */
  public Double getStamina() {
    return stamina;
  }
}
