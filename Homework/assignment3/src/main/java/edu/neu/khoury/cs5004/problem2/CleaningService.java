package edu.neu.khoury.cs5004.problem2;

public class CleaningService extends AbstractInteriorService {

  /**
   * Constructor for an interior cleaning service.
   *
   * @param invoiceID the invoice ID for this service
   * @param serviceAddress the address the address at which the service is performed
   * @param propertySize the size of the property at which the service is performed
   * @param isMonthlyService {@code true} if this service is performed monthly, else {@code false}
   * @param numServicesAtAddr the number of times this service has been done at this address
   * @param numPetsAtAddr the number of pets at this service address
   */
  public CleaningService(String invoiceID, String serviceAddress,
      PropertySize propertySize, boolean isMonthlyService, Integer numServicesAtAddr,
      Integer numPetsAtAddr) throws IllegalArgumentException {
    super(invoiceID, serviceAddress, propertySize, isMonthlyService, numServicesAtAddr,
        numPetsAtAddr);
  }

  /* ===== Methods ===== */

  /**
   * Calculates the price of an interior service.
   *
   * @return the price of this service
   * @throws IllegalStateException if PropertySize is not recognized
   */
  @Override
  public Double calculatePrice() throws IllegalStateException {
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
        throw new IllegalStateException("Unexpected value: " + getPropertySize());
    }
    return price;
  }

  /* ===== Object Overrides ===== */

  @Override
  public String toString() {
    return "CleaningService: " + super.toString();
  }
}
