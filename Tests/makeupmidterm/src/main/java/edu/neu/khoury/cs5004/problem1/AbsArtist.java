package edu.neu.khoury.cs5004.problem1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public abstract class AbsArtist extends AbsInfluencer implements IArtist {

  private static final Double INFLUENCE_MULTIPLYER = 1.3;

  private String[] awards;
  private Integer yearOfLastApperance;
  private Double grossIncomeOfLastApperance;

  /**
   * Constructor for AbsArtist.
   *
   * @param name name of the influencer
   * @param dateOfBirth the influencer's date of birth
   * @param platforms the different platforms the influencer is on
   * @param numFollowers the number of followers on each platform in platforms
   * @param awards a list of awards received
   * @param yearOfLastApperance the year of their last appearance on TV or in a movie
   * @param grossIncomeOfLastApperance the gross income received due to their last appearance
   */
  public AbsArtist(String name, LocalDate dateOfBirth,
      SocialMediaPlatforms[] platforms, Integer[] numFollowers, String[] awards,
      Integer yearOfLastApperance, Double grossIncomeOfLastApperance) {
    super(name, dateOfBirth, platforms, numFollowers);
    this.awards = awards;
    this.yearOfLastApperance = yearOfLastApperance;
    this.grossIncomeOfLastApperance = grossIncomeOfLastApperance;
  }

  @Override
  public Double estimateInfluence() throws ImpactEstimationException {
    return super.estimateInfluence() * INFLUENCE_MULTIPLYER;
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
    AbsArtist absArtist = (AbsArtist) o;
    return Arrays.equals(awards, absArtist.awards) &&
        Objects.equals(yearOfLastApperance, absArtist.yearOfLastApperance) &&
        Objects.equals(grossIncomeOfLastApperance, absArtist.grossIncomeOfLastApperance);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(super.hashCode(), yearOfLastApperance, grossIncomeOfLastApperance);
    result = 31 * result + Arrays.hashCode(awards);
    return result;
  }

  @Override
  public String toString() {
    return "AbsArtist{" +
        "awards=" + Arrays.toString(awards) +
        ", yearOfLastApperance=" + yearOfLastApperance +
        ", grossIncomeOfLastApperance=" + grossIncomeOfLastApperance +
        '}';
  }

  @Override
  public String[] getAwards() {
    return awards;
  }

  @Override
  public void setAwards(String[] awards) {
    this.awards = awards;
  }

  @Override
  public Integer getYearOfLastApperance() {
    return yearOfLastApperance;
  }

  @Override
  public void setYearOfLastApperance(Integer yearOfLastApperance) {
    this.yearOfLastApperance = yearOfLastApperance;
  }

  @Override
  public Double getGrossIncomeOfLastApperance() {
    return grossIncomeOfLastApperance;
  }

  @Override
  public void setGrossIncomeOfLastApperance(Double grossIncomeOfLastApperance) {
    this.grossIncomeOfLastApperance = grossIncomeOfLastApperance;
  }
}
