package problem1;

/**
 * Class Thermostat represents a thermostat that can control the temperature in different rooms in a
 * house separately or all at the same time.
 *
 * @author evandouglass
 */
public class Thermostat {

  public static final Integer MIN_BED_TEMP = 60;
  public static final Integer MAX_BED_TEMP = 68;
  public static final Integer MIN_BATH_TEMP = 58;
  public static final Integer MAX_BATH_TEMP = 70;
  public static final Integer MIN_LIVING_TEMP = 60;
  public static final Integer MAX_LIVING_TEMP = 72;

  private enum RoomType {BED, BATH, LIVING}

  private Bedrooms bedrooms;
  private Bathrooms bathrooms;
  private LivingRooms livingRooms;

  /**
   * Constructor for Thermostat that accepts temperatures for the rooms
   *
   * @param bedTemp a temp at which to set bedrooms
   * @param bathTemp a temp at which to set bathrooms
   * @param livingTemp a temp at which to set living rooms
   */
  public Thermostat(Integer bedTemp, Integer bathTemp, Integer livingTemp) {
    this.bedrooms = new Bedrooms(checkTemp(bedTemp, RoomType.BED));
    this.bathrooms = new Bathrooms(checkTemp(bathTemp, RoomType.BATH));
    this.livingRooms = new LivingRooms(checkTemp(livingTemp, RoomType.LIVING));
  }

  /* ===== Temp Getters & Setters ===== */

  /**
   * <pre>checkTemp</pre> checks a temperature against the max and min temperature for a given
   * type of room. If the temperature is outside the acceptable range, it is reset to either the max
   * or min for that type of room.
   *
   * @param temp the given temperature
   * @param room the type of room
   * @return If temp is within the acceptable range, the same temp; if below, the room minimum; if
   * above, the room maximum.
   */
  private Integer checkTemp(Integer temp, RoomType room) throws IllegalArgumentException {
    switch (room) {
      case BED:
        if (temp < MIN_BED_TEMP) {
          temp = MIN_BED_TEMP;
        } else if (temp > MAX_BED_TEMP) {
          temp = MAX_BED_TEMP;
        }
        break;

      case BATH:
        if (temp < MIN_BATH_TEMP) {
          temp = MIN_BATH_TEMP;
        } else if (temp > MAX_BATH_TEMP) {
          temp = MAX_BATH_TEMP;
        }
        break;

      case LIVING:
        if (temp < MIN_LIVING_TEMP) {
          temp = MIN_LIVING_TEMP;
        } else if (temp > MAX_LIVING_TEMP) {
          temp = MAX_LIVING_TEMP;
        }
        break;

      default:
        // As this method is private, this should never be thrown, but is here just in case.
        throw new IllegalArgumentException(
            "unrecognized room type: must be one of BED, BATH, LIVING");
    }

    // temp has been reset to be within acceptable bounds
    return temp;
  }

  /**
   * Sets the bedroom temperature. If the temperature is outside the acceptable range for a bedroom,
   * it is reset to either the max or min for that type of room.
   *
   * @param temp the desired temp
   * @return A new Thermostat object with the updated temp
   */
  public Thermostat setBedTemp(Integer temp) {
    Integer bed = checkTemp(temp, RoomType.BED);
    Integer bath = this.getBathTemp();
    Integer living = this.getLivingRoomTemp();

    return new Thermostat(bed, bath, living);
  }

  /**
   * Gets the current bedroom temperature
   *
   * @return the bedroom temperature
   */
  public Integer getBedTemp() {
    return bedrooms.getCurrentTemp();
  }

  /**
   * Sets the bathroom temperature. If the temperature is outside the acceptable range for a
   * bathroom, it is reset to either the max or min for that type of room.
   *
   * @param temp the desired temp
   * @return A new Thermostat object with the updated temp
   */
  public Thermostat setBathTemp(Integer temp) {
    Integer bath = checkTemp(temp, RoomType.BATH);
    Integer bed = this.getBedTemp();
    Integer living = this.getLivingRoomTemp();

    return new Thermostat(bed, bath, living);
  }

  /**
   * Gets the current bathroom temperature.
   *
   * @return the bathroom temp
   */
  public Integer getBathTemp() {
    return bathrooms.getCurrentTemp();
  }

  /**
   * Sets the living room temperature. If the temperature is outside the acceptable range for a
   * living room, it is reset to either the max or min for that type of room.
   *
   * @param temp the desired temp
   * @return A new Thermostat object with the updated temp
   */
  public Thermostat setLivingRoomTemp(Integer temp) {
    Integer living = checkTemp(temp, RoomType.LIVING);
    Integer bed = this.getBedTemp();
    Integer bath = this.getBathTemp();

    return new Thermostat(bed, bath, living);
  }

  /**
   * Gets the current living room temperature.
   *
   * @return the living room temp
   */
  public Integer getLivingRoomTemp() {
    return livingRooms.getCurrentTemp();
  }

  /**
   * Sets the temperature in all rooms at once.
   *
   * @param temp the desired temp
   */
  public Thermostat setHouseTemp(Integer temp) {
    Integer bed = checkTemp(temp, RoomType.BED);
    Integer bath = checkTemp(temp, RoomType.BATH);
    Integer living = checkTemp(temp, RoomType.LIVING);

    return new Thermostat(bed, bath, living);
  }

  /* ===== Basic Getters ===== */

  /**
   * Getter for Bedrooms field
   *
   * @return Bedrooms object
   */
  public Bedrooms getBedrooms() {
    return bedrooms;
  }

  /**
   * Getter for Bathrooms field
   *
   * @return Bathrooms object
   */
  public Bathrooms getBathrooms() {
    return bathrooms;
  }

  /**
   * Getter for LivingRooms field
   *
   * @return LivingRooms object
   */
  public LivingRooms getLivingRooms() {
    return livingRooms;
  }
}
