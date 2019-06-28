package edu.neu.khoury.cs5004.problem1;

import java.time.LocalDate;

public class RealityStar extends AbsCelebrity {

  /**
   * Constructor for RealityStar.
   *
   * @param name name of the influencer
   * @param dateOfBirth the influencer's date of birth
   * @param platforms the different platforms the influencer is on
   * @param numFollowers the number of followers on each platform in platforms
   * @param lastAppearanceEvent the last event this celebrity appeared in
   */
  public RealityStar(String name, LocalDate dateOfBirth,
      SocialMediaPlatforms[] platforms, Integer[] numFollowers, String lastAppearanceEvent) {
    super(name, dateOfBirth, platforms, numFollowers, lastAppearanceEvent);
  }
}
