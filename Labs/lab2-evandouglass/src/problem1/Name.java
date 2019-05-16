package problem1;

/**
 * Class Name represents a simple name, with first, middle and last names.
 */
public class Name {

  private String firstName;
  private String middleName;
  private String lastName;

  /**
   * Null constructor for Name
   */
  public Name() {
  }

  /**
   * Assigns first name
   * @param firstName the first name
   */
  public Name(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Assigns first and middle names
   * @param firstName first name
   * @param middleName middle name
   */
  public Name(String firstName, String middleName) {
    this.firstName = firstName;
    this.middleName = middleName;
  }

  /**
   * Full constructor for Name
   * @param firstName first name
   * @param middleName middle name
   * @param lastName last name
   */
  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  /**
   * @return first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return middle name
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * @return last name
   */
  public String getLastName() {
    return lastName;
  }
}
