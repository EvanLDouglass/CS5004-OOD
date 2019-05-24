package edu.neu.khoury.cs5004.game;

/**
 * Farmer is a type of Civilian in the game.
 *
 * @author evandouglass
 */
public class Farmer extends Civilian {

  /**
   * Constructor for Farmer.
   *
   * @param name Farmer's name
   * @param age Farmer's age
   * @param wealth Farmer's wealth as a Double
   */
  public Farmer(Name name, Age age, Double wealth) throws Exception {
    super(name, age, wealth);
  }

  @Override
  public String toString() {
    return String.format(
        "Farmer{%s, %s, %s}",
        this.getName(), this.getAge(), this.getWealth()
    );
  }


}
