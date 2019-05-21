package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GiftCardTest {

  private GiftCard giftCard;
  private Person owner;
  private Amount balance;

  @Before
  public void setUp() {
    owner = new Person("Evan", "Douglass", "", "");
    balance = new Amount(50, 0);
    giftCard = new GiftCard("000456789", owner, balance);
  }

  /* ===== Bad Card Tests ===== */

  @Test(expected = IllegalArgumentException.class)
  public void cardNumberTooLong() {
    giftCard = new GiftCard("0123456789", owner, balance);  // String length = 10
  }

  @Test(expected = IllegalArgumentException.class)
  public void cardNumberTooShort() {
    giftCard = new GiftCard("01234567", owner, balance);  // String length = 8
  }

  @Test(expected = IllegalArgumentException.class)
  public void cardNumberNonNumeric() {
    giftCard = new GiftCard("Hello You", owner, balance);  // String length = 9
  }

  /* ===== Deposit Tests ===== */

  @Test
  public void depositGift() {
    Deposit deposit = new Deposit(balance, "Evan", "Douglass", "000456789");
    giftCard = giftCard.depositGift(deposit);
    assertEquals(new Amount(100, 0), giftCard.getBalance());
  }

  @Test(expected = IllegalArgumentException.class)
  public void depositGiftBadFirstName() {
    Deposit deposit = new Deposit(balance, "van", "Douglass", "000456789");
    giftCard = giftCard.depositGift(deposit);
  }

  @Test(expected = IllegalArgumentException.class)
  public void depositGiftBadLastName() {
    Deposit deposit = new Deposit(balance, "Evan", "ouglass", "000456789");
    giftCard = giftCard.depositGift(deposit);
  }

  @Test(expected = IllegalArgumentException.class)
  public void depositGiftBadCardNumber() {
    Deposit deposit = new Deposit(balance, "Evan", "Douglass", "0000456789");
    giftCard = giftCard.depositGift(deposit);
  }

  /* ===== Rest of Tests ===== */

  @Test
  public void toString1() {
    String expected = "GiftCard{000456789\n\t" +
        "Evan Douglass\n\t" +
        "Amount{$50.00}\n}";
    assertEquals(expected, giftCard.toString());
  }

  @Test
  public void equals1() {
    Person p = new Person("Evan", "Douglass", "", "");
    Amount a = new Amount(50, 0);
    GiftCard gift = new GiftCard("000456789", p, a);
    assertTrue(giftCard.equals(gift));

    a = new Amount(100, 0);
    gift = new GiftCard("000456789", p, a);
    assertFalse(giftCard.equals(gift));
  }

  @Test
  public void testGetters() {
    assertEquals("000456789", giftCard.getCardNumber());
    assertEquals(owner, giftCard.getCardOwner());
    assertEquals(balance, giftCard.getBalance());
  }
}