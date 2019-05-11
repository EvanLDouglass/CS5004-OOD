/**
 * Class Email represents an email address with login name and domain.
 *
 * @author evandouglass
 */
public class Email {

    private String login;
    private String domain;

    /**
     * Constructor for class Email
     * @param login the user login (i.e. janedoe in janedoe@gmail.com)
     * @param domain the domain of the email (i.e. gmail.com)
     */
    public Email(String login, String domain) {
        this.login = login;
        this.domain = domain;
    }

    /**
     * Getter for login field.
     * @return the login name
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Getter for domain field.
     * @return the domain
     */
    public String getDomain() {
        return this.domain;
    }
}
