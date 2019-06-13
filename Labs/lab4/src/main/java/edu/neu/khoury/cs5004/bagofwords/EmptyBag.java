package edu.neu.khoury.cs5004.bagofwords;


public class EmptyBag implements BagOfWords {

  private static final int HASH = 1234;

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public BagOfWords add(String str) {
    return new RecursiveBagOfWords(str, this);
  }

  @Override
  public Boolean contains(String str) {
    return false;
  }

  @Override
  public int hashCode() {
    return HASH;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    // concrete class is the same, so must be equivalent
    return true;
  }
}
