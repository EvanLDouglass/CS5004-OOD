package edu.neu.khoury.cs5004.problem1;

import java.util.HashSet;
import java.util.Set;

/**
 * Validates command line arguments for a Homebake operation.
 */
public class OperationValidator {

  private Set<String> flags;
  private String[] args;

  /**
   * Simple constructor.
   */
  public OperationValidator(String[] args) {
    flags = new HashSet<>();
    flags.add("-q");
    flags.add("-v");
    flags.add("-d");
    // Note that the operation at index 0 has already been checked
    this.args = args;
  }

  /**
   * Validates the command line arguments.
   *
   * @throws IllegalArgumentException if the arguments to not pass validation
   */
  public void validateArgs() throws IllegalArgumentException {
    validateNumArgs();
    validateFormulaNotFlag(args[1]);
    // Last arguments, if any, should be flags (in any order)
    for (int i = 2; i < args.length; i++) {
      validateFlag(args[i]);
    }
  }

  /**
   * Formula validator.
   *
   * @param formula name of the software to check
   * @throws IllegalArgumentException if the operation is not recognized
   */
  private void validateFormulaNotFlag(String formula) throws IllegalArgumentException {
    if (flags.contains(formula)) {
      throw new IllegalArgumentException(
          "flag detected where formula required. Usage: Homebake <operation> <formula> [flags]");
    }
  }

  /**
   * Flag validator.
   *
   * @param flag the flag to test
   */
  private void validateFlag(String flag) throws IllegalArgumentException {
    if (!flags.contains(flag)) {
      throw new IllegalArgumentException(flag + " is not a recognized flag.");
    }
  }

  /**
   * Checks for the minimum and maximum number of arguments
   *
   * @throws IllegalArgumentException if there are too few or too many
   */
  private void validateNumArgs() throws IllegalArgumentException {
    if (args.length < 2) {
      throw new IllegalArgumentException(
          "Homebake must have at least two arguments, an operation and the name of the software");
    }
    if (args.length > 5) {
      throw new IllegalArgumentException("Too many arguments given");
    }
  }
}
