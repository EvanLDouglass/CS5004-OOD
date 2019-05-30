package edu.neu.khoury.sc5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractArtistTest {

  private class ArtistTest extends AbstractArtist {
    public ArtistTest (Name name, Age age, String activeYears, String genre, String awards) {
      super(name, age, activeYears, genre, awards);
    }

    public ArtistTest(Name name, Age age) {
      super(name, age);
    }

    @Override
    public IArtist receiveAward(String award) {
      return null;
    }
  }

  private ArtistTest aTest;
  private ArtistTest anotherTest;

  @Before
  public void setUp() throws Exception {
    aTest = new ArtistTest(new Name("Evan", "Douglass"), new Age(28),
        "1990-2019", "CS,Science", "Nobel,Turing");

    anotherTest = new ArtistTest(new Name("Test", "Name"), new Age(120));
  }

  @Test
  public void toString1() {
    String result = "Artist\n" +
        "name: Evan Douglass\n" +
        "Age: 28\n" +
        "active years: 1990-2019\n" +
        "genres: CS,Science\n" +
        "awards: Nobel,Turing";
    assertEquals(result, aTest.toString());

    result = "Artist\n" +
        "name: Test Name\n" +
        "Age: 120\n" +
        "active years: \n" +
        "genres: \n" +
        "awards: ";
    assertEquals(result, anotherTest.toString());
  }

  @Test
  public void equals1() {
    ArtistTest art = new ArtistTest(new Name("Evan", "Douglass"), new Age(28),
        "1990-2019", "CS,Science", "Nobel,Turing");
    assertEquals(art, aTest);
    assertNotEquals(aTest, anotherTest);
  }

  @Test
  public void testGetters() {
    assertEquals(new Name("Evan", "Douglass"), aTest.getName());
    assertEquals(new Age(28), aTest.getAge());
    assertEquals("1990-2019", aTest.getActiveYears());
    assertEquals("CS,Science", aTest.getGenre());
    assertEquals("Nobel,Turing", aTest.getAwards());
  }
}