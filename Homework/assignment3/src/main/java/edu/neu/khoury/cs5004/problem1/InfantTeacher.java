package edu.neu.khoury.cs5004.problem1;

import java.util.Objects;

public class InfantTeacher extends AbstractFullTimeTeacher {

  private static final Integer childrenPerTeacher = 4;

  private Integer currNumCrawlers;
  private Integer currNumWalkers;

  /**
   * Constructor for InfantTeacher.
   *
   * @param name this teacher's name
   * @param classroom this teacher's classroom, as a string
   * @param coTeacher this teacher's co-teacher
   * @param vacationStatus whether this teacher is on vacation (true) or not (false)
   * @param currNumChildren the current number of children assigned to this teacher's classroom
   * @param maxChildren the maximum number of allowed children in this teacher's classroom
   * @param numCrawlers the number of children who can crawl but not walk in this teacher's class
   * @param numWalkers the number of children who can walk in this teacher's class
   */
  public InfantTeacher(Name name, String classroom, Name coTeacher, boolean vacationStatus,
      Integer currNumChildren, Integer maxChildren, Integer numCrawlers, Integer numWalkers) {
    super(name, classroom, coTeacher, vacationStatus, currNumChildren, maxChildren);
    this.currNumCrawlers = numCrawlers;
    this.currNumWalkers = numWalkers;
  }

  /* ===== Overrides ===== */
  // Docs in interface

  @Override
  public String toString() {
    return "InfantTeacher: " + super.toString()
        + String.format("crawlers=%d walkers=%d", currNumCrawlers, currNumWalkers);
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
    InfantTeacher that = (InfantTeacher) o;
    return currNumCrawlers.equals(that.currNumCrawlers)
        && currNumWalkers.equals(that.currNumWalkers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), currNumCrawlers, currNumWalkers);
  }

  /* ===== Getters & Setters ===== */

  /**
   * Sets the CoTeacher. Also dynamically sets the max number of children depending on if the
   * teacher doesn't have a co-teacher (Name("", "")).
   *
   * @param teacher the {@code Name} of the co-teacher
   */
  @Override
  public void setCoTeacher(Name teacher) {
    if (teacher.equals(new Name("", ""))) {
      this.setMaxChildren(childrenPerTeacher);
    } else {
      this.setMaxChildren(childrenPerTeacher * 2);
    }
    super.setCoTeacher(teacher);
  }

  /**
   * Gets the number of students who can crawl, but not walk in the class.
   *
   * @return the number of children who can crawl
   */
  public Integer getCurrNumCrawlers() {
    return currNumCrawlers;
  }

  /**
   * Updates the number of children who can crawl, but not walk in the class.
   *
   * @param currNumCrawlers the new number of crawlers in the class
   */
  public void setCurrNumCrawlers(Integer currNumCrawlers) {
    this.currNumCrawlers = currNumCrawlers;
    validateNumber(currNumCrawlers);

  }

  /**
   * Gets the number of children in the class who can walk.
   *
   * @return the number of children who can walk
   */
  public Integer getCurrNumWalkers() {
    return currNumWalkers;
  }

  /**
   * Updates the number of children in the class who can walk.
   *
   * @param currNumWalkers the new number of strudents who can walk
   */
  public void setCurrNumWalkers(Integer currNumWalkers) {
    this.currNumWalkers = currNumWalkers;
    validateNumber(currNumWalkers);

  }

  /**
   * Ensures the given number is in a valid range.
   *
   * @param num the number to test
   * @throws IllegalArgumentException if the number is outside the range
   */
  private void validateNumber(Integer num) throws IllegalArgumentException {
    if (num < 0) {
      throw new IllegalArgumentException("can't have negative children");
    }
    if (currNumCrawlers + currNumWalkers > getCurrNumChildren()) {
      throw new IllegalArgumentException(
          "can't have more crawlers and walkers than are in the class");
    }
  }
}
