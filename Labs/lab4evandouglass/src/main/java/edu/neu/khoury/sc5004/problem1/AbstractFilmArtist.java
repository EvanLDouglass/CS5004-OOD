package edu.neu.khoury.sc5004.problem1;

import java.util.Objects;

/**
 * A subclass of AbstractArtist that contains data relevant to artists who work in the film
 * industry.
 *
 * @author evandouglass
 */
public abstract class AbstractFilmArtist extends AbstractArtist {

  private String movies;
  private String series;
  private String otherMultiMedia;

  /**
   * Constructor for a Film Artist.
   *
   * @param name artist's name
   * @param age artist's age
   * @param activeYears artist's active years (e.g. "1990-2019")
   * @param genre artist's genre as comma separated strings.
   * @param awards artist's awards as comma separated strings.
   * @param movies the movies this artist has been in, as comma separated strings.
   * @param series the TV series this artist has been in, as comma separated strings.
   * @param otherMultiMedia any other media this artist has been in, as comma separated strings.
   */
  public AbstractFilmArtist(Name name, Age age, String activeYears, String genre, String awards,
      String movies, String series, String otherMultiMedia) {
    super(name, age, activeYears, genre, awards);
    this.movies = movies;
    this.series = series;
    this.otherMultiMedia = otherMultiMedia;
  }

  /**
   * Basic constructor.
   *
   * @param name artist's name
   * @param age artist's age
   */
  public AbstractFilmArtist(Name name, Age age) {
    super(name, age);
    this.movies = "";
    this.series = "";
    this.otherMultiMedia = "";
  }

  /**
   * The toString method.
   *
   * @return a string representation of this object
   */
  @Override
  public String toString() {
    return super.toString() +
        String.format("\nmovies: %s\n" +
                "TV series: %s\n" +
                "other media: %s",
            movies, series, otherMultiMedia);
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
    AbstractFilmArtist that = (AbstractFilmArtist) o;
    return movies.equals(that.movies) &&
        series.equals(that.series) &&
        otherMultiMedia.equals(that.otherMultiMedia);
  }

  /**
   * Makes a hashcode.
   *
   * @return a hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), movies, series, otherMultiMedia);
  }

  /**
   * Gets movies.
   *
   * @return movies
   */
  public String getMovies() {
    return movies;
  }

  /**
   * Gets TV series.
   *
   * @return series
   */
  public String getSeries() {
    return series;
  }

  /**
   * Gets other multimedia.
   *
   * @return otherMultiMedia
   */
  public String getOtherMultiMedia() {
    return otherMultiMedia;
  }
}
