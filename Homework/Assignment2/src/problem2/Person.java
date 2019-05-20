package problem2;

import java.util.HashMap;
import java.util.Objects;

/**
 * Class Person is a simple representation of a person, with a first and last name, an address, and
 * an email.
 *
 * @author evandouglass
 */
public class Person {

  private String firstName;
  private String lastName;
  private String address;
  private String email;

  /**
   * Full constructor for <pre>Person</pre>.
   *
   * @param firstName person's first name
   * @param lastName person's last name
   * @param address person's address
   * @param email person's email
   */
  public Person(String firstName, String lastName, String address, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
  }

  /* ===== Overrides ===== */

  /**
   * Returns a string representation of a Person
   *
   * @return a string representation of a Person
   */
  @Override
  public String toString() {
    return "Person{" +
        firstName + " " + lastName + "\n\t" +
        address + "\n\t" +
        email + '}';
  }

  /**
   * Checks equality of another object to this person.
   *
   * @param o an object to test
   * @return <pre>true</pre> if the objects are equal, <pre>false</pre> otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return firstName.equals(person.firstName) &&
        lastName.equals(person.lastName) &&
        Objects.equals(address, person.address) &&
        Objects.equals(email, person.email);
  }

  /* ===== Getters ===== */

  /**
   * Gets person's first name
   *
   * @return first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets person's last name
   *
   * @return last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get's person's physical address
   *
   * @return address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Get's person's email address
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }
}
