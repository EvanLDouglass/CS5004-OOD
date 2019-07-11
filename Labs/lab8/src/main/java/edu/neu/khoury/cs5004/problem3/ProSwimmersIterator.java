package edu.neu.khoury.cs5004.problem3;

import edu.neu.khoury.cs5004.problem2.Swimmer;
import java.util.List;

/**
 * Iterates through a list of swimmers, filtering by swimmers that have 5 or more butterfly times
 * and an Olympic qualifying freestyle time.
 */
public class ProSwimmersIterator extends SwimmersIterator {

  private static Double OLYMPIC_QUALIFYING_TIME = 26.17;

  // Contains the index of the next qualifying swimmer, or -1 if none is available.
  private Integer nextQualifier;

  /**
   * Constructor for a ProSwimmersIterator.
   *
   * @param swimmers a list of Swimmers
   */
  public ProSwimmersIterator(List<Swimmer> swimmers) {
    super(swimmers);
    nextQualifier = -1;  // set here first in case first index is 0
    setNextQualifier();
  }

  @Override
  public Swimmer next() {
    Swimmer swimmer = swimmers.get(nextQualifier);
    setNextQualifier();
    return swimmer;
  }

  @Override
  public boolean hasNext() {
    return nextQualifier != -1;
  }

  /**
   * Determines the next qualifying swimmer and sets {@code nextQualifier} to that swimmer's index,
   * or to -1 if there are no more qualifying swimmers.
   */
  private void setNextQualifier() {
    for (int i = nextQualifier + 1; i < swimmers.size(); i++) {
      Swimmer swimmer = swimmers.get(i);
      if (isQualifying(swimmer)) {
        nextQualifier = i;
        break;
      }
    }
    nextQualifier = -1;
  }

  /**
   * Determines if a swimmer has at least 5 butterfly swim times and has at least one 50m Olympic
   * freestyle qualifying time.
   *
   * @param swimmer a swimmer to test
   * @return true if the swimmer meets the qualifications, else false
   */
  private Boolean isQualifying(Swimmer swimmer) {
    return has5ButterflyTimes(swimmer) && hasOlympicQualifyingTime(swimmer);
  }

  /**
   * Tests if the given swimmer has 5 times recorded in the 50m butterfly race.
   *
   * @param swimmer a swimmer to test
   * @return true if they have 5 or more times, else false
   */
  private Boolean has5ButterflyTimes(Swimmer swimmer) {
    return swimmer.getButterfly50mTimes().size() >= 5;
  }

  /**
   * Tests if the given swimmer has a freestyle time recorded that meets the olympic qualifying
   * time.
   *
   * @param swimmer a swimmer to test
   * @return true if they have a qualifying time, else false
   */
  private Boolean hasOlympicQualifyingTime(Swimmer swimmer) {
    List<Double> times = swimmer.getFreestyle50mTimes();
    for (Double time : times) {
      if (time <= OLYMPIC_QUALIFYING_TIME) {
        return true;
      }
    }
    return false;
  }
}
