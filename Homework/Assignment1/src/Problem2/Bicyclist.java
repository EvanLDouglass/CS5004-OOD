package Problem2;

/**
 * Class Bicyclist represents a bicyclist in a bicycle race.
 * Bicyclist uses class Time in this package so fields startTime and
 * endTime are assumed to be within 24 hours of each other.
 * See Time documentation/implementation for more info.
 *
 * Note that once the Bicyclist first and last name has been set,
 * they cannot be changed.
 */
public class Bicyclist {
    private String firstName;
    private String lastName;
    private Time startTime;
    private Time endTime;

    /**
     * Basic constructor for Bicyclist.
     * @param firstName first name of the cyclist
     * @param lastName last name of the cyclist
     */
    public Bicyclist(String firstName, String lastName) {
        this(firstName, lastName, new Time(), new Time());
    }

    /**
     * Primary constructor for Bicyclist.
     * @param firstName first name of the cyclist
     * @param lastName last name of the cyclist
     * @param startTime time the cyclist started
     * @param endTime time the cyclist finished
     */
    public Bicyclist(String firstName, String lastName, Time startTime, Time endTime) {
        startSmallerThanEnd(startTime, endTime);  // Validates times
        this.firstName = firstName;
        this.lastName = lastName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * getDuration returns the difference between the end and start times of a Bicyclist.
     * Assumes that the end time is larger than the start time because these are validated
     * when set.
     * @return the difference between the end and start times of a Bicyclist
     */
    public Time getDuration() {
        int hour, min, sec;
        sec = this.endTime.getSec() - this.startTime.getSec();
        min = this.endTime.getMin() - this.startTime.getMin();
        hour = this.endTime.getHour() - this.startTime.getHour();

        // Account for negative seconds
        if (sec < 0) {
            min--;
            sec += 60;
        }

        // Account for negative minutes
        if (min < 0) {
            hour--;
            min += 60;
        }

        // Hour cannot be negative due to field validation
        // return new time
        return new Time(hour, min, sec);
    }

    /**
     * Does the same thing as getDuration, but checks whether the given end is
     * bigger than the given start. Throws an exception if end is before start.
     * IllegalArgumentException used because this function is used in setters and
     * constructor.
     * @param start the start time
     * @param end the end time
     */
    private void startSmallerThanEnd(Time start, Time end) throws IllegalArgumentException {
        int hour, min, sec;
        sec = end.getSec() - start.getSec();
        min = end.getMin() - start.getMin();
        hour = end.getHour() - start.getHour();

        // Account for negative seconds
        if (sec < 0) {
            min--;
        }

        // Account for negative minutes
        if (min < 0) {
            hour--;
        }

        // If hour is negative, there is a problem
        if (hour < 0) {
            throw new IllegalArgumentException("start time must be before end time");
        }
    }

    /**
     * Gets first name.
     * @return the cyclist's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name.
     * @return the cyclist's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the current start time
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * Sets start time.
     * @param startTime the new start time
     */
    public void setStartTime(Time startTime) {
        startSmallerThanEnd(startTime, this.endTime);  // Validates new time
        this.startTime = startTime;
    }

    /**
     * @return the current end time
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * Sets end time
     * @param endTime the new end time
     */
    public void setEndTime(Time endTime) {
        startSmallerThanEnd(this.startTime, endTime);  // Validates new time
        this.endTime = endTime;
    }
}
