package Problem3;

/**
 * Class Account represents a basic bank account. Accounts cannot be transferred
 * to other people once created (no getters/setters for account holder name).
 *
 * @author evandouglass
 */
public class Account {
    private String acctHolderFirstName;
    private String getAcctHolderLastName;
    private Amount balance;

    /**
     * Detailed constructor for class Account.
     * @param firstName account holder's first name
     * @param lastName account holder's last name
     * @param balance the balance of the account
     */
    public Account(String firstName, String lastName, Amount balance) {
        this.acctHolderFirstName = firstName;
        this.getAcctHolderLastName = lastName;
        this.balance = balance;
    }

    /**
     * Basic constructor for class Account.
     * @param firstName account holder's first name
     * @param lastName account holder's last name
     */
    public Account(String firstName, String lastName) {
        this.acctHolderFirstName = firstName;
        this.getAcctHolderLastName = lastName;
        this.balance = new Amount();  // zero valued
    }

    /* ===== Methods ===== */

    /**
     * deposit adds the given amount into the current account balance
     * @param depositAmount the amount to deposit
     */
    public void deposit(Amount depositAmount) {
        this.balance = this.balance.add(depositAmount);
    }

    /**
     * withdraw subtracts the given amount from the current account balance.
     * If the withdraw amount is greater than the account balance, the balance will go
     * to zero.
     * @param withdrawAmount the amount to withdraw
     */
    public void withdraw(Amount withdrawAmount) {
        this.balance = this.balance.subtract(withdrawAmount);
    }

    /* ===== Overrides ===== */

    @Override
    public String toString() {
        return "Account{" +
                "name='" + acctHolderFirstName + " " + getAcctHolderLastName + '\'' +
                ", bal=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return acctHolderFirstName.equals(account.acctHolderFirstName) &&
                getAcctHolderLastName.equals(account.getAcctHolderLastName) &&
                balance.equals(account.balance);
    }

    /* ===== Getters/Setters ===== */

    /**
     * @return The account balance as an Amount
     */
    public Amount getBalance() {
        return balance;
    }

    /**
     * @param balance the new account balance
     */
    public void setBalance(Amount balance) {
        this.balance = balance;
    }
}
