package Problem1;

/**
 * Class SwimTimes represents a swimmer's best time for several different kinds of races.
 */
public class SwimTimes {
    private double best50mBackstrokeTime;
    private double best50mBreaststrokeTime;
    private double best50mButterflyTime;
    private double best50mFreestyleTime;

    /**
     * Primary constructor for the SwimTimes class
     *
     * @param best50mBackstrokeTime Best backstroke time
     * @param best50mBreaststrokeTime Best Breaststroke time
     * @param best50mButterflyTime Best Butterfly time
     * @param best50mFreestyleTime Best Freestyle time
     */
    public SwimTimes(double best50mBackstrokeTime, double best50mBreaststrokeTime, double best50mButterflyTime, double best50mFreestyleTime) {
        this.best50mBackstrokeTime = best50mBackstrokeTime;
        this.best50mBreaststrokeTime = best50mBreaststrokeTime;
        this.best50mButterflyTime = best50mButterflyTime;
        this.best50mFreestyleTime = best50mFreestyleTime;
    }

    /**
     * Basic constructor for SwimTime class. Defaults all values to -1.0
     */
    public SwimTimes() {
        this(-1.0, -1.0, -1.0, -1.0);
    }

    /**
     * @return the backstroke time
     */
    public double getBest50mBackstrokeTime() {
        return best50mBackstrokeTime;
    }

    /**
     * Set the backstroke time.
     * @param best50mBackstrokeTime Best backstroke time
     */
    public void setBest50mBackstrokeTime(double best50mBackstrokeTime) {
        this.best50mBackstrokeTime = best50mBackstrokeTime;
    }

    /**
     * @return the breaststroke time
     */
    public double getBest50mBreaststrokeTime() {
        return best50mBreaststrokeTime;
    }

    /**
     * Set the breaststroke time.
     * @param best50mBreaststrokeTime Best breaststroke time
     */
    public void setBest50mBreaststrokeTime(double best50mBreaststrokeTime) {
        this.best50mBreaststrokeTime = best50mBreaststrokeTime;
    }

    /**
     * @return the butterfly time
     */
    public double getBest50mButterflyTime() {
        return best50mButterflyTime;
    }

    /**
     * Set the butterfly time.
     * @param best50mButterflyTime Best butterfly time
     */
    public void setBest50mButterflyTime(double best50mButterflyTime) {
        this.best50mButterflyTime = best50mButterflyTime;
    }

    /**
     * @return the freestyle time
     */
    public double getBest50mFreestyleTime() {
        return best50mFreestyleTime;
    }

    /**
     * Set the freestyle time.
     * @param best50mFreestyleTime Best freestyle time
     */
    public void setBest50mFreestyleTime(double best50mFreestyleTime) {
        this.best50mFreestyleTime = best50mFreestyleTime;
    }
}
