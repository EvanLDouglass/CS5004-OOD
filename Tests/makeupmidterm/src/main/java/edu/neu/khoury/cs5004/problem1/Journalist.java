package edu.neu.khoury.cs5004.problem1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Journalist extends AbsNeedsFiveHundredThousand {

  private static final Double JOURNALIST_MULTIPLYER = 0.85;
  private static final Double TWITTER_BUMP = 1.25;
  private static final Integer MIN_TWITTER_FOLLOWERS = 100000;

  private String publishingCompany;
  private String[] awards;

  /**
   * Constructor for Journalist.
   *
   * @param name name of the influencer
   * @param dateOfBirth the influencer's date of birth
   * @param platforms the different platforms the influencer is on
   * @param numFollowers the number of followers on each platform in platforms
   * @param publishingCompany the publishing company they work for
   * @param awards a list of journalistic awards they have received
   */
  public Journalist(String name, LocalDate dateOfBirth,
      SocialMediaPlatforms[] platforms, Integer[] numFollowers, String publishingCompany,
      String[] awards) {
    super(name, dateOfBirth, platforms, numFollowers);
    this.publishingCompany = publishingCompany;
    this.awards = awards;
  }

  @Override
  public Double estimateInfluence() throws ImpactEstimationException {
    if (!hasMinFollowers()) {
      throw new ImpactEstimationException();
    }
    Double impact = super.estimateInfluence() * JOURNALIST_MULTIPLYER;
    if (has100kTwitterFollowers()) {
      impact *= TWITTER_BUMP;
    }
    return impact;
  }

  /**
   * Checks if they have more than 100K Twitter followers.
   *
   * @return true if they do, else false
   */
  private Boolean has100kTwitterFollowers() {
    int index = getTwitterIndex();
    if (index == -1) {
      // not on twitter
      return false;
    }
    Integer[] followers = getNumFollowers();
    if (followers[index] > MIN_TWITTER_FOLLOWERS) {
      // meets requirements
      return true;
    } else {
      // not enough followers
      return false;
    }
  }

  /**
   * Gets the index of Twitter in the platforms array.
   *
   * @return the index of Twitter, or -1 if not found
   */
  private int getTwitterIndex() {
    SocialMediaPlatforms[] arr = getPlatforms();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == SocialMediaPlatforms.TWITTER) {
        return i;
      }
    }
    return -1;
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
    Journalist that = (Journalist) o;
    return Objects.equals(publishingCompany, that.publishingCompany) &&
        Arrays.equals(awards, that.awards);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(super.hashCode(), publishingCompany);
    result = 31 * result + Arrays.hashCode(awards);
    return result;
  }

  @Override
  public String toString() {
    return "Journalist{" +
        "publishingCompany='" + publishingCompany + '\'' +
        ", awards=" + Arrays.toString(awards) +
        '}';
  }

  /**
   * Getter for publishing company.
   *
   * @return the publicshing company
   */
  public String getPublishingCompany() {
    return publishingCompany;
  }

  /**
   * Setter for publishing company.
   *
   * @param publishingCompany the new publishing company
   */
  public void setPublishingCompany(String publishingCompany) {
    this.publishingCompany = publishingCompany;
  }

  /**
   * Getter for awards.
   *
   * @return the list of awards
   */
  public String[] getAwards() {
    return awards;
  }

  /**
   * Setter for awards.
   *
   * @param awards the new list of awards
   */
  public void setAwards(String[] awards) {
    this.awards = awards;
  }
}
