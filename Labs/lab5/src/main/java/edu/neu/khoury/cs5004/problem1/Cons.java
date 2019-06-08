package edu.neu.khoury.cs5004.problem1;

import java.util.Objects;

/**
 * {@code Cons} represents a list of strings that contains at least one element.
 *
 * @author evandouglass
 */
public class Cons implements IListOfStrings {

  private String payload;
  private IListOfStrings rest;

  /**
   * Constructor for Cons with both a payload and the rest of the list.
   *
   * @param payload the string this "node" should have
   * @param rest the rest of the list
   */
  public Cons(String payload, IListOfStrings rest) {
    this.payload = payload;
    this.rest = rest;
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public Integer size() {
    return 1 + rest.size();
  }

  @Override
  public Boolean contains(String str) {
    if (payload.equals(str)) {
      return true;
    }
    if (rest.isEmpty()) {
      return false;
    }
    return rest.contains(str);
  }

  @Override
  public Boolean containsAll(IListOfStrings strs) {
    if (strs.isEmpty()) {
      return true;
    }

    Boolean hasOne = this.contains(strs.getPayload());
    if (! hasOne) {
      return false;
    }

    strs = strs.getRest();
    return this.containsAll(strs);
  }

  @Override
  public IListOfStrings filterLargerThan(Integer len) {
    if (payload.length() <= len) {  // at least one payload if method called
      return new Cons(payload, rest.filterLargerThan(len));
    }
    return rest.filterLargerThan(len);
  }

  @Override
  public Boolean hasDuplicates() {
    if (rest.isEmpty()) {
      return false;
    }
    if (rest.contains(payload)) {
      return true;
    }
    return rest.hasDuplicates();
  }

  @Override
  public IListOfStrings removeDuplicates() {
    if (! rest.contains(payload)) {
      return new Cons(payload, rest.removeDuplicates());
    }
    return rest.removeDuplicates();
  }

  @Override
  public IListOfStrings add(String str) {
    return new Cons(str, this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cons cons = (Cons) o;
    return payload.equals(cons.payload) &&
        rest.equals(cons.rest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payload, rest);
  }

  @Override
  public String getPayload() {
    return payload;
  }

  @Override
  public IListOfStrings getRest() {
    return rest;
  }
}
