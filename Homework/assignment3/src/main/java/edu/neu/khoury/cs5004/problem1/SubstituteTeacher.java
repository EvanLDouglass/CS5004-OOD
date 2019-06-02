package edu.neu.khoury.cs5004.problem1;

import java.util.Objects;

/**
 * A SubstituteTeacher is a part-time teacher who fills in for the full-time instructors.
 *
 * @author evandouglass
 */
public class SubstituteTeacher extends AbstractTeacher {

  private Integer numDaysInClass;

  /**
   * Constructor for this substitute teacher.
   *
   * @param name this teacher's name
   * @param classroom this teacher's classroom, as a string
   * @param coTeacher this teacher's co-teacher
   * @param vacationStatus whether this teacher is on vacation (true) or not (false)
   * @param numDaysInClass the number of days that this substitute has been working in this class
   */
  public SubstituteTeacher(Name name, String classroom, Name coTeacher, boolean vacationStatus,
      Integer numDaysInClass) {
    super(name, classroom, coTeacher, vacationStatus);
    this.numDaysInClass = numDaysInClass;
  }

  /* ===== Overrides ===== */

  /**
   * Creates a string representation of this substitute.
   *
   * @return a string representing this substitute
   */
  @Override
  public String toString() {
    return "SubstituteTeacher: " + super.toString()
        + String.format("daysInClass=%d", numDaysInClass);
  }

  /**
   * Determines equality between this object and another.
   *
   * @param o the other object to test
   * @return {@code true} if objects are equal, else {@code false}
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
    SubstituteTeacher that = (SubstituteTeacher) o;
    return numDaysInClass.equals(that.numDaysInClass);
  }

  /**
   * Generates a hash code from this object.
   *
   * @return a hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numDaysInClass);
  }

  /* ===== Getters & Setters ===== */

  /**
   * Gets the number of days that this sub has been in their current classroom.
   *
   * @return the number of days as an Integer
   */
  public Integer getNumDaysInClass() {
    return numDaysInClass;
  }

  /**
   * Sets the number of days that this sub has been in their current classroom. The value cannot be
   * less than zero.
   *
   * @param numDaysInClass the new number of days
   */
  public void setNumDaysInClass(Integer numDaysInClass) {
    validateSetter(numDaysInClass);
    this.numDaysInClass = numDaysInClass;
  }

  private void validateSetter(Integer num) throws IllegalArgumentException {
    if (num < 0) {
      throw new IllegalArgumentException("number cannot be negative");
    }
  }
}
