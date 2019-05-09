/**
 * Represents an Author	with their details--name, email	and	physical address.
 *
 * @author evandouglass
 */
public class Author {

    private Person name;
    private Email email;
    private Address address;

    /**
     * Creates a new author given the author's name, email and address as strings.
     *
     * @param name the author's name
     * @param email the author's email address
     * @param address the authors physical address
     */
    public Author(Person name, Email email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    /**
     * @return the name
     */
    public Person getPerson() {
        return this.name;
    }

    /**
     * @return the email
     */
    public Email getEmail() {
        return this.email;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return this.address;
    }
}
