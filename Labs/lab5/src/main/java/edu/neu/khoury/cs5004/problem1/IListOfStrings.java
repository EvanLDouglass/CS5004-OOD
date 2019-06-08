package edu.neu.khoury.cs5004.problem1;

/**
 * This interface describes a list ADT with String payloads.
 *
 * @author evandouglass
 */
public interface IListOfStrings {

  /**
   * Checks whether or not the list is empty.
   *
   * @return true if the list is empty, else false
   */
  Boolean isEmpty();

  /**
   * Gets the total number of elements in the list.
   *
   * @return the size of the list as an integer
   */
  Integer size();

  /**
   * Checks if the list contains the given string.
   *
   * @param str the string to check against
   * @return true if the list contains the string, else false
   */
  Boolean contains(String str);

  /**
   * Checks if the list contains all of the strings in the given list.
   *
   * @param strs a list of strings to check
   * @return true if this list contains all of the given strings, else false
   */
  Boolean containsAll(IListOfStrings strs);

  /**
   * Creates a list that has only the elements in this list that have a shorter length than the
   * number given.
   *
   * @param len the maximum length to filter on
   * @return a list with only those strings that are smaller than or equal to the max length
   */
  IListOfStrings filterLargerThan(Integer len);

  /**
   * Checks if this list has any duplicate elements.
   *
   * @return true if there are duplicate elements, else false
   */
  Boolean hasDuplicates();

  /**
   * Removes any duplicate elements from this list.
   *
   * @return A list with any duplicates removed
   */
  IListOfStrings removeDuplicates();

  /**
   * Prepends the given string to this list.
   *
   * @param str the string to add
   * @return the new list with this string
   */
  IListOfStrings add(String str);

  /**
   * Test equality between this and another object.
   *
   * @param o the object to test
   * @return true if the objects are equal, else false
   */
  boolean equals(Object o);

  /**
   * Generates a hash code for this object.
   *
   * @return a hash code
   */
  int hashCode();

  /**
   * Get the string payload.
   *
   * @return the string payload
   */
  String getPayload();

  /**
   * Gets the rest of this list.
   *
   * @return the rest of the list
   */
  IListOfStrings getRest();
}
