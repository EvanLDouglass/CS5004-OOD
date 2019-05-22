package problem3;

import static org.junit.Assert.*;

import org.junit.Test;

public class FoodOrderingSystemTest {

  @Test
  public void testConstructor() {
    PerishableFoodItem[] pItems = new PerishableFoodItem[]{};
    NonPerishableFoodItem[] npItems = new NonPerishableFoodItem[]{};
    FoodOrderingSystem system = new FoodOrderingSystem(pItems, npItems);
    assertEquals(pItems, system.getPerishables());
    assertEquals(npItems, system.getNonPerishables());
  }

}