package edu.neu.khoury.cs5004.assignment4.problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class UserPassPairTest {

  private IUserPassPair uPPair;

  @Before
  public void setUp() throws Exception {
    uPPair = IUserPassPair.createEmpty();
    uPPair = uPPair.add("evandouglass", "123456");

  }

  @Test
  public void isEmpty() {
    assertFalse(uPPair.isEmpty());
    uPPair = IUserPassPair.createEmpty();
    assertTrue(uPPair.isEmpty());
  }

  @Test
  public void add()
      throws PairEmptyException, InvalidUsernameException, PairAlreadyInitializedException {
    uPPair = IUserPassPair.createEmpty();
    uPPair = uPPair.add("evandoug", "654321");
    assertEquals("654321", uPPair.getPassword("evandoug"));
  }

  @Test(expected = PairAlreadyInitializedException.class)
  public void addToInitialized() throws PairAlreadyInitializedException {
    uPPair.add("evandoug", "654321");
  }

  @Test
  public void replace() throws PairEmptyException, InvalidUsernameException {
    uPPair = uPPair.replace("dougevan", "abcdefg");
    assertEquals("abcdefg", uPPair.getPassword("dougevan"));
  }

  @Test(expected = PairEmptyException.class)
  public void replaceOnEmptyPair() throws PairEmptyException {
    uPPair = IUserPassPair.createEmpty();
    uPPair.replace("hello", "there");
  }

  @Test
  public void delete() throws InvalidUsernameException {
    uPPair = uPPair.delete("evandouglass");
    assertTrue(uPPair.isEmpty());
  }

  @Test
  public void deleteFromEmpty() throws InvalidUsernameException {
    uPPair = uPPair.delete("evandouglass");
    assertTrue(uPPair.isEmpty());

    // Try again from empty pair
    try {
      uPPair = uPPair.delete("evandouglass");
      assertTrue(uPPair.isEmpty());
    } catch (InvalidUsernameException e) {
      fail("should not throw exception on empty pair");
    }
  }

  @Test(expected = InvalidUsernameException.class)
  public void deleteWrongUsername() throws InvalidUsernameException {
    uPPair = uPPair.delete("EvanDouglass");
  }

  @Test
  public void getPassword() throws PairEmptyException, InvalidUsernameException {
    assertEquals("123456", uPPair.getPassword("evandouglass"));
  }

  @Test(expected = PairEmptyException.class)
  public void getPasswordFromEmptyPair() throws InvalidUsernameException, PairEmptyException {
    uPPair = IUserPassPair.createEmpty();
    uPPair.getPassword("evandouglass");
  }

  @Test(expected = InvalidUsernameException.class)
  public void getPasswordWithWrongUsername() throws PairEmptyException, InvalidUsernameException {
    uPPair.getPassword("seandouglass");
  }
}