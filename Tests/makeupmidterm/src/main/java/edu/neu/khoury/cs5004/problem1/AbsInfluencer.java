package edu.neu.khoury.cs5004.problem1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

/**
 * Abstract implementation of an IInfluencer.
 *
 * @author evandouglass
 */
public abstract class AbsInfluencer implements IInfluencer {

  private static final Double YOUTUBE_MULTIPLYER = 0.9;
  private static final Double INSTAGRAM_MULTIPLYER = 1.2;
  private static final Double PLATFORMS_BUMP = 1.6;
  private static final Double OVER55_MULTIPLYER = 0.55;

  private String name;
  private LocalDate dateOfBirth;
  private SocialMediaPlatforms[] platforms;
  private Integer[] numFollowers;

  /**
   * Constructor for AbsInfluencer.
   *
   * @param name name of the influencer
   * @param dateOfBirth the influencer's date of birth
   * @param platforms the different platforms the influencer is on
   * @param numFollowers the number of followers on each platform in platforms
   */
  public AbsInfluencer(String name, LocalDate dateOfBirth,
      SocialMediaPlatforms[] platforms, Integer[] numFollowers) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.platforms = platforms;
    this.numFollowers = numFollowers;
  }

  @Override
  public Double estimateInfluence() throws ImpactEstimationException {
    if (isUnder18()) {
      throw new ImpactEstimationException();
    }

    Double influence = getBaseInfluence();
    if (isOnYouTube()) {
      influence *= YOUTUBE_MULTIPLYER;
    }
    if (isOnInsta()) {
      influence *= INSTAGRAM_MULTIPLYER;
    }
    if (getsBump()) {
      influence *= PLATFORMS_BUMP;
    }
    if (isOver55()) {
      influence *= OVER55_MULTIPLYER;
    }
    return influence;
  }

  /**
   * Checks if they are under 18.
   *
   * @return true if under 18, else false
   */
  private Boolean isUnder18() {
    LocalDate today = LocalDate.now();
    LocalDate minus18 = today.minusYears(18);
    if (dateOfBirth.isAfter(minus18)) {
      return true;
    }
    return false;
  }

  /**
   * Checks if they are over 55.
   *
   * @return true if over 55, else false
   */
  private Boolean isOver55() {
    LocalDate today = LocalDate.now();
    LocalDate minus55 = today.minusYears(55);
    if (dateOfBirth.isBefore(minus55)) {
      return true;
    }
    return false;
  }

  /**
   * Gets base influence.
   *
   * @return base influence
   */
  private Double getBaseInfluence() {
    // Get all followers
    Integer totalFollowers = 0;
    for (Integer num : numFollowers) {
      totalFollowers += num;
    }
    // Divide by num platforms
    return totalFollowers / (double) platforms.length;
  }

  /**
   * Checks if the influencer is on YouTube.
   *
   * @return true if on YouTube, else false
   */
  private Boolean isOnYouTube() {
    for (SocialMediaPlatforms plat : platforms) {
      if (plat == SocialMediaPlatforms.YOUTUBE) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if the influencer is on Instagram.
   *
   * @return true if on Instagram, else false
   */
  private Boolean isOnInsta() {
    for (SocialMediaPlatforms plat : platforms) {
      if (plat == SocialMediaPlatforms.INSTAGRAM) {
        return true;
      }
    }
    return false;
  }

  /**
   * Tests if the influencer is on more than 3 platforms and deserves a "platform bump".
   *
   * @return true if on more than 3 platforms, else false
   */
  private Boolean getsBump() {
    if (platforms.length > 3) {
      return true;
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbsInfluencer that = (AbsInfluencer) o;
    return Objects.equals(name, that.name) &&
        Objects.equals(dateOfBirth, that.dateOfBirth) &&
        Arrays.equals(platforms, that.platforms) &&
        Arrays.equals(numFollowers, that.numFollowers);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(name, dateOfBirth);
    result = 31 * result + Arrays.hashCode(platforms);
    result = 31 * result + Arrays.hashCode(numFollowers);
    return result;
  }

  @Override
  public String toString() {
    return "AbsInfluencer{" +
        "name='" + name + '\'' +
        ", dateOfBirth=" + dateOfBirth +
        ", platforms=" + Arrays.toString(platforms) +
        ", numFollowers=" + Arrays.toString(numFollowers) +
        '}';
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  @Override
  public SocialMediaPlatforms[] getPlatforms() {
    return platforms;
  }

  @Override
  public void setPlatforms(SocialMediaPlatforms[] platforms) {
    this.platforms = platforms;
  }

  @Override
  public Integer[] getNumFollowers() {
    return numFollowers;
  }

  @Override
  public void setNumFollowers(Integer[] numFollowers) {
    this.numFollowers = numFollowers;
  }
}
