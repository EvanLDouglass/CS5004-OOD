package edu.neu.khoury.cs5004.problem1;

import java.time.LocalDate;
import java.util.Objects;

public class ProfessionalAthlete extends AbsNeedsFiveHundredThousand {

  private static final Double ATHLETE_MULTIPLYER = 0.95;

  private String sport;
  private String league;
  private Double lastSeasonsEarnings;

  /**
   * Constructor for ProfessionalAthlete.
   *
   * @param name name of the influencer
   * @param dateOfBirth the influencer's date of birth
   * @param platforms the different platforms the influencer is on
   * @param numFollowers the number of followers on each platform in platforms
   * @param sport the sport they play
   * @param league the league they play in
   * @param lastSeasonsEarnings how much they earned last season
   */
  public ProfessionalAthlete(String name, LocalDate dateOfBirth,
      SocialMediaPlatforms[] platforms, Integer[] numFollowers, String sport, String league,
      Double lastSeasonsEarnings) {
    super(name, dateOfBirth, platforms, numFollowers);
    this.sport = sport;
    this.league = league;
    this.lastSeasonsEarnings = lastSeasonsEarnings;
  }

  @Override
  public Double estimateInfluence() throws ImpactEstimationException {
    if (!hasMinFollowers()) {
      throw new ImpactEstimationException();
    }
    return super.estimateInfluence() * ATHLETE_MULTIPLYER;
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
    ProfessionalAthlete that = (ProfessionalAthlete) o;
    return Objects.equals(sport, that.sport) &&
        Objects.equals(league, that.league) &&
        Objects.equals(lastSeasonsEarnings, that.lastSeasonsEarnings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), sport, league, lastSeasonsEarnings);
  }

  @Override
  public String toString() {
    return "ProfessionalAthlete{" +
        "sport='" + sport + '\'' +
        ", league='" + league + '\'' +
        ", lastSeasonsEarnings=" + lastSeasonsEarnings +
        '}';
  }

  /**
   * Getter for sport.
   *
   * @return the sport
   */
  public String getSport() {
    return sport;
  }

  /**
   * Setter for sport.
   *
   * @param sport new sport
   */
  public void setSport(String sport) {
    this.sport = sport;
  }

  /**
   * Getter for league.
   *
   * @return the league
   */
  public String getLeague() {
    return league;
  }

  /**
   * Setter for league.
   *
   * @param league new league
   */
  public void setLeague(String league) {
    this.league = league;
  }

  /**
   * Getter for earnings.
   *
   * @return the earnings
   */
  public Double getLastSeasonsEarnings() {
    return lastSeasonsEarnings;
  }

  /**
   * Setter for last season's earnings.
   *
   * @param lastSeasonsEarnings new earnings
   */
  public void setLastSeasonsEarnings(Double lastSeasonsEarnings) {
    this.lastSeasonsEarnings = lastSeasonsEarnings;
  }
}
