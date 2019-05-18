package problem1;

/**
 * Class Thermostat represents a thermostat that can control
 * the temperature in different rooms in a house separately
 * or all at the same time.
 */
public class Thermostat {
  private Bedrooms bedrooms;
  private Bathrooms bathrooms;
  private LivingRooms livingRooms;

  /**
   * Constructor for Thermostat that accepts objects
   * @param bedrooms a Bedrooms object
   * @param bathrooms a Bathrooms object
   * @param livingRooms a LivingRooms object
   */
  public Thermostat(Bedrooms bedrooms, Bathrooms bathrooms, LivingRooms livingRooms) {
    this.bedrooms = bedrooms;
    this.bathrooms = bathrooms;
    this.livingRooms = livingRooms;
  }

  /**
   * Constructor for Thermostat that accepts temperatures for the rooms
   * @param bedTemp a temp at which to set bedrooms
   * @param bathTemp a temp at which to set bathrooms
   * @param livingTemp a temp at which to set living rooms
   */
  public Thermostat(Integer bedTemp, Integer bathTemp, Integer livingTemp) {
    this.bedrooms = new Bedrooms(bedTemp);
    this.bathrooms = new Bathrooms(bathTemp);
    this.livingRooms = new LivingRooms(livingTemp);
  }

  /* ===== Temp Getters & Setters ===== */

  /**
   * Gets the bedroom temperature.
   * @return the current bedroom temp
   */
  public Integer getBedTemp() {
    return bedrooms.getCurrentTemp();
  }

  /**
   * Sets the bedroom temperature.
   * @param temp the new temp
   */
  public void setBedTemp(Integer temp) {
    bedrooms.setCurrentTemp(temp);
  }

  /**
   * Gets the bathroom temperature.
   * @return the current bathroom temp
   */
  public Integer getBathTemp() {
    return bathrooms.getCurrentTemp();
  }

  /**
   * Sets the bathroom temperature.
   * @param temp the new temp
   */
  public void setBathTemp(Integer temp) {
    bathrooms.setCurrentTemp(temp);
  }

  /**
   * Gets the living room temperature.
   * @return the current living room temperature
   */
  public Integer getLivingTemp() {
    return livingRooms.getCurrentTemp();
  }

  /**
   * Sets the living room temperature.
   * @param temp the new temp
   */
  public void setLivingTemp(Integer temp) {
    livingRooms.setCurrentTemp(temp);
  }

  /**
   * Sets every room to the same temperature. If the temperature is above or below
   * any individual room's max or min temp, that room will be set at it's respective
   * max or min temp.
   * @param temp the new temp
   */
  public void setHouseTemp(Integer temp) {
    bedrooms.setCurrentTemp(temp);
    bathrooms.setCurrentTemp(temp);
    livingRooms.setCurrentTemp(temp);
  }

  /* ===== Basic Getters & Setters ===== */

  /**
   * Getter for Bedrooms field
   * @return Bedrooms object
   */
  public Bedrooms getBedrooms() {
    return bedrooms;
  }

  /**
   * Setter for Bedrooms field
   * @param bedrooms new Bedrooms object
   */
  public void setBedrooms(Bedrooms bedrooms) {
    this.bedrooms = bedrooms;
  }

  /**
   * Getter for Bathrooms field
   * @return Bathrooms object
   */
  public Bathrooms getBathrooms() {
    return bathrooms;
  }

  /**
   * Setter for Bathrooms field
   * @param bathrooms new Bathrooms object
   */
  public void setBathrooms(Bathrooms bathrooms) {
    this.bathrooms = bathrooms;
  }

  /**
   * Getter for LivingRooms field
   * @return LivingRooms object
   */
  public LivingRooms getLivingRooms() {
    return livingRooms;
  }

  /**
   * Setter for LivingRooms field
   * @param livingRooms new LivingRoom object
   */
  public void setLivingRooms(LivingRooms livingRooms) {
    this.livingRooms = livingRooms;
  }
}
