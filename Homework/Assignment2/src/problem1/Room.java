package problem1;

/**
 * Class Room represents a general room in a house. It contains functionality common to all
 * rooms in the house.
 * @author evandouglass
 * @version A2 P1
 */
public class Room {
  private Integer currentTemp;

  /**
   * Constructor for class Room.
   * @param currentTemp The current temperature of the room
   */
  public Room(Integer currentTemp) {
    this.currentTemp = currentTemp;
  }

  /**
   * Gets the current temperature.
   * @return the current temperature
   */
  public Integer getCurrentTemp() {
    return currentTemp;
  }

  /**
   * Sets the current temperature.
   * Allows class Thermostat to access temp data.
   * @param currentTemp the new temperature
   */
  public void setCurrentTemp(Integer currentTemp) {
    this.currentTemp = currentTemp;
  }
}
