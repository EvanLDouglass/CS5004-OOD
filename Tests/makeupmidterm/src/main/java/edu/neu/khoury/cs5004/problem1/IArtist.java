package edu.neu.khoury.cs5004.problem1;

public interface IArtist {

  /**
   * Getter for awards
   *
   * @return awards
   */
  String[] getAwards();

  /**
   * Setter for awards
   *
   * @param awards new awards
   */
  void setAwards(String[] awards);

  /**
   * Getter for last year of appearance.
   *
   * @return last year of apperance
   */
  Integer getYearOfLastApperance();

  /**
   * Setter for last year of appearance
   *
   * @param yearOfLastApperance new last year
   */
  void setYearOfLastApperance(Integer yearOfLastApperance);

  /**
   * Getter for gross income of last appearance
   *
   * @return income of last appearance
   */
  Double getGrossIncomeOfLastApperance();

  /**
   * Setter for gross income of last appearance
   *
   * @param grossIncomeOfLastApperance new gross income
   */
  void setGrossIncomeOfLastApperance(Double grossIncomeOfLastApperance);
}
