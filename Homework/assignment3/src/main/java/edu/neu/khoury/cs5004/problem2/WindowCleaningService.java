package edu.neu.khoury.cs5004.problem2;

import java.util.Objects;

/**
 * Represents a window cleaning service at the company.
 *
 * @author evandouglass
 */
public class WindowCleaningService extends AbstractExteriorService {

  private static final Integer MAX_FLOORS = 3;
  private static final Integer MIN_FLOORS = 1;

  private Integer numFloors;

  /**
   * Constructor for an exterior window cleaning service.
   *
   * @param invoiceID the invoice ID for this service
   * @param serviceAddress the address the address at which the service is performed
   * @param propertySize the size of the property at which the service is performed
   * @param isMonthlyService {@code true} if this service is performed monthly, else {@code false}
   * @param numServicesAtAddr the number of times this service has been done at this address
   * @param month the current month as an integer between 1 and 12, inclusive
   * @param numFloors the number of floors at the service address
   */
  public WindowCleaningService(String invoiceID, String serviceAddress,
      PropertySize propertySize, boolean isMonthlyService, Integer numServicesAtAddr,
      Integer month, Integer numFloors)
      throws TooManyFloorsException, IllegalArgumentException {

    super(invoiceID, serviceAddress, propertySize, isMonthlyService, numServicesAtAddr, month);
    if (numFloors < MIN_FLOORS) {
      throw new IllegalArgumentException("a building cannot have negative floors with windows");
    }
    if (numFloors > MAX_FLOORS) {
      throw new TooManyFloorsException("our ladders can only reach to three floors!");
    }
    this.numFloors = numFloors;
  }

  /* ===== Methods ===== */

  @Override
  public Double calculatePrice() {
    return addFee(super.calculatePrice());
  }

  /**
   * Adds a 5% fee to the price of this service if the service property has more than one floor.
   *
   * @param basePrice the initial price, without accounting for a fee
   * @return the final price, accounting for the fee
   */
  private Double addFee(Double basePrice) {
    double percent = 0.05;
    if (numFloors > 1) {
      return basePrice + (basePrice * percent);
    }
    // if only one floor, no fee is added
    return basePrice;
  }

  /* ===== Object Overrides ===== */

  @Override
  public String toString() {
    return "WindowCleaningService: " + super.toString() + " floors=" + numFloors;
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
    WindowCleaningService that = (WindowCleaningService) o;
    return numFloors.equals(that.numFloors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numFloors);
  }

  /* ===== Getters ===== */

  /**
   * Gets the number of floors that the service property has.
   *
   * @return the number of floors at this property
   */
  public Integer getNumFloors() {
    return numFloors;
  }
}
