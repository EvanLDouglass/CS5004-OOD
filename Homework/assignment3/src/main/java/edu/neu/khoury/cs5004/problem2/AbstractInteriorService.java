package edu.neu.khoury.cs5004.problem2;

import java.util.Objects;

/**
 * An interior service can be either cleaning or painting. The number of pets at the service address
 * will affect pricing.
 *
 * @author evandouglass
 */
public abstract class AbstractInteriorService extends AbstractService {

  private Integer numPetsAtAddr;

  /**
   * Constructor for an interior service.
   *
   * @param invoiceID the invoice ID for this service
   * @param serviceAddress the address the address at which the service is performed
   * @param propertySize the size of the property at which the service is performed
   * @param isMonthlyService {@code true} if this service is performed monthly, else {@code false}
   * @param numServicesAtAddr the number of times this service has been done at this address
   * @param numPetsAtAddr the number of pets at this service address
   */
  public AbstractInteriorService(String invoiceID, String serviceAddress, PropertySize propertySize,
      boolean isMonthlyService, Integer numServicesAtAddr, Integer numPetsAtAddr)
      throws IllegalArgumentException {

    super(invoiceID, serviceAddress, propertySize, isMonthlyService, numServicesAtAddr);
    if (isNegative(numPetsAtAddr)) {
      throw new IllegalArgumentException("can't have a negative number of pets");
    }
    this.numPetsAtAddr = numPetsAtAddr;
  }

  /* ===== Methods ===== */

  /**
   * Calculates the price of an interior service.
   *
   * @return the price of this service
   */
  @Override
  public Double calculatePrice() {
    Double price;
    switch (getPropertySize()) {
      case SMALL:
        price = PRICE_PER_HOUR;
        break;
      case MEDIUM:
        price = PRICE_PER_HOUR * 2;
        break;
      case LARGE:
        price = PRICE_PER_HOUR * 4;
        break;
      default:
        // to appease the compiler
        price = null;
    }
    return price;
  }

  /* ===== Object Overrides ===== */

  @Override
  public String toString() {
    return super.toString() + " pets=" + numPetsAtAddr;
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
    AbstractInteriorService that = (AbstractInteriorService) o;
    return numPetsAtAddr.equals(that.numPetsAtAddr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numPetsAtAddr);
  }

  /* ===== Getters ===== */

  /**
   * Gets the number of pets at the service address.
   *
   * @return the number of pets
   */
  public Integer getNumPetsAtAddr() {
    return numPetsAtAddr;
  }
}
