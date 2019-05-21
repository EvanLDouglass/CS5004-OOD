/**
 * Class Address represents a physical address, such as a mailing address.
 *
 * @author evandouglass
 */
public class Address {

    private String streetNum;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private int zip;

    public Address(String streetNum, String streetName, String city, String state, int zip, String country) {
        this.streetNum = streetNum;
        this.streetName = streetName;
        this. city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
    }

    /**
     * @return the street number
     */
    public String getStreetNum() {
        return this.streetNum;
    }

    /**
     * @return the street name
     */
    public String getStreetName() {
        return this.streetName;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return this.state;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * @return the zip
     */
    public int getZip() {
        return this.zip;
    }
}
