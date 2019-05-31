package edu.neu.khoury.sc5004.problem1;

import java.util.Objects;

/**
 * A poet is a kind of Artist.
 *
 * @author evandouglass
 */
public class Poet extends AbstractArtist {

  private String publishingComp;
  private String lastPublishedCollection;

  public Poet(Name name, Age age, String activeYears, String genre, String awards,
      String publishingComp, String lastPublishedCollection) {
    super(name, age, activeYears, genre, awards);
    this.publishingComp = publishingComp;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  public Poet(Name name, Age age) {
    super(name, age);
    this.publishingComp = "";
    this.lastPublishedCollection = "";
  }

  @Override
  public String toString() {
    return super.toString() +
        String.format("publishing company: %s" +
            "last published collection: %s",
            publishingComp, lastPublishedCollection);
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
    Poet poet = (Poet) o;
    return publishingComp.equals(poet.publishingComp) &&
        lastPublishedCollection.equals(poet.lastPublishedCollection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), publishingComp, lastPublishedCollection);
  }

  public String getPublishingComp() {
    return publishingComp;
  }

  public String getLastPublishedCollection() {
    return lastPublishedCollection;
  }
}
