package Problem3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for class Account.
 *
 * @author evandouglass
 */
public class AccountTest {

  @Test
  public void deposit() {
    // Main account
    Account acct = new Account("Evan", "Douglass");
    acct = acct.deposit(new Amount(100, 50));
    // Equality test account
    Amount amtTest = new Amount(100, 50);
    Account acctTest = new Account("Evan", "Douglass", amtTest);
    assertEquals(acctTest, acct);

    acctTest.setBalance(new Amount(200, 50));
    acct = acct.deposit(new Amount(100, 0));
    assertEquals(acctTest, acct);

    // deposit nothing
    acct = acct.deposit(new Amount());
    assertEquals(acctTest, acct);
  }

  @Test
  public void withdraw() {
    // Main account
    Account acct = new Account("Evan", "Douglass", new Amount(500, 0));
    acct = acct.withdraw(new Amount(100, 0));

    // Equality test account
    Amount amtTest = new Amount(400, 0);
    Account acctTest = new Account("Evan", "Douglass", amtTest);
    assertEquals(acctTest, acct);

    acct = acct.withdraw(new Amount(0, 50));
    amtTest = new Amount(399, 50);
    acctTest.setBalance(amtTest);
    assertEquals(acctTest, acct);

    acct = acct.withdraw(new Amount(50, 50));
    amtTest = new Amount(349, 0);
    acctTest.setBalance(amtTest);
    assertEquals(acctTest, acct);

    // Test overdraw
    acct = acct.withdraw(new Amount(1000, 0));
    amtTest = new Amount();
    acctTest.setBalance(amtTest);
    assertEquals(acctTest, acct);
    acct = acct.withdraw(new Amount(0, 1));
    assertEquals(acctTest, acct);
  }

  @Test
  public void toString1() {
    Account acct = new Account("Evan", "Douglass");
    String expected = "Account{name='Evan Douglass', bal=Amount{$0.00}}";
    assertEquals(expected, acct.toString());

    acct.setBalance(new Amount(100000, 55));
    expected = "Account{name='Evan Douglass', bal=Amount{$100000.55}}";
    assertEquals(expected, acct.toString());

    acct = new Account("Bill", "Gates", new Amount(1000000000, 0));
    expected = "Account{name='Bill Gates', bal=Amount{$1000000000.00}}";
    assertEquals(expected, acct.toString());
  }

  @Test
  public void equals1() {
    Account acct1 = new Account("Evan", "Douglass");
    Account acct2 = new Account("Evan", "Douglass");
    assertEquals(acct1, acct2);

    acct1.setBalance(new Amount(500, 0));
    assertNotEquals(acct1, acct2);
    acct2.setBalance(new Amount(500, 0));
    assertEquals(acct1, acct2);
  }

  @Test
  public void getBalance_setBalance() {
    Account acct = new Account("Evan", "Douglass");
    Amount amt = new Amount();
    assertEquals(amt, acct.getBalance());

    acct.setBalance(new Amount(200, 0));
    amt.setDollars(200);
    assertEquals(amt, acct.getBalance());
  }
}