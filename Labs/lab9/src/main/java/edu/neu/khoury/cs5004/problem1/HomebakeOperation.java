package edu.neu.khoury.cs5004.problem1;

public interface HomebakeOperation {

  /**
   * Runs the primary operation.
   */
  void execute();

  /**
   * Validates the arguments given to this operation.
   *
   * @param args the command line arguments
   */
  void validateArgs(String[] args);

  /**
   * Sets the data/flags for this operation.
   *
   * @param data the data/flags to use for this operation
   */
  void setData(HomebakeData data);
}
