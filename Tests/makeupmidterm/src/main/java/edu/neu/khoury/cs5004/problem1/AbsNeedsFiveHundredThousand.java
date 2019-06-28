package edu.neu.khoury.cs5004.problem1;

import java.time.LocalDate;

public abstract class AbsNeedsFiveHundredThousand extends AbsInfluencer implements
    IMinFollowerRequiredInfluencer {

  private static final Integer MIN_NEEDED = 500000;


  /**
   * Constructor for AbsNeedsFiveHundredThousand.
   *
   * @param name name of the influencer
   * @param dateOfBirth the influencer's date of birth
   * @param platforms the different platforms the influencer is on
   * @param numFollowers the number of followers on each platform in platforms
   */
  public AbsNeedsFiveHundredThousand(String name, LocalDate dateOfBirth,
      SocialMediaPlatforms[] platforms, Integer[] numFollowers) {
    super(name, dateOfBirth, platforms, numFollowers);
  }

  @Override
  public Boolean hasMinFollowers() {
    Integer total = 0;
    for (Integer num : getNumFollowers()) {
      total += num;
    }
    return total > MIN_NEEDED;
  }
}
