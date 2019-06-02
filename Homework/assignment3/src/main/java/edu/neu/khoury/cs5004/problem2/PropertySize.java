package edu.neu.khoury.cs5004.problem2;

/**
 * Enum for classifying property sizes.
 *
 * @author evandouglass
 */
public enum PropertySize {
  SMALL {
    @Override
    public String toString() {
      return "Small";
    }
  },
  MEDIUM {
    @Override
    public String toString() {
      return "Medium";
    }
  },
  LARGE {
    @Override
    public String toString() {
      return "Large";
    }
  }
}
