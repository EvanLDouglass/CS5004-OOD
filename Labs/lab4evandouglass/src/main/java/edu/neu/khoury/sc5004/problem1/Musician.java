package edu.neu.khoury.sc5004.problem1;

import java.util.Objects;

/**
 * A Musician is a type of Artist.
 *
 * @author evandouglass
 */
public class Musician extends AbstractArtist {

  private String recordingCompany;
  private String lastRecordAlbum;

  /**
   * Full Constructor
   *
   * @param name artist's name
   * @param age artist's age
   * @param activeYears artist's active years (e.g. "1990-2019")
   * @param genre artist's genre as comma separated strings.
   * @param awards artist's awards as comma separated strings.
   * @param recordingCompany artist's recording company
   * @param lastRecordAlbum artist's last record name
   */
  public Musician(Name name, Age age, String activeYears, String genre, String awards,
      String recordingCompany, String lastRecordAlbum) {
    super(name, age, activeYears, genre, awards);
    this.recordingCompany = recordingCompany;
    this.lastRecordAlbum = lastRecordAlbum;
  }

  /**
   * Basic Constructor.
   *
   * @param name artist's name
   * @param age artist's age
   */
  public Musician(Name name, Age age) {
    super(name, age);
    this.recordingCompany = "";
    this.lastRecordAlbum = "";
  }

  @Override
  public String toString() {
    return super.toString() +
        String.format("recording company: %s\n" +
            "last record: %s",
            recordingCompany, lastRecordAlbum);
  }

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
    Musician musician = (Musician) o;
    return recordingCompany.equals(musician.recordingCompany) &&
        lastRecordAlbum.equals(musician.lastRecordAlbum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), recordingCompany, lastRecordAlbum);
  }

  public String getRecordingCompany() {
    return recordingCompany;
  }

  public String getLastRecordAlbum() {
    return lastRecordAlbum;
  }
}
