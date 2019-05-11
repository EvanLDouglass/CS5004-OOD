/**
 * Class Person represents a person, with fields for first name and last name.
 *
 * @author evandouglass
 */
public class Person {

    private String firstName;
    private String lastName;

    /**
     * Constructor for class Person
     * @param first the person's first name
     * @param last the person's last name
     */
    public Person(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    /**
     * @return the person's first name
     */
    public String getFirst() {
        return this.firstName;
    }

    /**
     * @return the person's last name
     */
    public String getLast() {
        return this.lastName;
    }
}
