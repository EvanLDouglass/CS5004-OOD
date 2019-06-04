package edu.neu.khoury.cs5004.problem3;

import java.util.Objects;

/**
 * Represents a seat in a movie theater. A {@code Seat} is a single seat in a single row and
 * represented by an uppercase letter and a name of the person for whom it is reserved. The name may
 * be null if the seat has not been reserved.
 *
 * @author evandouglass
 */
public class Seat {

  private String name;
  private String reservedFor;

  /**
   * Constructor for a reserved seat.
   *
   * @param name the name of the seat, a letter from A-Z
   * @param reservedFor the name of the person who reserved this seat
   */
  public Seat(String name, String reservedFor) {
    name = name.trim();
    validateName(name);
    this.name = name.toUpperCase();
    this.reservedFor = reservedFor;
  }

  /**
   * Constructor for an open seat.
   *
   * @param name the name of the seat, a letter from A-Z
   */
  public Seat(String name) {
    this(name, null);
  }

  /* ===== Methods ===== */

  /**
   * Determines if this seat is reserved or not.
   *
   * @return {@code true} if the seat is reserved, else {@code false}
   */
  public boolean isReserved() {
    if (reservedFor == null) {
      return false;
    }
    return true;
  }

  /**
   * Validates the given name to be a single alphabetic character.
   *
   * @param name the name to test
   * @throws IllegalArgumentException if the name is not one character or not alphabetic
   */
  private void validateName(String name) throws IllegalArgumentException {
    if (name.length() != 1) {
      throw new IllegalArgumentException("name must be a single character, got length: " + name.length());
    }
    if (!Character.isAlphabetic(name.charAt(0))) {
      throw new IllegalArgumentException("name is not alphabetic, got: " + name);
    }
  }

  /* ===== Object Overrides ===== */

  /**
   * Generates a string representation of this {@code Seat}.
   *
   * @return a string representation of this seat
   */
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder("Seat ");
    str.append(name);
    if (reservedFor != null) {
      str.append(" Reserved for ");
      str.append(reservedFor);
    }
    return str.toString();
  }

  /**
   * Tests equality of this seat with another object.
   *
   * @param o the object to test
   * @return {@code true} if equal, else {@code false}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Seat seat = (Seat) o;
    return name.equals(seat.name) &&
        Objects.equals(reservedFor, seat.reservedFor);
  }

  /**
   * Generates a hash code for this object.
   *
   * @return a hash code as an int
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, reservedFor);
  }

  /* ===== Getters & Setters ===== */

  /**
   * Gets this seat's name.
   *
   * @return the seat's name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the name of whoever has reserved this seat.
   *
   * @return the name of whoever has reserved this seat
   */
  public String getReservedFor() {
    return reservedFor;
  }

  /**
   * Sets the reserved for value for this seat.
   *
   * @param reservedFor the name of the person who reserved the seat
   */
  public void setReservedFor(String reservedFor) {
    this.reservedFor = reservedFor;
  }
}
