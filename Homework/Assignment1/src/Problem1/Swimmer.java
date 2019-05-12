package Problem1;

/**
 * Class Swimmer contains information about a swimmer. This class is
 * used as a part of Problem 1.
 *
 * @author evandouglass
 */
public class Swimmer {
    private String firstName;
    private String lastName;
    private SwimTimes times;

    /**
     * Constructor that creates a new Swimmer object with the
     * specified first name, last name and best backstroke time.
     * @param firstName - swimmer's first name
     * @param lastName - swimmer's last name
     * @param times - best 50m backstroke time
     **/
    public Swimmer(String firstName, String lastName, SwimTimes times) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.times = times;
    }

    /**
     * Constructor that creates a new Swimmer object with the
     * specified first name, last name and default best 50m backstroke time (-1).
     * @param firstName - swimmer's first name
     * @param lastName - swimmer's last name
     **/
    public Swimmer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.times = new SwimTimes();
    }

    /** Returns the swimmer's first name
     * @return - swimmer's first name
     **/
    public String getFirstName() {
        return this.firstName;
    }

    /** Returns the swimmer's last name
     * @return - swimmer's last name
     **/
    public String getLastName () {
        return this.lastName;
    }

    /**
     * @return The swimmer's SwimTimes
     */
    public SwimTimes getTimes() {
        return this.times;
    }

    /**
     * Sets the swimmer's time as a new SwimTime object.
     */
    public void setTimes(SwimTimes times) {
        this.times = times;
    }

    /**
     * @return the backstroke time
     */
    public double getBest50mBackstrokeTime() {
        return this.times.getBest50mBackstrokeTime();
    }

    /**
     * Set the backstroke time.
     * @param best50mBackstrokeTime Best backstroke time
     */
    public void setBest50mBackstrokeTime(double best50mBackstrokeTime) {
        this.times.setBest50mBackstrokeTime(best50mBackstrokeTime);
    }

    /**
     * @return the breaststroke time
     */
    public double getBest50mBreaststrokeTime() {
        return this.times.getBest50mBreaststrokeTime();
    }

    /**
     * Set the breaststroke time.
     * @param best50mBreaststrokeTime Best breaststroke time
     */
    public void setBest50mBreaststrokeTime(double best50mBreaststrokeTime) {
        this.times.setBest50mBreaststrokeTime(best50mBreaststrokeTime);
    }

    /**
     * @return the butterfly time
     */
    public double getBest50mButterflyTime() {
        return this.times.getBest50mButterflyTime();
    }

    /**
     * Set the butterfly time.
     * @param best50mButterflyTime Best butterfly time
     */
    public void setBest50mButterflyTime(double best50mButterflyTime) {
        this.times.setBest50mButterflyTime(best50mButterflyTime);
    }

    /**
     * @return the freestyle time
     */
    public double getBest50mFreestyleTime() {
        return this.times.getBest50mFreestyleTime();
    }

    /**
     * Set the freestyle time.
     * @param best50mFreestyleTime Best freestyle time
     */
    public void setBest50mFreestyleTime(double best50mFreestyleTime) {
        this.times.setBest50mFreestyleTime(best50mFreestyleTime);
    }
}
