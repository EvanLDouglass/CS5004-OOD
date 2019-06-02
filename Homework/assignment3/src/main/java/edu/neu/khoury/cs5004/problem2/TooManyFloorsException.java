package edu.neu.khoury.cs5004.problem2;

/**
 * An exception used for services that have a limit on the number of floors that a service property
 * can have.
 *
 * @author evandouglass
 */
public class TooManyFloorsException extends Exception {

  /**
   * Basic constructor.
   */
  public TooManyFloorsException() {
  }

  /**
   * Constructor with a message.
   *
   * @param message a message to pass to the user
   */
  public TooManyFloorsException(String message) {
    super(message);
  }
}
