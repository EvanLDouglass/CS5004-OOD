package edu.neu.khoury.cs5004.problem1;

import java.util.Objects;

/**
 * An abstract class that defines some additional functionality for a full-time teacher. It also
 * implements FullTimeTeacher so that it's objects can use that type.
 *
 * @author evandouglass
 */
public abstract class AbstractFullTimeTeacher extends AbstractTeacher
    implements FullTimeTeacher {

  private Integer currNumChildren;
  private Integer maxChildren;

  /**
   * @param name this teacher's name
   * @param classroom this teacher's classroom, as a string
   * @param coTeacher this teacher's co-teacher
   * @param vacationStatus whether this teacher is on vacation (true) or not (false)
   * @param currNumChildren the current number of children assigned to this teacher's classroom
   * @param maxChildren the maximum number of allowed children in this teacher's classroom
   */
  public AbstractFullTimeTeacher(Name name, String classroom,
      Name coTeacher, boolean vacationStatus, Integer currNumChildren, Integer maxChildren) {
    super(name, classroom, coTeacher, vacationStatus);
    this.currNumChildren = currNumChildren;
    this.maxChildren = maxChildren;
  }

  /* ===== Overrides ===== */
  // Docs in interface

  @Override
  public String toString() {
    // Made to work nicely with sub-classes
    return super.toString()
        + String.format("numChildren=%d maxChildren=%d ", currNumChildren, maxChildren);
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
    AbstractFullTimeTeacher that = (AbstractFullTimeTeacher) o;
    return currNumChildren.equals(that.currNumChildren) &&
        maxChildren.equals(that.maxChildren);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), currNumChildren, maxChildren);
  }

  /* ===== Getters & Setters ===== */

  /**
   * Gets the current number of children in the class.
   *
   * @return number of children in the class
   */
  public Integer getCurrNumChildren() {
    return currNumChildren;
  }

  /**
   * Sets the current number of children in the class.
   *
   * @param number the new number of children
   * @throws IllegalArgumentException if number is out of range
   */
  public void setCurrNumChildren(Integer number) throws IllegalArgumentException {
    if (! isLessThanMax(number)) {
      throw new IllegalArgumentException("number greater than max");
    }
    if (number < 0) {
      throw new IllegalArgumentException("number must be positive");
    }
    this.currNumChildren = number;
  }

  /**
   * Determines if the given number is less than the max number of children allowed in the class.
   *
   * @param num the number to test
   * @return {@code true} if the number is less than the max, else {@code false}
   */
  private boolean isLessThanMax(Integer num) {
    if (num <= getMaxChildren()) {
      return true;
    }
    return false;
  }

  /**
   * Gets the max number of children in the class.
   *
   * @return the max number of children in the class
   */
  public Integer getMaxChildren() {
    return maxChildren;
  }

  /**
   * Sets the max number of children that can be in the classroom. This method is protected because
   * it only should be called when sub-classes change their co-teacher.
   *
   * @param number the new number to set to max
   */
  protected void setMaxChildren(Integer number) {
    this.maxChildren = number;
  }
}
