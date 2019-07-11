package edu.neu.khoury.cs5004.problem3;

import edu.neu.khoury.cs5004.problem2.Swimmer;

import java.util.Iterator;
import java.util.List;

/**
 * An abstract iterator to define common iterator functions on a list of {@code Simmers}.
 */
public abstract class SwimmersIterator implements Iterator<Swimmer> {

  protected List<Swimmer> swimmers;

  /**
   * Constructor for a SwimmersIterator.
   *
   * @param swimmers a list of Swimmers
   */
  public SwimmersIterator(List<Swimmer> swimmers) {
    this.swimmers = swimmers;
  }

  @Override
  public boolean hasNext() {
    return !swimmers.isEmpty();
  }
}
