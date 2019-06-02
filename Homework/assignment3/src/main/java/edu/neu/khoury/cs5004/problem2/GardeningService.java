package edu.neu.khoury.cs5004.problem2;

public class GardeningService extends AbstractExteriorService {

  /**
   * Constructor for an exterior gardening service.
   *
   * @param invoiceID the invoice ID for this service
   * @param serviceAddress the address the address at which the service is performed
   * @param propertySize the size of the property at which the service is performed
   * @param isMonthlyService {@code true} if this service is performed monthly, else {@code false}
   * @param numServicesAtAddr the number of times this service has been done at this address
   * @param month the current month as an integer between 1 and 12, inclusive
   */
  public GardeningService(String invoiceID, String serviceAddress,
      PropertySize propertySize, boolean isMonthlyService, Integer numServicesAtAddr,
      Integer month) throws IllegalArgumentException {
    super(invoiceID, serviceAddress, propertySize, isMonthlyService, numServicesAtAddr, month);
  }

  /* ===== Methods ===== */

  @Override
  public Double calculatePrice() {
    Double wasteRemovalFee = 20.0;
    return giveLoyaltyDiscount(super.calculatePrice() + wasteRemovalFee);
  }

  /* ===== Object Overrides ===== */
  // No additional fields so equals and hashcode are the same as super class

  @Override
  public String toString() {
    return "GardeningService: " + super.toString();
  }
}
