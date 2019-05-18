package problem1;

/**
 * Class Room represents the temperature in a general room in a house.
 * It contains functionality common to all rooms in the house.
 * Temperatures are simplified and modeled as integers. All temperatures are in fahrenheit.
 * @author evandouglass
 */
public class Room {
  private Integer currentTemp;

  /**
   * Gets the current temperature.
   * @return the current temperature
   */
  public Integer getCurrentTemp() {
    return currentTemp;
  }

  /**
   * Set current temperature
   * @param temp the new temp
   */
  public void setCurrentTemp(Integer temp) {
    this.currentTemp = temp;
  }
}
