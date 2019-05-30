package edu.neu.khoury.sc5004.problem1;

import java.util.Objects;

/**
 * A simple age class. Age is limited to the range [0, 128].
 *
 * @author evandouglass
 */
public class Age {

  private Integer age;

  /**
   * Constructor for Age.
   *
   * @param age the age
   */
  public Age(Integer age) {
    validateAboveMin(age);
    validateBelowMin(age);
    this.age = age;
  }

  /**
   * Ensures age is positive.
   *
   * @param age the age to check
   * @throws IllegalArgumentException if age < 0
   */
  private void validateBelowMin(Integer age) throws IllegalArgumentException {
    if (age < 0) {
      throw new IllegalArgumentException("age must be positive");
    }
  }

  /**
   * Ensures age is less than 129.
   *
   * @param age age to test
   * @throws IllegalArgumentException if age > 128
   */
  private void validateAboveMin(Integer age) throws IllegalArgumentException {
    if (age > 128) {
      throw new IllegalArgumentException("age must be 128 or less");
    }
  }

  /**
   * Represents object as a string.
   *
   * @return a string
   */
  @Override
  public String toString() {
    return "Age: " + age;
  }

  /**
   * Test equality.
   *
   * @param o object to compare
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
    Age age1 = (Age) o;
    return age.equals(age1.age);
  }

  /**
   * Generates a hashcode.
   *
   * @return a hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(age);
  }

  /**
   * Getter for age.
   *
   * @return the age
   */
  public Integer getAge() {
    return age;
  }
}
