package edu.neu.khoury.cs5004.problem3;

/**
 * Represents a Paper state in the game Rock, Paper, Scissors.
 *
 * @author evandouglass
 */
public class Paper implements IState {

  @Override
  public Boolean beats(IState other) {
    RPS type = other.getType();
    if (type == RPS.ROCK) {
      return true;
    }
    return false;
  }

  @Override
  public RPS getType() {
    return RPS.PAPER;
  }
}
