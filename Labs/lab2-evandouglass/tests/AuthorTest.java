import static org.junit.Assert.assertEquals;

import problem1.Author;

/**
 * Tests for Author class.
 */
public class AuthorTest {

  private Author jane;

  /**
   * Initializes the jane field.
   */
  @org.junit.Before
  public void setUp() {
    this.jane = new Author("Jane Doe", "j@a.com", "222 Main St, Seattle, WA, 98980");
  }

  /**
   * Tests getName.
   */
  @org.junit.Test
  public void getName() {
    assertEquals("Jane Doe", jane.getName());
  }

  /**
   * Tests getEmail.
   */
  @org.junit.Test
  public void getEmail() {
    assertEquals("j@a.com", jane.getEmail());
  }

  /**
   * Tests getAddress.
   */
  @org.junit.Test
  public void getAddress() {
    assertEquals("222 Main St, Seattle, WA, 98980", jane.getAddress());
  }
}