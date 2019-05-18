package problem1;

/**
 * Class Bathrooms represents temperature information in all
 * bathrooms in a class.
 * @author evandouglass
 */
public class Bathrooms extends Room {
  public static final Integer MIN_TEMP = 58;
  public static final Integer MAX_TEMP = 70;

  /**
   * Constructor for class Bathrooms.
   * @param currentTemp The current temperature of the room
   */
  public Bathrooms(Integer currentTemp) {
    // Check min/max bounds and reassign
    if (currentTemp < MIN_TEMP) {
      currentTemp = MIN_TEMP;
    } else if (currentTemp > MAX_TEMP) {
      currentTemp = MAX_TEMP;
    }

    setCurrentTemp(currentTemp);
  }

  /**
   * Sets the current temperature. If the temp is above the max
   * or below the min, sets the temp to the max or min, respectively.
   * @param temp the new temperature
   */
  @Override
  public void setCurrentTemp(Integer temp) {
    // Check min/max bounds and reassign
    if (temp < MIN_TEMP) {
      temp = MIN_TEMP;
    } else if (temp > MAX_TEMP) {
      temp = MAX_TEMP;
    }

    super.setCurrentTemp(temp);
  }
}
