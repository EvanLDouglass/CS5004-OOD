package edu.neu.khoury.cs5004.problem2;

/**
 * A {@code PaintingService} represents an interior painting service.
 *
 * @author evandouglass
 */
public class PaintingService extends AbstractInteriorService {

  /**
   * Constructor for an interior painting service.
   *
   * @param invoiceID the invoice ID for this service
   * @param serviceAddress the address the address at which the service is performed
   * @param propertySize the size of the property at which the service is performed
   * @param isMonthlyService {@code true} if this service is performed monthly, else {@code false}
   * @param numServicesAtAddr the number of times this service has been done at this address
   * @param numPetsAtAddr the number of pets at this service address
   */
  public PaintingService(String invoiceID, String serviceAddress,
      PropertySize propertySize, boolean isMonthlyService, Integer numServicesAtAddr,
      Integer numPetsAtAddr) throws IllegalArgumentException {
    super(invoiceID, serviceAddress, propertySize, isMonthlyService, numServicesAtAddr,
        numPetsAtAddr);
  }

  /* ===== Methods ===== */

  /**
   * Calculates the price of this service.
   *
   * @return the price as a Double
   * @throws IllegalStateException if the PropertySize is not recognized
   */
  @Override
  public Double calculatePrice() throws IllegalStateException {
    int hrsPerDay = 8;

    // Get number of days for work based on property size
    int days;
    switch (getPropertySize()) {
      case SMALL:
      case MEDIUM:
        days = 2;
        break;
      case LARGE:
        days = 3;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + getPropertySize());
    }

    return PRICE_PER_HOUR * days * hrsPerDay;
  }

  /* ===== Object Overrides ===== */
  // no extra fields so equals and hashCode are the same as super

  @Override
  public String toString() {
    return "PaintingService: " + super.toString();
  }
}
