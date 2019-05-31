package edu.neu.khoury.sc5004.problem1;

import java.util.Objects;

/**
 * An abstract implementation of IArtist.
 *
 * @author evandouglass
 */
public abstract class AbstractArtist implements IArtist {

  private Name name;
  private Age age;
  private String activeYears;
  private String genre;
  private String awards;

  /**
   * Full constructor for an Arist.
   *
   * @param name artist's name
   * @param age artist's age
   * @param activeYears artist's active years (e.g. "1990-2019")
   * @param genre artist's genre as comma separated strings.
   * @param awards artist's awards as comma separated strings.
   */
  public AbstractArtist(Name name, Age age, String activeYears, String genre, String awards) {
    this.name = name;
    this.age = age;
    this.activeYears = activeYears;
    this.genre = genre;
    this.awards = awards;
  }

  /**
   * Basic constructor for an Artist.
   *
   * @param name artist's name
   * @param age artist's age
   */
  public AbstractArtist(Name name, Age age) {
    this(name, age, "", "", "");
  }

  /* ===== Overrides ===== */

  @Override
  public void receiveAward(String award) {
    this.awards += "," + award;
  }

  /**
   * Represent's this object as a string.
   *
   * @return a string representation
   */
  @Override
  public String toString() {
    return String.format(
        "Artist\n" +
            "name: %s\n" +
            "%s\n" +  // Age: %s
            "active years: %s\n" +
            "genres: %s\n" +
            "awards: %s",
        name, age, activeYears, genre, awards
    );
  }

  /**
   * Tests equality.
   *
   * @param o object to test
   * @return true if equal, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractArtist that = (AbstractArtist) o;
    return name.equals(that.name) &&
        age.equals(that.age) &&
        Objects.equals(activeYears, that.activeYears) &&
        Objects.equals(genre, that.genre) &&
        Objects.equals(awards, that.awards);
  }

  /**
   * Makes a hashcode.
   *
   * @return a hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, age, activeYears, genre, awards);
  }

  /* ===== Getters ===== */

  /**
   * Getter for name.
   *
   * @return a Name object
   */
  public Name getName() {
    return name;
  }

  /**
   * Getter for age.
   * @return an age object
   */
  public Age getAge() {
    return age;
  }

  /**
   * Getter for active years.
   * @return active years as a string
   */
  public String getActiveYears() {
    return activeYears;
  }

  /**
   * Getter for genre.
   * @return a string list of genres
   */
  public String getGenre() {
    return genre;
  }

  /**
   * Getter for awards.
   * @return a string list of genres
   */
  public String getAwards() {
    return awards;
  }
}
