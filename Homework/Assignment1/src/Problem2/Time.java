package Problem2;

import java.util.Objects;

/**
 * Class Time represents a time of day in 24 hour increments, from 00:00:00 to 23:59:59.
 * Time does not distinguish days. Therefore a duration between two Times cannot be more
 * than 23hrs 59mins, 59secs.
 *
 * @author evandouglass
 */
public class Time {
    private int hour;
    private int minute;
    private int second;

    /**
     * Basic constructor for Time
     */
    public Time() {
        this(0,0,0);
    }

    /**
     * Primary constructor for Time
     * @param hour the hour
     * @param minute the minute
     * @param second the second
     */
    public Time(int hour, int minute, int second) {
        this.hour = Time.validateHour(hour);
        this.minute = Time.validateMinSec(minute);
        this.second = Time.validateMinSec(second);
    }

    /**
     * validateHour ensures that any entered hour is between 0 and 23.
     * Given a number outside the range, uses mod 24 to put it inside the range.
     * @param hour the given hour
     * @return a number in the range (0, 23)
     */
    private static int validateHour(int hour) {
        if (hour >= 0) {
            return hour % 24;
        } else {
            int rem = hour % 24;
            return 24 + rem;  // rem will be negative
        }
    }

    /**
     * validateMinSec ensures that any entered minute or second is between 0 and 59.
     * Given a number outside the range, uses mod 60 to put it inside the range.
     * @param number the given minute or second
     * @return a number in the range (0, 59)
     */
    private static int validateMinSec(int number) {
        if (number >= 0) {
            return number % 60;
        } else {
            int rem = number % 60;
            return 60 + rem;  // rem will be negative
        }
    }

    /**
     * @return The current hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * @param hour the new hour
     */
    public void setHour(int hour) {
        this.hour = validateHour(hour);
    }

    /**
     * @return the current minute
     */
    public int getMin() {
        return minute;
    }

    /**
     * @param minute the new minute
     */
    public void setMin(int minute) {
        this.minute = validateMinSec(minute);
    }

    /**
     * @return the current second
     */
    public int getSec() {
        return second;
    }

    /**
     * @param second the new second
     */
    public void setSec(int second) {
        this.second = validateMinSec(second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hour == time.hour &&
                minute == time.minute &&
                second == time.second;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
}
