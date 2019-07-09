package edu.neu.khoury.cs5004.assignment5.problem2;

import edu.neu.khoury.cs5004.assignment5.problem1.Runner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Iterates through a list of runners, returning only those runners who have run at least five 5k
 * races and have qualified for an upcoming half-marathon by running at least one previous
 * half-marathon in less than 100.00 minutes.
 *
 * @author evandouglass
 */
public class RunnersIterator implements Iterator<Runner> {

  private List<Runner> runners;
  private int currIndex;

  /**
   * Constructor for the {@code RunnersIterator}.
   *
   * @param runners a list of Runners
   */
  public RunnersIterator(List<Runner> runners) {
    this.currIndex = 0;
    this.runners = new ArrayList<>();
    // add filtered elements of runners to this.runners
    filterList(runners);
  }

  /**
   * Filters the given list of runners to those who have at least five 5k races and have qualified
   * for an upcoming half-marathon. Adds the filtered elements to this.runners.
   *
   * @param runners the list to filter
   */
  private void filterList(List<Runner> runners) {
    for (Runner runner : runners) {
      if (hasFive5k(runner) || qualifiedForHalfMar(runner)) {
        this.runners.add(runner);
      }
    }
  }

  /**
   * Checks if the given Runner has completed at least five 5k races or not.
   *
   * @param runner the runner to check
   * @return true if the runner has at least five 5k races, else false
   */
  private Boolean hasFive5k(Runner runner) {
    final int min5K = 5;
    return runner.getFiveKRaceTimes().size() >= min5K;
  }

  /**
   * Checks if the given Runner has qualified for an upcoming half-marathon by running a previous
   * half-marathon in under 10 minutes.
   *
   * @param runner the runner to check
   * @return true if the runner qualified, else false
   */
  private Boolean qualifiedForHalfMar(Runner runner) {
    final double maxQualifyingTime = 10.0;
    List<Double> halfMars = runner.getHalfMarathonTimes();
    for (Double time : halfMars) {
      if (time < maxQualifyingTime) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean hasNext() {
    // currIndex indicates the next returned element, so should be equal to size to indicate
    // that there are no more elements to return
    return currIndex < runners.size();
  }

  @Override
  public Runner next() {
    return runners.get(currIndex++);
  }
}
