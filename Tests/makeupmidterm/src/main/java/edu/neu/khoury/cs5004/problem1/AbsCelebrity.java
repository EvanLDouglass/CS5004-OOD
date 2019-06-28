package edu.neu.khoury.cs5004.problem1;

import java.time.LocalDate;
import java.util.Objects;

public abstract class AbsCelebrity extends AbsInfluencer implements ICelebrity {

  private String lastAppearanceEvent;

  /**
   * Constructor for AbsCelebrity.
   *
   * @param name name of the influencer
   * @param dateOfBirth the influencer's date of birth
   * @param platforms the different platforms the influencer is on
   * @param numFollowers the number of followers on each platform in platforms
   * @param lastAppearanceEvent the last event this celebrity appeared in
   */
  public AbsCelebrity(String name, LocalDate dateOfBirth,
      SocialMediaPlatforms[] platforms, Integer[] numFollowers, String lastAppearanceEvent) {
    super(name, dateOfBirth, platforms, numFollowers);
    this.lastAppearanceEvent = lastAppearanceEvent;
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
    AbsCelebrity that = (AbsCelebrity) o;
    return Objects.equals(lastAppearanceEvent, that.lastAppearanceEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), lastAppearanceEvent);
  }

  @Override
  public String toString() {
    return "AbsCelebrity{" +
        "lastAppearanceEvent='" + lastAppearanceEvent + '\'' +
        '}';
  }

  @Override
  public String getLastAppearanceEvent() {
    return lastAppearanceEvent;
  }

  @Override
  public void setLastAppearanceEvent(String lastAppearanceEvent) {
    this.lastAppearanceEvent = lastAppearanceEvent;
  }
}
