package edu.neu.khoury.cs5004.problem2;

import java.util.Objects;

/**
 * An {@code AbstractService} contains data and some functionality of a general
 * service offered by the company, as described in the {@code Service} interface.
 *
 * @author evandouglass
 */
public abstract class AbstractService implements Service {

  public static Double PRICE_PER_HOUR = 80.0;

  private String invoiceID;
  private String serviceAddress;
  private PropertySize propertySize;
  private boolean isMonthlyService;
  private Integer numServicesAtAddr;

  /**
   * Constructor for a Service.
   *
   * @param invoiceID the invoice ID for this service
   * @param serviceAddress the address the address at which the service is performed
   * @param propertySize the size of the property at which the service is performed
   * @param isMonthlyService {@code true} if this service is performed monthly, else {@code false}
   * @param numServicesAtAddr the number of times this service has been done at this address
   */
  public AbstractService(String invoiceID, String serviceAddress,
      PropertySize propertySize, boolean isMonthlyService, Integer numServicesAtAddr)
        throws IllegalArgumentException {
    if (isNegative(numServicesAtAddr)) {
      throw new IllegalArgumentException("can't have a negative number of services");
    }

    this.invoiceID = invoiceID;
    this.serviceAddress = serviceAddress;
    this.propertySize = propertySize;
    this.isMonthlyService = isMonthlyService;
    this.numServicesAtAddr = numServicesAtAddr;
  }

  /* ===== Methods ===== */

  /**
   * Gives a loyalty discount for a service that monthly or is the 10th
   * in a row. The discounts are mutually exclusive.
   *
   * @param base the base price
   * @return a discounted base price, if one of the loyalty discounts can
   * be applied.
   */
  Double giveLoyaltyDiscount(Double base) {
    if (numServicesAtAddr % 10 == 9) {  // means this service will be 10th
      base = giveEveryTenthDiscount(base);
    } else if (isMonthlyService) {
      base = giveMonthlyDiscount(base);
    }
    return base;
  }

  /**
   * If this service is performed monthly, this method gives a 10%
   * discount from the base price.
   *
   * @param base the base price
   * @return the price after a discount is applied, or the same price depending
   * on if the service is monthly
   */
  private Double giveMonthlyDiscount(Double base) {
    Double percent = 0.1;
    return base - (base * percent);
  }

  /**
   * If this service will be the tenth in a row, this method gives a
   * 50% discount from the base price.
   *
   * @param base the base price
   * @return the price after a discount is applied, or the same price depending
   * on if the service is the tenth in a row
   */
  private Double giveEveryTenthDiscount(Double base) {
    return base / 2;
  }

  /**
   * Tests if a number is positive.
   *
   * @param num the number to test
   * @return {@code true} if the number is negative, else {@code false}
   */
  boolean isNegative(Integer num) {
    return num < 0;
  }

  /* ===== Object Overrides ===== */

  @Override
  public String toString() {
    return String.format("invoice=%s address='%s' size=%s monthly=%b serviced=%d",
        invoiceID, serviceAddress, propertySize, isMonthlyService, numServicesAtAddr);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractService that = (AbstractService) o;
    return isMonthlyService == that.isMonthlyService
        && invoiceID.equals(that.invoiceID)
        && serviceAddress.equals(that.serviceAddress)
        && propertySize == that.propertySize
        && numServicesAtAddr.equals(that.numServicesAtAddr);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(invoiceID, serviceAddress, propertySize, isMonthlyService, numServicesAtAddr);
  }

  /* ===== Getters ===== */

  @Override
  public String getInvoiceID() {
    return invoiceID;
  }

  @Override
  public String getServiceAddress() {
    return serviceAddress;
  }

  @Override
  public PropertySize getPropertySize() {
    return propertySize;
  }

  @Override
  public boolean isMonthly() {
    return isMonthlyService;
  }

  @Override
  public Integer getNumServices() {
    return numServicesAtAddr;
  }
}
