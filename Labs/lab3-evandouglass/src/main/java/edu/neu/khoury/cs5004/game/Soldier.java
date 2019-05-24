package edu.neu.khoury.cs5004.game;

import java.util.Objects;

/**
 * Soldier is a type of game piece. It has two subtypes: Sniper and Marine.
 *
 * @author evandouglass
 */
public abstract class Soldier extends Pieces {

  private Stamina stamina;

  /**
   * Constructor for Soldier.
   *
   * @param name Soldier's name
   * @param age Soldier's age
   * @param stamina Soldier's stamina as a Double
   */
  public Soldier(Name name, Age age, Double stamina) {
    super(name, age);
    this.stamina = new Stamina(stamina);
  }

  /**
   * Adds some amount to this Soldiers's stamina.
   *
   * @param amount an amount to add
   */
  public void addToStamina(Double amount) {
    stamina = new Stamina(stamina.getStamina() + amount);
  }

  /**
   * Subtracts some amount from this Soldiers's stamina.
   *
   * @param amount an amount to subtract
   */
  public void decreaseStamina(Double amount) {
    stamina = new Stamina(stamina.getStamina() - amount);
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
    Soldier soldier = (Soldier) o;
    return stamina.equals(soldier.stamina);
  }

  /**
   * Makes a hash code.
   *
   * @return a hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(stamina);
  }

  /**
   * Getter for wealth.
   *
   * @return wealth
   */
  public Stamina getStamina() {
    return stamina;
  }
}
