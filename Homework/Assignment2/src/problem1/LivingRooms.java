package problem1;

/**
 * Class LivingRooms represents temperature information in all
 * rooms in a house.
 * @author evandouglass
 */
public class LivingRooms extends Room {
  public static final Integer MIN_TEMP = 60;
  public static final Integer MAX_TEMP = 72;

  /**
   * Constructor for class LivingRooms.
   * @param currentTemp The current temperature of the room
   */
  public LivingRooms(Integer currentTemp) {
    // Check min/max bounds and reassign
    if (currentTemp < MIN_TEMP) {
      currentTemp = MIN_TEMP;
    } else if (currentTemp > MAX_TEMP) {
      currentTemp = MAX_TEMP;
    }

    this.setCurrentTemp(currentTemp);
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
