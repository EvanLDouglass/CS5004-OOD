package edu.neu.khoury.sc5004.problem1;

public class Painter extends AbstractVisualArtist {

  public Painter(Name name, Age age, String activeYears, String genre,
      String awards) {
    super(name, age, activeYears, genre, awards);
  }

  public Painter(Name name, Age age) {
    super(name, age);
  }

  @Override
  public IArtist receiveAward(String award) {
    return null;
  }
}
