package edu.neu.khoury.cs5004.game;

/**
 * Abstract class for general game pieces.
 *
 * @author evandouglass
 */
public abstract class Pieces {

  private Name name;
  private Age age;

  /**
   * Constructor for <pre>Pieces</pre>.
   *
   * @param name the <pre>Name</pre> of the piece
   * @param age the <pre>Age</pre> of the piece
   */
  public Pieces(Name name, Age age) {
    this.name = name;
    this.age = age;
  }

  /**
   * Tests equality of two objects.
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
    Pieces pieces = (Pieces) o;
    return name.equals(pieces.name) &&
        age.equals(pieces.age);
  }

  /**
   * Getter for name.
   *
   * @return the piece's name
   */
  public Name getName() {
    return name;
  }

  /**
   * Getter for age.
   *
   * @return the piece's age
   */
  public Age getAge() {
    return age;
  }
}
