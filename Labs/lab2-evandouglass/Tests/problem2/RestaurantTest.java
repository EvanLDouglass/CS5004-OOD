package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem3.Menu;

public class RestaurantTest {
  private Restaurant r;
  private Menu m;

  @Before
  public void setUp() {
    m = new Menu("Burgers", "Ice Cream", "Coke", "Rum and Coke");
    r = new Restaurant("The Golden Dragon", "1234 Mystery Ln. Seattle, WA 99999", true, m);
  }

  @Test
  public void getAndSetName() {
    assertEquals("The Golden Dragon", r.getName());
    r.setName("Shake Shack");
    assertEquals("Shake Shack", r.getName());
  }

  @Test
  public void getAndSetAddress() {
    assertEquals("1234 Mystery Ln. Seattle, WA 99999", r.getAddress());
    r.setAddress("Nowhere");
    assertEquals("Nowhere", r.getAddress());
  }

  @Test
  public void isOpen_setOpen() {
    assertTrue(r.isOpen());
    r.setOpen(false);
    assertFalse(r.isOpen());
  }

  @Test
  public void getAndSetMenu() {
    assertEquals(m, r.getMenu());
    m = new Menu("", "", "", "");
    r.setMenu(m);
    assertEquals(m, r.getMenu());
  }
}