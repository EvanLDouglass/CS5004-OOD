package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class DepositTest {

  private Deposit deposit;
  private Amount amount;

  @Before
  public void setUp() {
    amount = new Amount(50, 0);
    deposit = new Deposit(amount, "Evan",
        "Douglass", "123456789");
  }

  @Test(expected = IllegalArgumentException.class)
  public void amountTooLow() {
    amount = new Amount(0, 99);
    deposit = new Deposit(amount, "Evan", "Douglass",
        "123456789");
  }

  @Test(expected = IllegalArgumentException.class)
  public void amountTooHigh() {
    amount = new Amount(200, 1);
    deposit = new Deposit(amount, "Evan", "Douglass",
        "123456789");
  }

  @Test
  public void toString1() {
    String expected = "Deposit{Amount{$50.00} to card:\n123456789\nEvan Douglass\n}";
    assertEquals(expected, deposit.toString());
  }

  @Test
  public void equals1() {
    Amount a = new Amount(50, 0);
    Deposit d = new Deposit(a, "Evan",
        "Douglass", "123456789");
    assertEquals(deposit, d);

    d = new Deposit(a, "", "Douglass", "123456789");
    assertNotEquals(deposit, d);

    d = new Deposit(a, "Evan", "", "123456789");
    assertNotEquals(deposit, d);

    d = new Deposit(a, "Evan", "Douglass", "");
    assertNotEquals(deposit, d);

    a = new Amount(30, 50);
    d = new Deposit(a, "Evan", "Douglass", "123456789");
    assertNotEquals(deposit, d);
  }

  @Test
  public void testGetters() {
    assertEquals(amount, deposit.getAmount());
    assertEquals("Evan", deposit.getRecipientFirstName());
    assertEquals("Douglass", deposit.getRecipientLastName());
    assertEquals("123456789", deposit.getCardNumber());
  }
}