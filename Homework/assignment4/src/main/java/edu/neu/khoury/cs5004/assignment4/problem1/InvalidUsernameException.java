package edu.neu.khoury.cs5004.assignment4.problem1;

/**
 * Thrown when a username is used in an operation on a IUserPassPair but the
 * username is not present.
 */
public class InvalidUsernameException extends Exception {

  public InvalidUsernameException(String msg) {
    super(msg);
  }
}
