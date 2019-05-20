package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

  private Person p;

  @Before
  public void setUp() {
    p = new Person("Evan", "Douglass", "123 4th St", "someone@gmail.com");
  }

  @Test
  public void testInitAndGetters() {
    assertEquals("Evan", p.getFirstName());
    assertEquals("Douglass", p.getLastName());
    assertEquals("123 4th St", p.getAddress());
    assertEquals("someone@gmail.com", p.getEmail());
  }

  @Test
  public void toString1() {
    String expected = String.format("Person{Evan Douglass\n\t123 4th St\n\tsomeone@gmail.com}");

    assertEquals(expected, p.toString());
  }

  @Test
  public void equals1() {
    Person p2 = new Person("Evan", "Douglass", "123 4th St", "someone@gmail.com");
    assertTrue(p.equals(p2));

    p2 = new Person("Evan", "Douglass", "", "");
    assertFalse(p.equals(p2));
  }
}