package Problem1;
/**
 * Class Swimmer contains information about a swimmer. This class is
 * used as a part of Problem 1.
 */
public class Swimmer {
    private String firstName;
    private String lastName;
    private Double bestBackstroke50mTime;

    /**
     * Constructor that creates a new Swimmer object with the
     * specified first name, last name and best backstroke time.
     * @param firstName - swimmer's first name
     * @param lastName - swimmer's last name
     * @param bestBackstroke50mTime - best 50m backstroke time
     **/
    public Swimmer(String firstName, String lastName, Double bestBackstroke50mTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestBackstroke50mTime = bestBackstroke50mTime;
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
        this.bestBackstroke50mTime = -1.0;
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
     * Returns the swimmer's best backstroke time
     * @return - swimmer's best backstroke time
     */
    public Double getBestBackstroke50mTime() {
        return this.bestBackstroke50mTime;
    }

    /** Sets the swimmer's best backstroke time
     /@param time - swimmer's best backstroke time
     **/
    public void setBestBackstroke50mTime(Double time) {
        this.bestBackstroke50mTime = time;
    }
}
