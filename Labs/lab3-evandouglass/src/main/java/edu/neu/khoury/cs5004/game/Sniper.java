package edu.neu.khoury.cs5004.game;

/**
 * Sniper is a type of Soldier piece.
 *
 * @author evandouglass
 */
public class Sniper extends Soldier {

  public Sniper(Name name, Age age, Double stamina) {
    super(name, age, stamina);
  }

  @Override
  public String toString() {
    return String.format(
        "Sniper{%s, %s, %s}",
        this.getName(), this.getAge(), this.getStamina()
    );
  }
}
