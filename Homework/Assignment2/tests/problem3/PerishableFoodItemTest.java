package problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PerishableFoodItemTest {

  private PerishableFoodItem item;

  @Before
  public void setUp() {
    item = new PerishableFoodItem("Perishable",
        34.5,
        90,
        10,
        40);
  }

  @Test
  public void testConstructorAndGetters() {
    assertEquals(10, (int) item.getOrderDate());
    assertEquals(40, (int) item.getExpirationDate());

    // Zero order date
    item = new PerishableFoodItem("Perishable",
        34.5,
        90,
        0,
        1);
    assertEquals(0, (int) item.getOrderDate());
    assertEquals(1, (int) item.getExpirationDate());

    // Negative order date, zero exp. date
    // Negatives allowed in the event that something was ordered prior to
    // deploying this system.
    item = new PerishableFoodItem("Perishable",
        34.5,
        90,
        -1,
        0);
    assertEquals(-1, (int) item.getOrderDate());
    assertEquals(0, (int) item.getExpirationDate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOrderLessThanExpiration() {
    PerishableFoodItem item = new PerishableFoodItem("Perishable",
        34.5,
        90,
        10,
        9);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOrderEqualToExpiration() {
    PerishableFoodItem item = new PerishableFoodItem("Perishable",
        34.5,
        90,
        10,
        10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTooManyItems() {
    PerishableFoodItem item = new PerishableFoodItem("Perishable",
        34.5,
        101,
        10,
        10);
  }

  @Test
  public void toString1() {
    String expected = "'Perishable', $34.50/unit, 90 in stock, ordered on day 10, expires on day 40";
    assertEquals(expected, item.toString());
  }

  @Test
  public void equals1() {
    PerishableFoodItem item2 = new PerishableFoodItem("Perishable",
        34.5,
        90,
        10,
        40);
    assertEquals(item, item2);

    item2 = new PerishableFoodItem("Perishable",
        34.5,
        90,
        0,
        40);
    assertNotEquals(item, item2);

    item2 = new PerishableFoodItem("Perishable",
        34.5,
        90,
        10,
        45);
    assertNotEquals(item, item2);
  }
}