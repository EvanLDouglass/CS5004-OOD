package problem2;

/*
 * This class was directly copy/pasted from Assignment 1, problem 3. Some
 * functionality has been changed, so tests for this class have been rewritten for
 * the package.
 *
 * I chose to copy and paste this class instead of importing it because
 * we are not including project dependencies in our GitHub uploads, so it
 * should be easier for the TAs to compile this package, as they won't have
 * to add the dependency for my Assignment1 module themselves.
 */

/**
 * Class Amount represents an amount of money in dollars and cents. The value of the amount cannot
 * be negative and cents is always between 0 and 99, inclusive.
 *
 * @author evandouglass
 */
public class Amount {

  private Integer dollars;
  private Integer cents;

  /**
   * Basic constructor for class Amount.
   */
  public Amount() {
    this(0, 0);
  }

  /**
   * Primary constructor for class Amount.
   *
   * @param dollars the amount of dollars
   * @param cents the amount of cents
   */
  public Amount(int dollars, int cents) {
    // Validate dollars
    if (dollars < 0) {
      // negative values revert to zero
      dollars = 0;
    }
    // Validate cents
    if (cents < 0) {
      cents = 0;
    } else if (cents > 99) {
      // convert anything over 99 into dollars
      dollars += (cents / 100);
      cents = cents % 100;
    }

    this.dollars = dollars;
    this.cents = cents;
  }

  /* ===== Methods ===== */

  /**
   * Adds the given amount and returns the value without side affects.
   *
   * @param other an amount to add
   * @return the current account value + the other account value
   */
  public Amount add(Amount other) {
    // Get total cents in each amount and sum
    int thisCents, otherCents;
    thisCents = this.cents + (this.dollars * 100);
    otherCents = other.getCents() + (other.getDollars() * 100);
    int totalCents = thisCents + otherCents;

    // divide back into dollars and cents;
    int cents = totalCents % 100;
    int dollars = totalCents / 100;
    return new Amount(dollars, cents);
  }

  /**
   * Subtracts the given amount and returns the value without side affects.
   *
   * @param other an amount to subtract
   * @return the current account value - the other account value
   */
  public Amount subtract(Amount other) {
    // Get total cents in each amount and subtract
    int thisCents, otherCents;
    thisCents = this.cents + (this.dollars * 100);
    otherCents = other.getCents() + (other.getDollars() * 100);
    int totalCents = thisCents - otherCents;

    // Check if other was more than starting amount
    if (totalCents < 0) {
      totalCents = 0;
    }

    // Divide back to dollars and cents
    int cents = totalCents % 100;
    int dollars = totalCents / 100;
    return new Amount(dollars, cents);
  }

  /* ===== Overrides ===== */

  /**
   * Creates a human readable representation of an Amount.
   *
   * @return the Amount as a string
   */
  @Override
  public String toString() {
    return String.format("Amount{$%d.%02d}", this.dollars, this.cents);
  }

  /**
   * Tests equality of another Amount object.
   *
   * @param o the other object
   * @return true if the dollars and cents of each Amount are the same, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Amount amount = (Amount) o;
    return dollars.equals(amount.dollars) &&
        cents.equals(amount.cents);
  }

  /* ===== Getters ===== */

  /**
   * Gets the dollars in the account.
   *
   * @return the amount of dollars in the account
   */
  public Integer getDollars() {
    return dollars;
  }

  /**
   * Gets the cents value in the account.
   *
   * @return the cents value in the account
   */
  public Integer getCents() {
    return cents;
  }
}
