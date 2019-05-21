package problem2;

/**
 * Class GiftCard represents a simple gift card. A GiftCard has a number, an owner and a balance.
 *
 * @author evandouglass
 */
public class GiftCard {

  public static final Integer CARD_NUM_LEN = 9;

  private String cardNumber;  // using String to easily allow leading zeros
  private Person cardOwner;
  private Amount balance;

  /**
   * Constructor for class GiftCard.
   *
   * @param cardNumber a 9-digit integer
   * @param cardOwner a <pre>Person</pre> who owns the card
   * @param balance the monetary balance on the card
   */
  public GiftCard(String cardNumber, Person cardOwner, Amount balance) {
    this.validateCardNumber(cardNumber);
    this.cardNumber = cardNumber;
    this.cardOwner = cardOwner;
    this.balance = balance;
  }

  /* ===== Methods ===== */

  /**
   * Adds between $1 and $200 to this <pre>GiftCard</pre> as specified in the given
   * <pre>Deposit</pre>.
   *
   * @param newGift a <pre>Deposit</pre> object
   * @return a new <pre>GiftCard</pre> with the deposit amount added to the original balance.
   */
  public GiftCard depositGift(Deposit newGift) throws IllegalArgumentException {
    this.validateDeposit(newGift);
    Amount newAmmt = balance.add(newGift.getAmount());
    return new GiftCard(cardNumber, cardOwner, newAmmt);
  }

  /**
   * Checks if the given deposit is valid (i.e. going to the right <pre>GiftCard</pre>.
   *
   * @param dep a <pre>Deposit</pre> object
   */
  private void validateDeposit(Deposit dep) throws IllegalArgumentException {
    if (!dep.getRecipientFirstName().equals(cardOwner.getFirstName())) {
      throw new IllegalArgumentException("recipient first name does not match");

    } else if (!dep.getRecipientLastName().equals(cardOwner.getLastName())) {
      throw new IllegalArgumentException("recipient last name does not match");

    } else if (!dep.getCardNumber().equals(cardNumber)) {
      throw new IllegalArgumentException("card numbers don't match");
    }
  }

  /**
   * Checks if the given card number is a 9-digit integer.
   *
   * @param number a card number to test
   */
  private void validateCardNumber(String number) throws IllegalArgumentException {
    number = number.trim();
    Integer len = number.length();
    if (len < CARD_NUM_LEN) {
      throw new IllegalArgumentException("not enough digits in card number");

    } else if (len > CARD_NUM_LEN) {
      throw new IllegalArgumentException("too many digits in card number");

    } else if (!this.isDigit(number)) {
      throw new IllegalArgumentException("given string is not a number");
    }
  }

  /**
   * Tests if a given string is all digits. Assumes whitespace has been trimmed already.
   *
   * @param str a string to test
   * @return <pre>true</pre> if the string is made up of only digits, <pre>false</pre> otherwise.
   */
  private boolean isDigit(String str) {
    boolean digit = true;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (!Character.isDigit(c)) {
        digit = false;
        break;
      }
    }
    return digit;
  }

  /* ===== Overrides ===== */

  /**
   * Returns a string representation of a GiftCard.
   *
   * @return a string representation of a GiftCard
   */
  @Override
  public String toString() {
    return String.format("GiftCard{%s\n\t%s %s\n\t%s\n}",
        cardNumber, cardOwner.getFirstName(), cardOwner.getLastName(), balance);
  }

  /**
   * Tests equality of two objects.
   *
   * @param o an object to test
   * @return <pre>true</pre> if objects are equal, <pre>false</pre> otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GiftCard giftCard = (GiftCard) o;
    return cardNumber.equals(giftCard.cardNumber) &&
        cardOwner.equals(giftCard.cardOwner) &&
        balance.equals(giftCard.balance);
  }

  /* ===== Getters ===== */

  /**
   * Gets the card number.
   *
   * @return a 9-digit card number as an Integer
   */
  public String getCardNumber() {
    return cardNumber;
  }

  /**
   * Gets the card owner.
   *
   * @return a <pre>Person</pre> object
   */
  public Person getCardOwner() {
    return cardOwner;
  }

  /**
   * Gets the amount of money on the card.
   *
   * @return the amount of money on the card
   */
  public Amount getBalance() {
    return balance;
  }
}
