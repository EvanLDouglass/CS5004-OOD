package edu.neu.khoury.cs5004.assignment5.problem1;

import java.util.List;

/**
 * A {@code Runner} represents someone who is a runner, with a name and a list of times for three
 * different kinds of races: 5k, 10k and half marathon.
 *
 * @author evandouglass
 */
public class Runner implements Comparable<Runner> {

  private String name;
  private List<Double> fiveKRaceTimes;
  private List<Double> tenKRaceTimes;
  private List<Double> halfMarathonTimes;

  /**
   * Constructor for {@code Runner}. All times are assumed to be in minutes.
   *
   * @param name the runner's name
   * @param fiveKRaceTimes a list of the runner's 5k race times
   * @param tenKRaceTimes a list of the runner's 10k race times
   * @param halfMarathonTimes a list of the runner's half marathon times
   */
  public Runner(String name, List<Double> fiveKRaceTimes,
      List<Double> tenKRaceTimes,
      List<Double> halfMarathonTimes) {
    this.name = name;
    this.fiveKRaceTimes = fiveKRaceTimes;
    this.tenKRaceTimes = tenKRaceTimes;
    this.halfMarathonTimes = halfMarathonTimes;
  }

  /**
   * Getter for name.
   *
   * @return the runner's name
   */
  public String getName() {
    return name;
  }

  /**
   * Getter for 5k times.
   *
   * @return a list of 5k times
   */
  public List<Double> getFiveKRaceTimes() {
    return fiveKRaceTimes;
  }

  /**
   * Getter for 10k times.
   *
   * @return a list of 10k times
   */
  public List<Double> getTenKRaceTimes() {
    return tenKRaceTimes;
  }

  /**
   * Getter for half marathon times.
   *
   * @return a list of half marathon times
   */
  public List<Double> getHalfMarathonTimes() {
    return halfMarathonTimes;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int compareTo(Runner otherRunner) {
    //YOUR CODE HERE
    Double thisAvg = getAvg5kTimes(this);
    Double otherAvg = getAvg5kTimes(otherRunner);
    return (int) (thisAvg - otherAvg);
  }

  /**
   * Calculate's a {@code Runner}'s average 5k times.
   *
   * @param runner the runner for which to get an average
   * @return the average 5k times
   */
  private Double getAvg5kTimes(Runner runner) {
    Double result = 0.0;
    List<Double> fiveKTimes = runner.getFiveKRaceTimes();
    // For empty lists
    if (fiveKTimes.size() == 0) {
      return result;
    }
    // For non-empty lists
    for (Double time : fiveKTimes) {
      result += time;
    }
    return result / fiveKTimes.size();
  }
}