package edu.neu.khoury.sc5004.problem1;

public abstract class AbstractFilmArtist extends AbstractArtist {

  public AbstractFilmArtist(Name name, Age age, String activeYears, String genre, String awards) {
    super(name, age, activeYears, genre, awards);
  }

  public AbstractFilmArtist(Name name, Age age) {
    super(name, age);
  }
}
