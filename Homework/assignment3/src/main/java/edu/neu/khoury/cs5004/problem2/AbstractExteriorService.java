package edu.neu.khoury.cs5004.problem2;

import java.util.Objects;

public abstract class AbstractExteriorService extends AbstractService {

  private Integer month;

  /**
   * Constructor for an exterior service.
   *
   * @param invoiceID the invoice ID for this service
   * @param serviceAddress the address the address at which the service is performed
   * @param propertySize the size of the property at which the service is performed
   * @param isMonthlyService {@code true} if this service is performed monthly, else {@code false}
   * @param numServicesAtAddr the number of times this service has been done at this address
   * @param month the current month as an integer between 1 and 12, inclusive
   */
  public AbstractExteriorService(String invoiceID, String serviceAddress,
      PropertySize propertySize, boolean isMonthlyService, Integer numServicesAtAddr, Integer month)
      throws IllegalArgumentException {

    super(invoiceID, serviceAddress, propertySize, isMonthlyService, numServicesAtAddr);
    if (!isMonthValid(month)) {
      throw new IllegalArgumentException("month must be between 1 and 12, got: " + month);
    }
    this.month = month;
  }

  /* ===== Methods ===== */

  @Override
  public Double calculatePrice() {
    if (getPropertySize() == PropertySize.LARGE) {
      // 4 hour estimate for large properties
      return PRICE_PER_HOUR * 4;
    }
    // 2 hour estimate for medium and small properties
    return PRICE_PER_HOUR * 2;
  }

  /**
   * Determines in the given month is in the range [1, 12].
   *
   * @param month the month to test
   * @return {@code true} if the month is in the valid range, else {@code false}
   */
  private boolean isMonthValid(Integer month) {
    if (month < 1 || month > 12) {
      return false;
    }
    return true;
  }

  /* ===== Object Overrides ===== */

  @Override
  public String toString() {
    return super.toString() + " month=" + month;
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
    AbstractExteriorService that = (AbstractExteriorService) o;
    return month.equals(that.month);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), month);
  }

  /* ===== Getters ===== */

  /**
   * Gets the month that the service was performed, as an integer.
   *
   * @return the month as an integer between 1 and 12 inclusive
   */
  public Integer getMonth() {
    return month;
  }
}
