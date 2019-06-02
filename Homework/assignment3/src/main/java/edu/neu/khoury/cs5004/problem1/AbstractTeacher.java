package edu.neu.khoury.cs5004.problem1;

import java.util.Objects;

/**
 * An AbstractTeacher contains data common to various kinds of teachers in a
 * daycare center.
 *
 * @author evandouglass
 */
public abstract class AbstractTeacher {

  private Name name;
  private String classroom;
  private Name coTeacher;
  private boolean vacationStatus;

  /**
   * Constructor for this teacher.
   *
   * @param name this teacher's name
   * @param classroom this teacher's classroom, as a string
   * @param coTeacher this teacher's co-teacher
   * @param vacationStatus whether this teacher is on vacation (true) or not (false)
   */
  public AbstractTeacher(Name name, String classroom, Name coTeacher, boolean vacationStatus) {
    this.name = name;
    this.classroom = classroom;
    this.coTeacher = coTeacher;
    this.vacationStatus = vacationStatus;
  }

  /* ===== Methods ===== */

  /**
   * Determines if this teacher has a co-teacher, as defined as
   * {@code null} or if coTeacher has empty strings for both first
   * and last name.
   *
   * @return {@code true} if the teacher has a co-teacher, else {@code false}
   */
  public boolean hasCoTeacher() {
    if (coTeacher == null || coTeacher.equals(new Name("", ""))) {
      return false;
    }
    return true;
  }

  /* ===== Overrides ===== */
  // Docs in interface

  @Override
  public String toString() {
    return String.format("name=%s classroom=%s coTeacher=%s onVacation=%b ",
        name, classroom, coTeacher, vacationStatus);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractTeacher that = (AbstractTeacher) o;
    return vacationStatus == that.vacationStatus
        && name.equals(that.name)
        && classroom.equals(that.classroom)
        && coTeacher.equals(that.coTeacher);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, classroom, coTeacher, vacationStatus);
  }

  /* ===== Getters & Setters ===== */

  /**
   * Gets this teacher's name.
   *
   * @return a {@code Name} object
   */
  public Name getName() {
    return name;
  }

  /**
   * Gets the classroom this teacher works in.
   *
   * @return the classroom name/number as a string
   */
  public String getClassroom() {
    return classroom;
  }

  /**
   * Sets the classroom this teacher works in.
   *
   * @param classroom the new classroom
   */
  public void setClassroom(String classroom) {
    this.classroom = classroom;
  }

  /**
   * Gets this teacher's co-teacher in the classroom.
   *
   * @return the {@code Name} of the co-teacher
   */
  public Name getCoTeacher() {
    return coTeacher;
  }

  /**
   * Sets a new co-teacher for this teacher.
   *
   * @param teacher the {@code Name} of the co-teacher
   */
  public void setCoTeacher(Name teacher) {
    this.coTeacher = teacher;
  }

  /**
   * Gets the vacation status of this teacher.
   *
   * @return {@code true} if this teacher is on vacation, else {@code false}
   */
  public boolean getVacationStatus() {
    return vacationStatus;
  }

  /**
   * Sets a new vacation status for this teacher.
   *
   * @param status the new status
   */
  public void setVacationStatus(boolean status) {
    this.vacationStatus = status;
  }
}
