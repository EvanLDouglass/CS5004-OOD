package edu.neu.khoury.sc5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractVisualArtistTest {

  private class CVisualArtist extends AbstractVisualArtist {

    public CVisualArtist(Name name, Age age, String activeYears, String genre, String awards,
        String exhibits) {
      super(name, age, activeYears, genre, awards, exhibits);
    }
  }

  private CVisualArtist artist;

  @Before
  public void setUp() throws Exception {
    artist = new CVisualArtist(
        new Name("Evan", "Douglass"),
        new Age(28),
        "1990-2019",
        "CS",
        "A+",
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
        "exhibits: None";

    assertEquals(result, artist.toString());
  }

  @Test
  public void equals1() {
    CVisualArtist a = new CVisualArtist(
        new Name("Evan", "Douglass"),
        new Age(28),
        "1990-2019",
        "CS",
        "A+",
        "None");

    assertEquals(a, artist);
  }

  @Test
  public void getExhibits() {
    assertEquals("None", artist.getExhibits());
  }
}