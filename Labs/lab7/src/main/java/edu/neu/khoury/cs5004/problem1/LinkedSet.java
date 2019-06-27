package edu.neu.khoury.cs5004.problem1;

/**
 * A generic set based on an array. This implementation is not very efficient, but I wanted to try
 * something different from our recursive structures.
 *
 * @param <T> the type of the set
 * @author evandouglass
 */
public class LinkedSet<T> implements Set<T> {

  private T element;
  private Set<T> rest;

  /**
   * Creates an empty ArraySet.
   *
   * @param element the element at this node
   * @param rest the rest of the set
   */
  public LinkedSet(T element, Set<T> rest) {
    this.element = element;
    this.rest = rest;
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public Set<T> add(T element) {
    if (contains(element)) {
      return this;
    }
    return new LinkedSet<T>(element, this);
  }

  @Override
  public Boolean contains(T element) {
    if (this.element.equals(element)) {
      return true;
    }
    return rest.contains(element);
  }

  @Override
  public Set<T> remove(T element) {
    if (this.element.equals(element)) {
      return rest.remove(element);
    }
    return new LinkedSet<>(this.element, rest.remove(element));
  }

  @Override
  public Integer size() {
    return 1 + rest.size();
  }
}
