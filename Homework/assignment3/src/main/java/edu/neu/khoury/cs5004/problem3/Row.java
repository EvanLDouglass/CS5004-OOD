package edu.neu.khoury.cs5004.problem3;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a row of seats in a movie theater.
 *
 * @author evandouglass
 */
public class Row extends ArrayList<Seat> {

  private static final Integer MAX_SEATS = 26;
  private static final Integer MIN_SEATS = 1;
  private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  private Integer rowNum;
  private Boolean isAccessible;

  /**
   * Constructor for a row of seats.
   *
   * @param initialCapacity the number of seats in a row
   * @param rowNum the row number, (1 is closest to the screen, increasing numbers are further)
   */
  public Row(int initialCapacity, Integer rowNum, Boolean isAccessible) {
    super(initialCapacity);
    validateSeatsInRow(initialCapacity);
    validateRowNum(rowNum);

    this.rowNum = rowNum;
    this.isAccessible = isAccessible;
    // Create a list of unreserved seats
    for (int i = 0; i < initialCapacity; i++) {
      String name = String.valueOf(ALPHABET.charAt(i));
      super.add(new Seat(name));
    }
  }

  /* ===== Methods ===== */

  /**
   * Gets the index of a seat name in a row. This test is not case-sensitive (a == A).
   *
   * @param name the name of the seat (A-Z)
   * @return the index of the seat, or -1 if not found
   */
  public Integer getIndexOfSeat(Character name) {
    for (int i = 0; i < this.size(); i++) {
      if (ALPHABET.charAt(i) == Character.toUpperCase(name)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Ensures the number of seats is between 1 and 26.
   *
   * @param numSeats the number of seats to test
   * @throws IllegalArgumentException if the number is below 1 or above 26
   */
  private void validateSeatsInRow(Integer numSeats) throws IllegalArgumentException {
    if (numSeats < MIN_SEATS || numSeats > MAX_SEATS) {
      throw new IllegalArgumentException("number of seats is outside acceptable range, got length "
          + numSeats);
    }
  }

  /**
   * Ensures the row number is at least 1.
   *
   * @param rowNum the row number to test
   * @throws IllegalArgumentException if the row number is less than 1
   */
  private void validateRowNum(Integer rowNum) throws IllegalArgumentException {
    if (rowNum < 1) {
      throw new IllegalArgumentException("row number must be at least 1");
    }
  }

  /* ===== Overrides ===== */

  /**
   * Generates a string representation of this row. Reserved seats are represented by a '-', open
   * seats are represented by their name.
   *
   * @return a string representation of this row
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < this.size(); i++) {
      Seat s = this.get(i);
      if (s.isReserved()) {
        builder.append('-');
      } else {
        builder.append(s.getName());
      }
    }
    builder.append(" : Row ");
    builder.append(rowNum);
    if (isAccessible) {
      builder.append("♿");  // UTF-8 code: U+267F
    }

    return builder.toString();
  }

  /**
   * Tests equality between this row and another object.
   *
   * @param o the object to test
   * @return true if equal, else false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Row seats = (Row) o;
    return rowNum.equals(seats.rowNum)
        && isAccessible.equals(seats.isAccessible);
  }

  /**
   * Generates a hash code for this object.
   *
   * @return a hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), rowNum, isAccessible);
  }

  /* ===== Getters ===== */

  /**
   * Gets the number of this row.
   *
   * @return the number of this row
   */
  public Integer getRowNum() {
    return rowNum;
  }

  /**
   * Determines if this row is wheelchair accessible.
   *
   * @return true if accessible, else false
   */
  public Boolean isAccessible() {
    return isAccessible;
  }
}
