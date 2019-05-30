package edu.neu.khoury.sc5004.problem1;

public abstract class AbstractVisualArtist extends AbstractArtist {

  public AbstractVisualArtist(Name name, Age age, String activeYears, String genre, String awards) {
    super(name, age, activeYears, genre, awards);
  }

  public AbstractVisualArtist(Name name, Age age) {
    super(name, age);
  }
}
