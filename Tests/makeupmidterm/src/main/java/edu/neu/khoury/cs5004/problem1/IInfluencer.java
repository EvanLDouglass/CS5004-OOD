package edu.neu.khoury.cs5004.problem1;

import java.time.LocalDate;

/**
 * Describes general behavior of a social media influencer.
 *
 * @author evandoulgass
 */
public interface IInfluencer {

  /**
   * Estimates this influencer's influence index as a double.
   *
   * @return the estimated influence of this influencer
   * @throws ImpactEstimationException if the influencer is under 18 years old
   */
  Double estimateInfluence() throws ImpactEstimationException;

  /**
   * Getter for name.
   *
   * @return name
   */
  String getName();

  /**
   * Getter for birth date.
   *
   * @return birth date
   */
  LocalDate getDateOfBirth();

  /**
   * Getter for platforms.
   */
  SocialMediaPlatforms[] getPlatforms();

  /**
   * Setter for platforms.
   */
  void setPlatforms(SocialMediaPlatforms[] platforms);

  /**
   * Getter for number of followers.
   *
   * @return number of followers
   */
  Integer[] getNumFollowers();

  /**
   * Setter for number of followers.
   *
   * @param numFollowers the new number of followers
   */
  void setNumFollowers(Integer[] numFollowers);
}
