package edu.neu.khoury.cs5004.problem1;

/**
 * Describes behavior of a celebrity influencer.
 *
 * @author evandouglass
 */
public interface ICelebrity {

  /**
   * Getter for last appearance.
   *
   * @return the last appearance
   */
  String getLastAppearanceEvent();

  /**
   * Setter for last appearance.
   *
   * @param lastAppearanceEvent new last appearance
   */
  void setLastAppearanceEvent(String lastAppearanceEvent);
}
