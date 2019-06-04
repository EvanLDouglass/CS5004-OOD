package edu.neu.khoury.cs5004.problem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a movie theater, with rows and seats.
 *
 * @author evandouglass
 */
public class Theater {

  private String name;
  private ArrayList<Row> rows;
  private Integer[] accessibleRows;
  private Integer numRows;
  private Integer seatsPerRow;

  /**
   * Constructor for a theater.
   *
   * @param name the name of the theater
   * @param numRows the number of rows in the theater
   * @param seatsPerRow the number of seats in each row
   * @param accessibleRows an array of integers representing row numbers that are wheelchair
   *     accessible.
   */
  public Theater(String name, Integer numRows, Integer seatsPerRow,
      Integer[] accessibleRows) {
    this.name = name;
    this.numRows = numRows;
    this.seatsPerRow = seatsPerRow;
    this.accessibleRows = accessibleRows;
    validateAccessibleRows();
    populateRows();
  }

  /* ===== Methods ===== */

  /**
   * Reserves the seat at {@code row, seat} for the person with the given name.
   *
   * @param row the row number (1-indexed)
   * @param seat the seat name (A-Z)
   * @param name the name of the person who reserved this seat
   * @throws IndexOutOfBoundsException if the row number is not in the theater or the seat name is
   *     not in the theater
   * @throws IllegalArgumentException if the name of the person reserving the seat is an empty
   *     string
   */
  public void reserveSeat(Integer row, Character seat, String name)
      throws IndexOutOfBoundsException, IllegalArgumentException {
    if (name.equals("")) {
      throw new IllegalArgumentException("cannot reserve a seat for nobody");
    }

    Row r = rows.get(row - 1);
    Integer index = r.getIndexOfSeat(seat);
    Seat s = r.get(index);
    s.setReservedFor(name);
  }

  /**
   * Populates the rows field using the numRows and seatsPerRow fields.
   */
  private void populateRows() {
    rows = new ArrayList<Row>(numRows);
    for (int i = 1; i <= numRows; i++) {
      if (isRowAccessible(i)) {
        rows.add(new Row(seatsPerRow, i, true));
      } else {
        rows.add(new Row(seatsPerRow, i, false));
      }
    }
  }

  /**
   * Checks if a given row number is designated as an accessible row.
   *
   * @param row the row number to check
   * @return true if the row is accessible, else false
   */
  private boolean isRowAccessible(Integer row) {
    for (int i = 0; i < accessibleRows.length; i++) {
      if (row == accessibleRows[i]) {
        return true;
      }
    }
    return false;
  }

  /**
   * Ensures that the accessibleRows array has at least one row that is inside this theater.
   *
   * @throws IllegalArgumentException if the array is empty or all given row numbers are greater
   *     than the number of rows in the theater
   */
  private void validateAccessibleRows() throws IllegalArgumentException {
    if (accessibleRows == null || accessibleRows.length == 0) {
      throw new IllegalArgumentException("must be at least one accessible row");
    }

    for (Integer row : accessibleRows) {
      if (row <= numRows) {
        // If there is at least one row inside the theater that is accessible
        // then there is no problem.
        return;
      }
    }
    // If all row numbers are too big for the theater, there is a problem.
    throw new IllegalArgumentException("the given rows are too big for this theater");
  }

  /* ===== Object Overrides ===== */

  /**
   * Generates a string representation of this theater.
   *
   * @return a string representation of this theater
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    // Show screen at front
    for (int i = 0; i < seatsPerRow; i++) {
      builder.append('=');
    }
    builder.append('\n');

    // Show each row
    for (int i = 0; i < numRows; i++) {
      builder.append(rows.get(i).toString());
      builder.append('\n');
    }

    return builder.toString();
  }

  /**
   * Test the equality of this object with another.
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
    Theater theater = (Theater) o;
    return Objects.equals(name, theater.name)
        && Objects.equals(rows, theater.rows)
        && Objects.equals(numRows, theater.numRows)
        && Objects.equals(seatsPerRow, theater.seatsPerRow)
        && Arrays.equals(accessibleRows, theater.accessibleRows);
  }

  /**
   * Generates a hash code from this object.
   *
   * @return a hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, rows, numRows, seatsPerRow, Arrays.hashCode(accessibleRows));
  }

  /* ===== Getters ===== */

  /**
   * Gets the theater's name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the list of rows in this theater.
   *
   * @return the list of rows
   */
  public ArrayList<Row> getRows() {
    return rows;
  }

  /**
   * Gets the number of rows in this theater.
   *
   * @return the number of rows
   */
  public Integer getNumRows() {
    return numRows;
  }

  /**
   * Gets the number of seats in each row.
   *
   * @return the number of seats per row
   */
  public Integer getSeatsPerRow() {
    return seatsPerRow;
  }

  /**
   * Gets the array of accessible rows.
   *
   * @return the array of accessible rows
   */
  public Integer[] getAccessibleRows() {
    return accessibleRows;
  }
}
