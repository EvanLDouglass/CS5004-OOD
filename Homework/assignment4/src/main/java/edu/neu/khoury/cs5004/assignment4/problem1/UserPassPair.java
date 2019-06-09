package edu.neu.khoury.cs5004.assignment4.problem1;

/**
 * An implementation of the {@code IUserPassPair} interface.
 *
 * @author evandouglass
 */
public class UserPassPair implements IUserPassPair {

  private String username;
  private String password;

  /**
   * Constructor for a UserPassPair. This is private in order to force usage of the {@code
   * createEmpty} method in the {@code IUserPassPair} interface.
   *
   * @param username the username to initialize
   * @param password the password for the username
   */
  private UserPassPair(String username, String password) {
    this.username = username;
    this.password = password;
  }

  /**
   * Empty constructor for a UserPassPair. This is package-private in order to use it in the {@code
   * IUserPassPair} interface.
   */
  UserPassPair() {
  }

  /* ===== Methods ===== */

  @Override
  public Boolean isEmpty() {
    return (username == null) && (password == null);
  }

  @Override
  public IUserPassPair add(String username, String password)
      throws PairAlreadyInitializedException {
    if (!isEmpty()) {
      throw new PairAlreadyInitializedException();
    }
    return new UserPassPair(username, password);
  }

  @Override
  public IUserPassPair replace(String username, String password) throws PairEmptyException {
    if (isEmpty()) {
      throw new PairEmptyException();
    }
    return new UserPassPair(username, password);
  }

  @Override
  public IUserPassPair delete(String username) throws InvalidUsernameException {
    if (this.username != null && !username.equals(this.username)) {
      throw new InvalidUsernameException("username does not match");
    }
    // usernames are equal
    return new UserPassPair();
  }

  @Override
  public String getPassword(String username) throws InvalidUsernameException, PairEmptyException {
    if (isEmpty()) {
      throw new PairEmptyException();
    }
    if (!username.equals(this.username)) {
      throw new InvalidUsernameException("username does not match");
    }
    return this.password;
  }
}
