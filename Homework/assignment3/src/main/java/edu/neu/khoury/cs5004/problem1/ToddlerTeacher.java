package edu.neu.khoury.cs5004.problem1;

import java.util.Objects;

/**
 * A ToddlerTeacher is a daycare worker who takes care of toddlers.
 *
 * @author evandouglass
 */
public class ToddlerTeacher extends AbstractFullTimeTeacher {

  private static final Integer childrenPerTeacher = 7;

  private Integer currNumInDiapers;
  private Integer currNumPottyTrained;

  /**
   * Constructor for Toddler Teacher.
   *
   * @param name this teacher's name
   * @param classroom this teacher's classroom, as a string
   * @param coTeacher this teacher's co-teacher
   * @param vacationStatus whether this teacher is on vacation (true) or not (false)
   * @param currNumChildren the current number of children assigned to this teacher's classroom
   * @param maxChildren the maximum number of allowed children in this teacher's classroom
   * @param currNumInDiapers the number of children in the class who are in diapers
   * @param currNumPottyTrained the number of children in the class who are potty trained
   */
  public ToddlerTeacher(Name name, String classroom, Name coTeacher, boolean vacationStatus,
      Integer currNumChildren, Integer maxChildren, Integer currNumInDiapers,
      Integer currNumPottyTrained) {
    super(name, classroom, coTeacher, vacationStatus, currNumChildren, maxChildren);
    this.currNumInDiapers = currNumInDiapers;
    this.currNumPottyTrained = currNumPottyTrained;
  }

  /* ===== Overrides ===== */
  // Docs in interface

  @Override
  public String toString() {
    return "ToddlerTeacher: " + super.toString()
        + String.format("childrenInDiapers=%d childrenPottyTrained=%d",
        currNumInDiapers, currNumPottyTrained);
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
    ToddlerTeacher that = (ToddlerTeacher) o;
    return currNumInDiapers.equals(that.currNumInDiapers)
        && currNumPottyTrained.equals(that.currNumPottyTrained);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), currNumInDiapers, currNumPottyTrained);
  }

  /* ===== Getters and Setters ===== */

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
   * Gets the number of children in diapers.
   *
   * @return the number of children in diapers
   */
  public Integer getCurrNumInDiapers() {
    return currNumInDiapers;
  }

  /**
   * Sets a new number of children in diapers.
   *
   * @param currNumInDiapers the new number of children in diapers
   */
  public void setCurrNumInDiapers(Integer currNumInDiapers) {
    this.currNumInDiapers = currNumInDiapers;
    validateSetter(currNumInDiapers);
  }

  /**
   * Gets the current number of children who are potty trained.
   *
   * @return the number of students who are potty trained
   */
  public Integer getCurrNumPottyTrained() {
    return currNumPottyTrained;
  }

  /**
   * Sets a new number of children who are potty trained.
   *
   * @param currNumPottyTrained the new number of children who are potty trained
   */
  public void setCurrNumPottyTrained(Integer currNumPottyTrained) {
    this.currNumPottyTrained = currNumPottyTrained;
    validateSetter(currNumPottyTrained);
  }

  /**
   * Validates the number of children in diapers and potty trained against the total number of
   * children in the classroom.
   *
   * @param num the number to test
   * @throws IllegalArgumentException if the number is outside the range
   */
  private void validateSetter(Integer num) throws IllegalArgumentException {
    if (num < 0) {
      throw new IllegalArgumentException("number cannot be negative");
    }
    if (currNumInDiapers + currNumPottyTrained > getCurrNumChildren()) {
      throw new IllegalArgumentException(
          "number of children in diapers and potty-trained is above the "
              + "number of students in the class");
    }
  }
}
