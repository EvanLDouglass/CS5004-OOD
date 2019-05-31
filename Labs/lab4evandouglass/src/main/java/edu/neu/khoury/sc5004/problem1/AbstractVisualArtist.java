package edu.neu.khoury.sc5004.problem1;

import java.util.Objects;

/**
 * A visual artist is a kind of artist that works with visual media,
 * such as a painter or photographer.
 *
 * @author evandouglass
 */
public abstract class AbstractVisualArtist extends AbstractArtist {

  private String exhibits;

  /**
   * Full constructor for AbstractVisualArtist.
   *
   * @param name artist's name
   * @param age artist's age
   * @param activeYears artist's active years (e.g. "1990-2019")
   * @param genre artist's genre as comma separated strings.
   * @param awards artist's awards as comma separated strings.
   * @param exhibits the exhibits this artist has been featured in.
   */
  public AbstractVisualArtist(Name name, Age age, String activeYears, String genre,
      String awards, String exhibits) {
    super(name, age, activeYears, genre, awards);
    this.exhibits = exhibits;
  }

  /**
   * Basic Constructor.
   *
   * @param name artist's name
   * @param age artist's age
   */
  public AbstractVisualArtist(Name name, Age age) {
    super(name, age);
    this.exhibits = "";
  }

  /**
   * The toString method.
   *
   * @return a string representation of this object
   */
  @Override
  public String toString() {
    return super.toString() +
        String.format("\nexhibits: %s", exhibits);
  }

  /**
   * Tests equality.
   *
   * @param o object to test
   * @return true if equal, else false
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
    AbstractVisualArtist that = (AbstractVisualArtist) o;
    return exhibits.equals(that.exhibits);
  }

  /**
   * Generates a hashcode.
   *
   * @return a hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), exhibits);
  }

  /**
   * Getter for exhibits.
   *
   * @return exhibits
   */
  public String getExhibits() {
    return exhibits;
  }
}
