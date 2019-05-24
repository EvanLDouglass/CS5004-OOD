package edu.neu.khoury.cs5004.game;

/**
 * A class to represent an age. Age must be in the range [0, 128].
 *
 * @author evandouglass
 */
public class Age {

  private Integer age;

  /**
   * Constructor for <pre>Age</pre>.
   *
   * @param age age as an Integer
   * @throws IncorrectAgeRangeException if age is outside the range [0, 128]
   */
  public Age(Integer age) throws IncorrectAgeRangeException {
    this.age = age;
    validateAge();
  }

  /**
   * Checks upper and lower bounds on an <pre>Age</pre>.
   *
   * @throws IncorrectAgeRangeException if age is below 0 or above 128
   */
  private void validateAge() throws IncorrectAgeRangeException {
    checkLow();
    checkHigh();
  }

  /**
   * Checks lower bound on age.
   *
   * @throws IncorrectAgeRangeException if age is below 0
   */
  private void checkLow() throws IncorrectAgeRangeException {
    if (age < 0) {
      throw new IncorrectAgeRangeException("Age must be zero or more");
    }
  }

  /**
   * Checks upper bound on age.
   *
   * @throws IncorrectAgeRangeException if age is above 128
   */
  private void checkHigh() throws IncorrectAgeRangeException {
    if (age > 128) {
      throw new IncorrectAgeRangeException("Age must be 128 or less");
    }
  }

  /**
   * Generates a string representation of this object
   *
   * @return an <pre>Age</pre> string
   */
  @Override
  public String toString() {
    return String.format("Age{%d}", age);
  }

  /**
   * Test equality of this object to another.
   *
   * @param o another object
   * @return <pre>true</pre> if equal, else <pre>false</pre>
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
   * Getter for age.
   *
   * @return age as an Integer
   */
  public Integer getAge() {
    return age;
  }
}
