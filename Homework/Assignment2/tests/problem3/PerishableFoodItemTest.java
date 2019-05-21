package problem3;

import static org.junit.Assert.*;

import org.junit.Test;

public class PerishableFoodItemTest {

  @Test
  public void testConstructorAndGetters() {
    PerishableFoodItem item = new PerishableFoodItem("Perishable",
        34.5,
        90,
        10,
        40);
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
}