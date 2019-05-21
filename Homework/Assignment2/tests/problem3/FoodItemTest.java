package problem3;

import static org.junit.Assert.*;

import org.junit.Test;

public class FoodItemTest {

  @Test
  public void testGetters() {
    FoodItem item = new FoodItem("Food", 34.22, 90);
    assertEquals("Food", item.getName());
    assertEquals(34.22, item.getPricePerUnit(), 0);
    assertEquals(90, (int)item.getQuantity());

    item = new FoodItem("", 0.0, 0);
    assertEquals("", item.getName());
    assertEquals(0.0, item.getPricePerUnit(), 0);
    assertEquals(0, (int)item.getQuantity());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativePrice() {
    FoodItem item = new FoodItem("Evan", -0.1, 90);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeQuantity() {
    FoodItem item = new FoodItem("Evan", 1.0, -1);
  }
}