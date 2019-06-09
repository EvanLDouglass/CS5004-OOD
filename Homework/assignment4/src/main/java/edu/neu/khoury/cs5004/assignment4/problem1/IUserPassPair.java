package edu.neu.khoury.cs5004.assignment4.problem1;

/**
 * Defines functionality for a username-password pair for a hypothetical authentication system.
 *
 * @author evandouglass
 */
public interface IUserPassPair {

  /**
   * Creates an empty {@code IUserPassPair}.
   *
   * @return an empty {@code IUserPassPair}
   */
  static IUserPassPair createEmpty() {
    return new UserPassPair();
  }

  /**
   * Tests if this {@code IUserPassPair} is empty.
   *
   * @return true if empty, else false
   */
  Boolean isEmpty();

  /**
   * If the {@code IUserPassPair} is empty, returns a new nonempty {@code IUserPassPair} with
   * username and password set to (username, password).
   *
   * @param username the username
   * @param password the password
   * @return a new {@code IUserPassPair} set to (username, password)
   * @throws PairAlreadyInitializedException if the {@code IUserPassPair} is non-empty
   */
  IUserPassPair add(String username, String password) throws PairAlreadyInitializedException;

  /**
   * If {@code IUserPassPair} is non-empty, replaces the current values of username and password to
   * the given values.
   *
   * @param username the new username
   * @param password the new password
   * @return a new {@code IUserPassPair} with the new username and password
   * @throws PairEmptyException if the {@code IUserPassPair} is empty
   */
  IUserPassPair replace(String username, String password) throws PairEmptyException;

  /**
   * Deletes a username and password pair from the {@code IUserPassPair}.
   *
   * @param username the username of the pair to delete
   * @return an empty {@code IUserPassPair} if the username matches that in the pair, or if the pair
   *     was already empty
   * @throws InvalidUsernameException if the username does not match that in the non-empty {@code
   *     IUserPassPair}
   */
  IUserPassPair delete(String username) throws InvalidUsernameException;

  /**
   * Gets the password associated with the given username.
   *
   * @param username the username in the {@code IUserPassPair}
   * @return the password associated with the given username
   * @throws InvalidUsernameException if the username does not match that in the {@code
   *     IUserPassPair}
   * @throws PairEmptyException if the method is called on an empty {@code IUserPassPair}
   */
  String getPassword(String username) throws InvalidUsernameException, PairEmptyException;
}
