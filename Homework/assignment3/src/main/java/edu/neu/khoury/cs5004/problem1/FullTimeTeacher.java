package edu.neu.khoury.cs5004.problem1;

/**
 * FullTimeTeacher serves as a common type for all full-time teachers at the daycare.
 *
 * @author evandouglass
 */
public interface FullTimeTeacher {

//  /**
//   * Converts a substitute teacher into a full-time teacher with the given position and co-teacher.
//   *
//   * @param sub the substitute teacher
//   * @param position the position the sub is moving to, as a string
//   * @param coTeacher the new full-time teacher's co-teacher
//   * @return the substitute teacher converted into a full-time teacher
//   */
//  FullTimeTeacher convertSubstituteTeacher(SubsituteTeacher sub, String position,
//      FullTimeTeacher coTeacher);

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
}