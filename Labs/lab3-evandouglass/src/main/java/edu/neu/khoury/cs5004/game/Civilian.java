package edu.neu.khoury.cs5004.game;

import java.util.Objects;

/**
 * One of the two main types of pieces in this game. The purpose of a Civilian is to generate, and
 * keep track of, wealth. There are two types of Civilian: a Farmer and an Engineer.
 *
 * @author evandouglass
 */
public abstract class Civilian extends Pieces {

  public Wealth wealth;

  /**
   * Constructor for <pre>Civilian</pre>.
   *
   * @param name name of the <pre>Civilian</pre>
   * @param age age of the <pre>Civilian</pre>
   * @param wealth wealth of the <pre>Civilian</pre> as a Double
   */
  public Civilian(Name name, Age age, Double wealth) throws Exception {
    super(name, age);
    this.wealth = new Wealth(wealth);
  }

  /**
   * Adds some amount to this Civilian's wealth.
   *
   * @param amount an amount to add
   */
  public void addToWealth(Double amount) throws Exception {
    wealth = new Wealth(wealth.getWealth() + amount);
  }

  /**
   * Subtracts some amount from this Civilian's wealth.
   *
   * @param amount an amount to subtract
   */
  public void decreaseWealth(Double amount) throws Exception {
    wealth = new Wealth(wealth.getWealth() - amount);
  }

  /**
   * Test equality of this object to another.
   *
   * @param o the other object
   * @return <pre>true</pre> if equal, else <pre>false</pre>
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Civilian civilian = (Civilian) o;
    return wealth.equals(civilian.wealth);
  }

  /**
   * Creates a hash code from the object.
   *
   * @return a hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(wealth);
  }

  /**
   * Getter for wealth.
   *
   * @return wealth
   */
  public Wealth getWealth() {
    return wealth;
  }
}
