package edu.neu.khoury.cs5004.bagofwords;

import java.util.Objects;

/**
 * A recursive implementation of {@code BagOfWords}.
 *
 * @author evandouglass
 */
public class RecursiveBagOfWords implements BagOfWords {

  private String word;
  private BagOfWords rest;

  /**
   * Constructor for a {@code RecursiveBagOfWord}s.
   *
   * @param word a word to store in this "node"
   * @param rest the rest of the bag
   */
  public RecursiveBagOfWords(String word, BagOfWords rest) {
    this.word = word;
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
  public BagOfWords add(String str) {
    return new RecursiveBagOfWords(str, this);
  }

  @Override
  public Boolean contains(String str) {
    if (word.equals(str)) {
      return true;
    }
    return rest.contains(str);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    RecursiveBagOfWords that = (RecursiveBagOfWords) obj;
    return word.equals(that.word)
        && rest.equals(that.rest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(word, rest);
  }

}
