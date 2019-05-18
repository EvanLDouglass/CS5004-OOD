package problem1;

/**
 * Class Bedrooms represents temperature information in all
 * bedrooms in a class.
 * @author evandouglass
 */
public class Bedrooms extends Room {
  public static final Integer MIN_TEMP = 60;
  public static final Integer MAX_TEMP = 68;

  /**
   * Constructor for class Room.
   * @param currentTemp The current temperature of the room
   */
  public Bedrooms(Integer currentTemp) {
    // Check min/max bounds and reassign
    if (currentTemp < MIN_TEMP) {
      currentTemp = MIN_TEMP;
    } else if (currentTemp > MAX_TEMP) {
      currentTemp = MAX_TEMP;
    }

    setCurrentTemp(currentTemp);
  }

  /* ===== Setters ===== */
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
