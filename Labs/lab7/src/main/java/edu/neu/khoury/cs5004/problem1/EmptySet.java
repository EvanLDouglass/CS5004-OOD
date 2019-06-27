package edu.neu.khoury.cs5004.problem1;

/**
 * An empty set used in a recursive, linked implementation for {@code Set}.
 *
 * @param <T> The type of object that the set will hold.
 */
public class EmptySet<T> implements Set<T> {

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public Set<T> add(T element) {
    return new LinkedSet<>(element, this);
  }

  @Override
  public Boolean contains(T element) {
    return false;
  }

  @Override
  public Set<T> remove(T element) {
    return this;
  }

  @Override
  public Integer size() {
    return 0;
  }
}
