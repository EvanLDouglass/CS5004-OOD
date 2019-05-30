package edu.neu.khoury.sc5004.problem1;

/**
 * IArtist contains functionality common to all artists in this package.
 *
 * @author evandouglass
 */
public interface IArtist {

  /**
   * Adds the given award to an artist's list of awards.
   *
   * @param award the award to add
   * @return a new artist with the new award
   */
  public IArtist receiveAward(String award);
}
