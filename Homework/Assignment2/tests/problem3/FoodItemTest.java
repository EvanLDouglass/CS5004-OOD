package problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FoodItemTest {
  private FoodItem item;

  @Before
  public void setUp() {
    item = new FoodItem("Food", 34.2222, 90);
  }

  @Test
  public void testGetters() {
    assertEquals("Food", item.getName());
    assertEquals(34.2222, item.getPricePerUnit(), 0);
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

  @Test
  public void toString1() {
    String expected = "'Food', $34.22/unit, 90 in stock";
    assertEquals(expected, item.toString());
  }

  @Test
  public void equals1() {
    FoodItem item2 = new FoodItem("Food", 34.2222, 90);
    assertEquals(item, item2);

    item2 = new FoodItem("", 34.2222, 90);
    assertNotEquals(item, item2);

    item2 = new FoodItem("Food", 34.22, 90);
    assertNotEquals(item, item2);

    item2 = new FoodItem("Food", 34.2222, 9);
    assertNotEquals(item, item2);
  }
}