package edu.neu.khoury.cs5004.problem1;

/**
 * {@code EmptyIList} represents an empty list. It is used in the recursive implementation of a
 * {@code IListOfStrings}.
 *
 * @author evandouglass
 */
public class EmptyList implements IListOfStrings {

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Boolean contains(String str) {
    return false;
  }

  @Override
  public Boolean containsAll(IListOfStrings strs) {
    return false;
  }

  @Override
  public IListOfStrings filterLargerThan(Integer len) {
    return this;
  }

  @Override
  public Boolean hasDuplicates() {
    return false;
  }

  @Override
  public IListOfStrings removeDuplicates() {
    return this;
  }

  @Override
  public IListOfStrings add(String str) {
    return new Cons(str, this);
  }

  @Override
  public int hashCode() {
    return 0;  // empty lists should have the same hash code
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    // If classes are the same, then these objects are equal
    return true;
  }

  @Override
  public String getPayload() {
    return null;
  }

  @Override
  public IListOfStrings getRest() {
    return null;
  }
}
