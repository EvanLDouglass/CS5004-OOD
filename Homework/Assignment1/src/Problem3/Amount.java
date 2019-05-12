package Problem3;

/**
 * Class Amount represents an amount in a bank account.
 * The value of the account cannot be negative.
 *
 * @author evandouglass
 */
public class Amount {
    private int dollars;
    private int cents;

    /**
     * Basic constructor for class Amount.
     */
    public Amount() {
        this(0, 0);
    }

    /**
     * Primary constructor for class Amount.
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
    // TODO: Finish Implementations
    /**
     * Adds the given amount and returns the value without side affects.
     * @param other an amount to add
     * @return the current account value + the other account value
     */
    public Amount add(Amount other) {
        return new Amount();
    }

    /**
     * Subtracts the given amount and returns the value without side affects.
     * @param other an amount to subtract
     * @return the current account value - the other account value
     */
    public Amount subtract(Amount other) {
        return new Amount();
    }

    /* ===== Overrides ===== */

    @Override
    public String toString() {
        return "Amount{" +
                "$" + dollars +
                "." + cents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return dollars == amount.dollars &&
                cents == amount.cents;
    }

    /* ===== Getters and Setters ===== */

    /**
     * Gets the dollars in the account.
     * @return the amount of dollars in the account
     */
    public int getDollars() {
        return dollars;
    }

    /**
     * Sets the dollar amount in the account.
     * @param dollars the new amount of dollars in the account
     */
    public void setDollars(int dollars) {
        if (dollars < 0) {
            dollars = 0;
        }
        this.dollars = dollars;
    }

    /**
     * Gets the cents value in the account.
     * @return the cents value in the account
     */
    public int getCents() {
        return cents;
    }

    /**
     * Sets the cents value in the account.
     * @param cents the new cents value
     */
    public void setCents(int cents) {
        this.cents = cents;
    }
}
