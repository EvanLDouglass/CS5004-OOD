package problem1;

/**
 * Class BaseballPlayer represents a baseball player.
 */
public class BaseballPlayer extends Athlete {

  private String team;
  private Double battingAvg;
  private Integer seasonHomeRuns;

  /**
   * Main constructor for a BaseballPlayer
   *
   * @param playersName player's name
   * @param height player's height
   * @param weight player's weight
   * @param league player's league
   * @param team player's team
   * @param battingAvg player's batting average
   * @param seasonHomeRuns number of home runs the player has in the season.
   */
  public BaseballPlayer(Name playersName, Double height, Double weight,
      String league, String team, Double battingAvg, Integer seasonHomeRuns) {
    super(playersName, height, weight, league);
    this.team = team;
    this.battingAvg = battingAvg;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * @return team name
   */
  public String getTeam() {
    return team;
  }

  /**
   * @return player's batting average
   */
  public Double getBattingAvg() {
    return battingAvg;
  }

  /**
   * @return number of home runs in the season by the player
   */
  public Integer getSeasonHomeRuns() {
    return seasonHomeRuns;
  }
}
