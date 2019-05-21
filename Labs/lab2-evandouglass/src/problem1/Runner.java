package problem1;

/**
 * Class Runner represents someone who is a runner.
 */
public class Runner extends Athlete {

  private Double best5KTime;
  private Double bestHalfMarathonTime;
  private String favRunningEvent;

  /**
   * Main constructor for Runner
   *
   * @param athletesName runner's name
   * @param height runner's height
   * @param weight runner's weight
   * @param league runner's league
   * @param best5KTime runner's best 5K time
   * @param bestHalfMarathonTime runner's best half-marathon time
   * @param favRunningEvent runner's favorite running event.
   */
  public Runner(Name athletesName, Double height, Double weight, String league,
      Double best5KTime, Double bestHalfMarathonTime, String favRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favRunningEvent = favRunningEvent;
  }

  /**
   * @return runner's best 5K time
   */
  public Double getBest5KTime() {
    return best5KTime;
  }

  /**
   * @return runner's best half-marathon time
   */
  public Double getBestHalfMarathonTime() {
    return bestHalfMarathonTime;
  }

  /**
   * @return runner's favorite running event
   */
  public String getFavRunningEvent() {
    return favRunningEvent;
  }
}
