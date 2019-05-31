package edu.neu.khoury.sc5004.problem1;

public class FilmMaker extends AbstractFilmArtist {


  public FilmMaker(Name name, Age age, String activeYears, String genre, String awards,
      String movies, String series, String otherMultiMedia) {
    super(name, age, activeYears, genre, awards, movies, series, otherMultiMedia);
  }

  public FilmMaker(Name name, Age age) {
    super(name, age);
  }
}
