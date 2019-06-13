package edu.neu.khoury.cs5004.bagofwords;

/**
 * The {@code BagOfWords} interface represents a collection of words from some text. This is a
 * multiset, so words can be repeated and they are in no particular order.
 *
 * @author evandouglass
 */
public interface BagOfWords {

  /**
   * Creates an empty {@code BagOfWords}.
   *
   * @return an empty BagOfWords
   */
  static BagOfWords emptyBagOfWords() {
    return new EmptyBag();
  }

  /**
   * Determines if this bag is empty or not.
   *
   * @return true if the bag is empty, else not
   */
  Boolean isEmpty();

  /**
   * Determines how many words are in this bag.
   *
   * @return the size of the bag
   */
  Integer size();

  /**
   * Returns a new {@code BagOfWords} with the elements of the calling bag and the given string.
   *
   * @param str the string to add
   * @return a new BagOfWords with the new word added
   */
  BagOfWords add(String str);

  /**
   * Determines if the given word is in this {@code BagOfWords}.
   *
   * @param str the word to test for
   * @return true if the word is found, else false
   */
  Boolean contains(String str);

  /**
   * Determines if another object is equivalent to this {@code BagOfWords}.
   *
   * @param obj the object to test
   * @return true if the objects are equivalent, else false
   */
  boolean equals(Object obj);

  /**
   * Calculates a hash code for this {@code BagOfWords}.
   *
   * @return a hash code
   */
  int hashCode();
}
