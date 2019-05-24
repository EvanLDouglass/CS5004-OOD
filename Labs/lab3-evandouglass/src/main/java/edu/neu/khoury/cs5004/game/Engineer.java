package edu.neu.khoury.cs5004.game;

/**
 * Engineer is a type of Civilian game piece.
 *
 * @author evandouglass
 */
public class Engineer extends Civilian {

  /**
   * Constructor for Engineer.
   *
   * @param name Engineer's name
   * @param age Engineer's age
   * @param wealth Engineer's wealth as a Double
   */
  public Engineer(Name name, Age age, Double wealth) throws Exception {
    super(name, age, wealth);
  }

  /**
   * Generates a String representation of an Engineer.
   *
   * @return a String representation of this object
   */
  @Override
  public String toString() {
    return String.format(
        "Engineer{%s, %s, %s}",
        this.getName(), this.getAge(), this.getWealth()
    );
  }
}
