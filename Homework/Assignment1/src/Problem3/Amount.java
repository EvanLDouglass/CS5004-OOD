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

    /**
     * Adds the given amount and returns the value without side affects.
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

    @Override
    public String toString() {
        return String.format("Amount{$%d.%02d}", this.dollars, this.cents);
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
        if (cents < 0 ) {
            this.cents = 0;
        } else if (cents > 99) {
            this.cents = cents % 100;
            this.dollars += (cents / 100);
        } else {
            this.cents = cents;
        }
    }
}
