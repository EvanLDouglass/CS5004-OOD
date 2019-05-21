package problem2;

/**
 * Class Deposit represents an <em>intended</em> deposit to a <pre>GiftCard</pre> object. A
 * <pre>Deposit</pre> consists of an amount to deposit as well as information about the card to
 * deposit into. The amount of a <pre>Deposit</pre> can only be in the range [$1.00, $200.00].
 *
 * @author evandouglass
 */
public class Deposit {
  public static final Amount MIN_AMOUNT = new Amount(1, 0);
  public static final Amount MAX_AMOUNT = new Amount(200, 0);

  private Amount amount;
  private String recipientFirstName;
  private String recipientLastName;
  private String cardNumber;

  /**
   * Constructor for class Deposit.
   *
   * @param amount an amount to deposit
   * @param recipientFirstName card holder's first name
   * @param recipientLastName card holder's last name
   * @param cardNumber number on the card
   */
  public Deposit(Amount amount, String recipientFirstName, String recipientLastName,
      String cardNumber) {
    this.validateAmount(amount);
    this.amount = amount;
    this.recipientFirstName = recipientFirstName;
    this.recipientLastName = recipientLastName;
    this.cardNumber = cardNumber;
  }

  /* ===== Methods ===== */

  /**
   * Ensures the amount given is between the minimum and maximum allowed values.
   *
   * @param amount an amount to test
   * @throws IllegalArgumentException
   */
  private void validateAmount(Amount amount) throws IllegalArgumentException {
    Integer givenTotalCents = (amount.getDollars() * 100) + amount.getCents();
    Integer minTotalCents = (MIN_AMOUNT.getDollars() * 100) + MIN_AMOUNT.getCents();
    Integer maxTotalCents = (MAX_AMOUNT.getDollars() * 100) + MAX_AMOUNT.getCents();

    if (givenTotalCents < minTotalCents) {
      throw new IllegalArgumentException("amount must be at least $1.00");
    } else if (givenTotalCents > maxTotalCents) {
      throw new IllegalArgumentException("amount must be at most $200.00");
    }
  }

  /* ===== Overrides ===== */

  /**
   * Returns a string representation of a <pre>Deposit</pre>.
   *
   * @return a string representation of a <pre>Deposit</pre>
   */
  @Override
  public String toString() {
    return "Deposit{" + amount + " to card:\n" + cardNumber + "\n" + recipientFirstName + " "
        + recipientLastName + "\n}";
  }

  /**
   * Determines equality of an object to a Deposit
   *
   * @param o the other object
   * @return <pre>true</pre>> if equal, <pre>false</pre> if not.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Deposit deposit = (Deposit) o;
    return amount.equals(deposit.amount) &&
        recipientFirstName.equals(deposit.recipientFirstName) &&
        recipientLastName.equals(deposit.recipientLastName) &&
        cardNumber.equals(deposit.cardNumber);
  }

  /* ===== Getters ===== */

  /**
   * Get deposit amount.
   *
   * @return the deposit amount
   */
  public Amount getAmount() {
    return amount;
  }

  /**
   * Get first name of card owner.
   *
   * @return card owner's first name
   */
  public String getRecipientFirstName() {
    return recipientFirstName;
  }

  /**
   * Get last name o card owner.
   *
   * @return card owner's last name
   */
  public String getRecipientLastName() {
    return recipientLastName;
  }

  /**
   * Get number on card.
   *
   * @return the card number
   */
  public String getCardNumber() {
    return cardNumber;
  }
}