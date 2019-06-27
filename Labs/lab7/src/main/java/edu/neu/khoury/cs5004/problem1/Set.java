package edu.neu.khoury.cs5004.problem1;

/**
 * {@code Set} defines the behavior of a mathematical set.
 *
 * @param <T> The type of objects held in the set
 * @author evandouglass
 */
public interface Set<T> {

  /**
   * Creates an empty set.
   *
   * @param <X> The type held by the new set
   * @return a new {@code ArraySet} with the same type
   */
  static <X> Set<X> emptySet() {
    return new EmptySet<>();
  }

  /**
   * Determines if this set is empty or not.
   *
   * @return true if the set is empty, else false
   */
  Boolean isEmpty();

  /**
   * Adds and element to the set. Ignores duplicate elements.
   *
   * @param element the element to add
   * @return the union of this set and a set of the given element
   */
  Set<T> add(T element);

  /**
   * Determines if this set contains the given element.
   *
   * @param element the element to test for
   * @return true if the set contains element, else false
   */
  Boolean contains(T element);

  /**
   * Removes an element from the set.
   *
   * @param element the element to remove
   * @return The difference of this set and a set with the given element
   */
  Set<T> remove(T element);

  /**
   * Determines the size of this set.
   *
   * @return the size of the set
   */
  Integer size();
}
