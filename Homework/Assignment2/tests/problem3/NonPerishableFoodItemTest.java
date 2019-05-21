package problem3;

import static org.junit.Assert.*;

import org.junit.Test;

public class NonPerishableFoodItemTest {

  @Test(expected = IllegalArgumentException.class)
  public void testTooManyItems() {
    NonPerishableFoodItem item = new NonPerishableFoodItem(
        "Evan",
        50.0,
        251
    );
  }
}