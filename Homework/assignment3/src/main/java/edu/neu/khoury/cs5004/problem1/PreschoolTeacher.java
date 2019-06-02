package edu.neu.khoury.cs5004.problem1;

import java.util.Objects;

/**
 * A Preschool teacher is responsible for older children, those who are starting to read. A
 * Preschool teacher is a full time employee.
 *
 * @author evandouglass
 */
public class PreschoolTeacher extends AbstractFullTimeTeacher {

  private static final Integer childrenPerTeacher = 10;

  private Integer currNumCanRead;


  /**
   * Constructor for PreschoolTeacher.
   *
   * @param name this teacher's name
   * @param classroom this teacher's classroom, as a string
   * @param coTeacher this teacher's co-teacher
   * @param vacationStatus whether this teacher is on vacation (true) or not (false)
   * @param currNumChildren the current number of children assigned to this teacher's classroom
   * @param maxChildren the maximum number of allowed children in this teacher's classroom
   * @param numCanRead the number of children in this class that can read
   */
  public PreschoolTeacher(Name name, String classroom, Name coTeacher, boolean vacationStatus,
      Integer currNumChildren, Integer maxChildren, Integer numCanRead) {
    super(name, classroom, coTeacher, vacationStatus, currNumChildren, maxChildren);
    this.currNumCanRead = numCanRead;
  }

  /* ===== Overrides ===== */
  // Docs in interface

  @Override
  public String toString() {
    return "PreschoolTeacher: " + super.toString()
        + String.format("childrenCanRead=%d", currNumCanRead);
  }

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
    PreschoolTeacher that = (PreschoolTeacher) o;
    return currNumCanRead.equals(that.currNumCanRead);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), currNumCanRead);
  }

  /* ===== Getters & Setters ===== */

  /**
   * Sets a new co-teacher. Also sets the max children in the class depending on if the co-teacher
   * is empty (Name("", "")) or not.
   *
   * @param teacher the {@code Name} of the co-teacher
   */
  @Override
  public void setCoTeacher(Name teacher) {
    if (teacher.equals(new Name("", ""))) {
      setMaxChildren(childrenPerTeacher);
    } else {
      setMaxChildren(childrenPerTeacher * 2);
    }

    super.setCoTeacher(teacher);
  }

  /**
   * Gets the number of children who can read.
   *
   * @return the current number of children who can read in this class
   */
  public Integer getCurrNumCanRead() {
    return currNumCanRead;
  }

  /**
   * Sets the number of children who can read in this class. Cannot be over the number of children
   * in the class or under zero.
   *
   * @param currNumCanRead the new number of children who can read
   */
  public void setCurrNumCanRead(Integer currNumCanRead) {
    validateSetter(currNumCanRead);
    this.currNumCanRead = currNumCanRead;
  }

  /**
   * Validates the number of children who can read against the total number of children in the
   * classroom.
   *
   * @param num the number to test
   * @throws IllegalArgumentException if the number is outside the range
   */
  private void validateSetter(Integer num) throws IllegalArgumentException {
    if (num < 0) {
      throw new IllegalArgumentException("number cannot be negative");
    }
    if (num > getCurrNumChildren()) {
      throw new IllegalArgumentException(
          "number of children who can read is above the number of students in the class");
    }
  }
}
