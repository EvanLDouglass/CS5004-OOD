package edu.neu.khoury.cs5004.game;

import java.util.Objects;

/**
 * A simple immutable name class containing a first and last name.
 *
 * @author evandouglass
 */
public class Name {

  private String first;
  private String last;

  /**
   * Constructor for a <pre>Name</pre>.
   *
   * @param first first name
   * @param last last name
   */
  public Name(String first, String last) {
    this.first = first;
    this.last = last;
  }

  /**
   * Makes a string representation of this object
   *
   * @return <pre>Name</pre> as a String
   */
  @Override
  public String toString() {
    return first + " " + last;
  }

  /**
   * Tests equality.
   *
   * @param o another object
   * @return <pre>true</pre> if objects are equal, else <pre>false</pre>
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
    return first.equals(name.first) &&
        last.equals(name.last);
  }

  /**
   * Getter for first name.
   *
   * @return first name as a String
   */
  public String getFirst() {
    return first;
  }


  /**
   * Getter for last name.
   *
   * @return last name as a String
   */
  public String getLast() {
    return last;
  }
}
