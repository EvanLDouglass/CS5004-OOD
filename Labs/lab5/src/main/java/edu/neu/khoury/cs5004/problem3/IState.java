package edu.neu.khoury.cs5004.problem3;

/**
 * A basic interface describing one of the possible choices a player can choose in the game Rock,
 * Paper, Scissors.
 *
 * @author evandouglass
 */
public interface IState {

  /**
   * Checks if the other state beats this one. Rules are as follows:
   * <ul>
   * <li>Rock beats Scissors</li>
   * <li>Scissors beats Paper</li>
   * <li>Paper beats Rock</li>
   * </ul>
   *
   * @param other the other state
   * @return true if this state beats the other, else false
   */
  Boolean beats(IState other);

  /**
   * Get's this State's type, as an RPS enum.
   *
   * @return the underlying type/state
   */
  RPS getType();
}
