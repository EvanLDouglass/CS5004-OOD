package edu.neu.khoury.sc5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractFilmArtistTest {

  private class CFilmArtist extends AbstractFilmArtist {

    public CFilmArtist(Name name, Age age, String activeYears, String genre, String awards,
        String movies, String series, String otherMultiMedia) {
      super(name, age, activeYears, genre, awards, movies, series, otherMultiMedia);
    }

    public CFilmArtist(Name name, Age age) {
      super(name, age);
    }
  }

  private CFilmArtist artist;

  @Before
  public void setUp() throws Exception {
    artist = new CFilmArtist(new Name("Evan", "Douglass"),
        new Age(28),
        "1990-2019",
        "CS",
        "A+",
        "None",
        "None",
        "None");
  }

  @Test
  public void toString1() {
    String result = "Artist\n" +
        "name: Evan Douglass\n" +
        "Age: 28\n" +
        "active years: 1990-2019\n" +
        "genres: CS\n" +
        "awards: A+\n" +
        "movies: None\n" +
        "TV series: None\n" +
        "other media: None";

    assertEquals(result, artist.toString());
  }

  @Test
  public void equals1() {
    CFilmArtist a = new CFilmArtist(new Name("Evan", "Douglass"),
        new Age(28),
        "1990-2019",
        "CS",
        "A+",
        "None",
        "None",
        "None");

    assertEquals(a, artist);
  }

  @Test
  public void testGetters() {
    assertEquals("None", artist.getMovies());
    assertEquals("None", artist.getSeries());
    assertEquals("None", artist.getOtherMultiMedia());
  }
}