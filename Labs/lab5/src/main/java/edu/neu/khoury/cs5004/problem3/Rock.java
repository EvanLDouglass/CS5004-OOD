package edu.neu.khoury.cs5004.problem3;

/**
 * Represents a Rock state in the game Rock, Paper, Scissors.
 *
 * @author evandouglass
 */
public class Rock implements IState {

  @Override
  public Boolean beats(IState other) {
    RPS type = other.getType();
    if (type == RPS.SCISSORS) {
      return true;
    }
    return false;
  }

  @Override
  public RPS getType() {
    return RPS.ROCK;
  }
}
