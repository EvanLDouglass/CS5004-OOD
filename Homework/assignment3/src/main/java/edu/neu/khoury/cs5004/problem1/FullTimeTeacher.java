package edu.neu.khoury.cs5004.problem1;

/**
 * FullTimeTeacher serves as a common type for all full-time teachers at the daycare.
 *
 * @author evandouglass
 */
public interface FullTimeTeacher {

  /**
   * Converts a substitute teacher into a full-time teacher with the given position and co-teacher.
   *
   * @param sub the substitute teacher
   * @param position the position the sub is moving to, as a string
   * @param coTeacher the new full-time teacher's co-teacher
   * @return the substitute teacher converted into a full-time teacher
   */
  FullTimeTeacher convertSubstituteTeacher(SubstituteTeacher sub, String position,
      FullTimeTeacher coTeacher);

  // I've put the following methods in this interface because I only need to write the docs once.

  /* ===== Overrides ===== */

  /**
   * Creates a string representation of this object.
   *
   * @return a string representation of this object
   */
  String toString();

  /**
   * Test equality between this object and another.
   *
   * @param o the object to test
   * @return {@code true} if they are equal, else false
   */
  boolean equals(Object o);

  /**
   * Creates a hash code from this object.
   *
   * @return a hash code
   */
  int hashCode();

  /* ===== Getters & Setters ===== */

  /**
   * Gets this teacher's name.
   *
   * @return a {@code Name} object
   */
  Name getName();

  /**
   * Gets the classroom this teacher works in.
   *
   * @return the classroom name/number as a string
   */
  String getClassroom();

  /**
   * Sets the classroom this teacher works in.
   *
   * @param classroom the new classroom
   */
  void setClassroom(String classroom);

  /**
   * Gets this teacher's co-teacher in the classroom.
   *
   * @return the {@code Name} of the co-teacher
   */
  Name getCoTeacher();

  /**
   * Sets a new co-teacher for this teacher.
   *
   * @param teacher the {@code Name} of the co-teacher
   */
  void setCoTeacher(Name teacher);

  /**
   * Gets the vacation status of this teacher.
   *
   * @return {@code true} if this teacher is on vacation, else {@code false}
   */
  boolean getVacationStatus();

  /**
   * Sets a new vacation status for this teacher.
   *
   * @param status the new status
   */
  void setVacationStatus(boolean status);

  /**
   * Gets the current number of children in the class.
   *
   * @return number of children in the class
   */
  Integer getCurrNumChildren();

  /**
   * Sets the current number of children in the class.
   *
   * @param number the new number of children
   */
  void setCurrNumChildren(Integer number);

  /**
   * Gets the max number of children in the class.
   *
   * @return the max number of children in the class
   */
  Integer getMaxChildren();
}