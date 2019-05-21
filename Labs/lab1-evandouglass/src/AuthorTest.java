import static org.junit.Assert.*;

public class AuthorTest {
    private Person person;
    private Email email;
    private Address address;
    private Author author;

    @org.junit.Before
    public void setUp() throws Exception {
        person = new Person("Evan", "Douglass");
        email = new Email("evandoug90", "gmail.com");
        address = new Address("2121", "6th Ave", "Seattle", "WA", 98121, "USA");
        author = new Author(person, email, address);
    }

    @org.junit.Test
    public void getPerson() throws Exception {
        //TestCase.fail("Not yet implemented");
        assertEquals(person, author.getPerson());
        assertEquals("Evan", author.getPerson().getFirst());
        assertEquals("Douglass", author.getPerson().getLast());
    }

    @org.junit.Test
    public void getEmail() throws Exception {
        //TestCase.fail("Not yet implemented");
        assertEquals(email, author.getEmail());
        assertEquals("evandoug90", author.getEmail().getLogin());
        assertEquals("gmail.com", author.getEmail().getDomain());
    }

    @org.junit.Test
    public void getAddress() throws Exception {
        //TestCase.fail("Not yet implemented");
        assertEquals(address, author.getAddress());
        assertEquals("2121", author.getAddress().getStreetNum());
        assertEquals("6th Ave", author.getAddress().getStreetName());
        assertEquals("Seattle", author.getAddress().getCity());
        assertEquals("WA", author.getAddress().getState());
        assertEquals("USA", author.getAddress().getCountry());
        assertEquals(98121, author.getAddress().getZip());
    }
}