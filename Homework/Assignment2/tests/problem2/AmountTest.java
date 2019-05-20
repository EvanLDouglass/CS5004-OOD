package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * Tests for class Amount.
 *
 * @author evandouglass
 */
public class AmountTest {

  @Test
  public void setUpAndTest() {
    Amount a = new Amount(-100, -100);
    assertEquals(new Amount(0, 0), a);

    a = new Amount(-100, 45);
    assertEquals(new Amount(0, 45), a);

    a = new Amount(-100, 500);
    assertEquals(new Amount(5, 0), a);

    a = new Amount(100, 500);
    assertEquals(new Amount(105, 0), a);

    a = new Amount(100, 550);
    assertEquals(new Amount(105, 50), a);
  }

  @Test
  public void add() {
    Amount a1 = new Amount();  // Zeroed
    assertEquals(new Amount(), a1.add(new Amount()));
    Amount a2 = new Amount(50, 10);
    assertEquals(a2, a1.add(a2));

    // Swap parameters
    assertEquals(a2, a2.add(a1));
    // Add to self
    assertEquals(new Amount(100, 20), a2.add(a2));

    // 123.45 + 200.50 = 323.95
    Amount a3 = new Amount(123, 45).add(new Amount(200, 50));
    assertEquals(new Amount(323, 95), a3);
  }

  @Test
  public void subtract() {
    Amount a1 = new Amount();  // Zeroed
    assertEquals(new Amount(), a1.subtract(new Amount()));
    Amount a2 = new Amount(50, 10);
    assertEquals(a2, a2.subtract(a1));

    // Subtract from self
    assertEquals(new Amount(), a2.subtract(a2));

    // 123.45 - 20.50 = 102.95
    Amount a3 = new Amount(123, 45).subtract(new Amount(20, 50));
    assertEquals(new Amount(102, 95), a3);

    // Test subtracting bigger numbers
    a1 = new Amount(500, 0);
    assertEquals(new Amount(), a2.subtract(a1));
    a2 = new Amount(0, 55000);
    assertEquals(new Amount(), a1.subtract(a2));
  }

  @Test
  public void toString1() {
    Amount a = new Amount();
    assertEquals("Amount{$0.00}", a.toString());
    a = a.add(new Amount(20, 56));
    assertEquals("Amount{$20.56}", a.toString());
    a = new Amount(24, 50);
    assertEquals("Amount{$24.50}", a.toString());
  }

  @Test
  public void equals1() {
    Amount a1 = new Amount();
    Amount a2 = new Amount();
    assertEquals(a1, a2);
    a2 = new Amount(30, 0);
    assertNotEquals(a1, a2);
    a1 = new Amount(30, 0);
    assertEquals(a1, a2);
  }

  @Test
  public void setAndGetCents() {
    Amount a = new Amount();
    assertEquals(0, (int) a.getCents());
    a = new Amount(40, 23);
    assertEquals(23, (int) a.getCents());
  }

  @Test
  public void setAndGetDollars() {
    Amount a = new Amount();
    assertEquals(0, (int) a.getDollars());
    a = new Amount(40, 23);
    assertEquals(40, (int) a.getDollars());
  }
}