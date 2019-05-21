package problem3;

import static org.junit.Assert.*;

import org.junit.Test;

public class PerishableFoodItemTest {

  @Test
  public void testGetters() {
    PerishableFoodItem item = new PerishableFoodItem("Perishable",
        34.5,
        90,
        10,
        40);
    assertEquals(10, (int) item.getOrderDate());
    assertEquals(40, (int) item.getExpirationDate());
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