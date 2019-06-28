package edu.neu.khoury.cs5004.problem2;

/**
 * Simple exception to indicate an invalid operation on an empty {@code Queue}.
 *
 * @author evandouglass
 */
public class EmptyQueueException extends Exception {

  /**
   * Constructor for the exception.
   */
  public EmptyQueueException() {
    super();
  }
}
