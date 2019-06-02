package edu.neu.khoury.cs5004.problem1;

import java.util.Objects;

/**
 * A basic class for a first and last name.
 *
 * @author evandouglass
 */
public class Name {

  private String first;
  private String last;

  /**
   * Constructor for Name.
   *
   * @param first a first name
   * @param last a last name
   */
  public Name(String first, String last) {
    this.first = first;
    this.last = last;
  }

  /**
   * Tests equality.
   *
   * @param o the object to compare
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
    Name name = (Name) o;
    return first.equals(name.first)
        && last.equals(name.last);
  }

  /**
   * Generates a hashcode.
   *
   * @return a hashcode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(first, last);
  }

  /**
   * Represents this object as a string.
   *
   * @return a string representation
   */
  @Override
  public String toString() {
    return first + " " + last;
  }

  /**
   * Getter for first name.
   *
   * @return first name
   */
  public String getFirst() {
    return first;
  }

  /**
   * Getter for last name.
   *
   * @return last name
   */
  public String getLast() {
    return last;
  }
}
