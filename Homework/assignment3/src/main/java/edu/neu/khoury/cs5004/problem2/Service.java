package edu.neu.khoury.cs5004.problem2;

/**
 * A {@code Service} is any kind of service offered by the property service company that this
 * invoicing system is being made for. A {@code Service} is immutable because if any of the elements
 * of the service change, it could be considered an entirely different service.
 *
 * @author evandouglass
 */
public interface Service {

  /**
   * Returns the price of this service as a Double.
   *
   * @return the price of this service
   */
  Double calculatePrice();

  /**
   * Generates a string representation of this service.
   *
   * @return a string representation of this service
   */
  String toString();

  /**
   * Test the equality of another object to this service.
   *
   * @param o the object to test
   * @return {@code true} if equal, else {@code false}
   */
  boolean equals(Object o);

  /**
   * Generates a hashcode for this service.
   *
   * @return a hashcode as an int
   */
  int hashCode();

  /**
   * Gets the invoice ID for this service.
   *
   * @return the invoice ID as a String
   */
  String getInvoiceID();

  /**
   * Gets the address at which this service was performed.
   *
   * @return the service address
   */
  String getServiceAddress();

  /**
   * Gets the size of the property at the service address.
   *
   * @return the size of the property as a {@code PropertySize} enum
   */
  PropertySize getPropertySize();

  /**
   * Indicates whether this service is performed on a monthly basis.
   *
   * @return {@true} if it is monthly, else {@code false}
   */
  boolean isMonthly();

  /**
   * Gets the number of times this service has been performed.
   *
   * @return the number of times this service has been performed
   */
  Integer getNumServices();
}
