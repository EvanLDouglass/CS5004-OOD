package edu.neu.khoury.cs5004.problem3;

/**
 * Represents one of two players in a game of Rock, Paper, Scissors.
 *
 * @author evandouglass
 */
public class Player {

  private IState choice;

  // Uses default constructor

  /**
   * Plays this player's choice for the round. Effectively a
   * getter for the player's choice (Rock, Paper, Scissors).
   *
   * @return The player's choice
   */
  public IState play() {
    return choice;
  }

  /**
   * Setter for the player's choice (Rock, Paper, Scissors).
   *
   * @param choice the new choice
   */
  public void setChoice(IState choice) {
    this.choice = choice;
  }
}
