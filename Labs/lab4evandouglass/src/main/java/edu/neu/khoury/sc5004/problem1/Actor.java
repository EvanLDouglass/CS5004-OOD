package edu.neu.khoury.sc5004.problem1;

public class Actor extends AbstractFilmArtist {

  public Actor(Name name, Age age, String activeYears, String genre,
      String awards) {
    super(name, age, activeYears, genre, awards);
  }

  public Actor(Name name, Age age) {
    super(name, age);
  }

  @Override
  public IArtist receiveAward(String award) {
    return null;
  }
}
