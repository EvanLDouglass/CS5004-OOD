package edu.neu.khoury.cs5004.problem1;

import java.time.LocalDate;

public class Singer extends AbsArtist {

  /**
   * Constructor for Singer.
   *
   * @param name name of the influencer
   * @param dateOfBirth the influencer's date of birth
   * @param platforms the different platforms the influencer is on
   * @param numFollowers the number of followers on each platform in platforms
   * @param awards a list of awards received
   * @param yearOfLastApperance the year of their last appearance on TV or in a movie
   * @param grossIncomeOfLastApperance the gross income received due to their last appearance
   */
  public Singer(String name, LocalDate dateOfBirth,
      SocialMediaPlatforms[] platforms, Integer[] numFollowers, String[] awards,
      Integer yearOfLastApperance, Double grossIncomeOfLastApperance) {
    super(name, dateOfBirth, platforms, numFollowers, awards, yearOfLastApperance,
        grossIncomeOfLastApperance);
  }
}
