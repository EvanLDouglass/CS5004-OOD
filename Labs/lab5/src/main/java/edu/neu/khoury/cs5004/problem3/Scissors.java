package edu.neu.khoury.cs5004.problem3;

/**
 * Represents a Scissors state in the game Rock, Paper, Scissors.
 *
 * @author evandouglass
 */
public class Scissors implements IState {

  @Override
  public Boolean beats(IState other) {
    RPS type = other.getType();
    if (type == RPS.PAPER) {
      return true;
    }
    return false;
  }

  @Override
  public RPS getType() {
    return RPS.SCISSORS;
  }
}
