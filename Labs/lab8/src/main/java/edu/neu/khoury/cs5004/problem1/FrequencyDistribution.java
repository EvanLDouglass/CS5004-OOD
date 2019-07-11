package edu.neu.khoury.cs5004.problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains a single method that generates a relative frequency map from an input list.
 *
 * @author evandouglass
 */
public class FrequencyDistribution {

  /**
   * Takes a list and returns a relative frequency map of the items in the list.
   *
   * @param list a list on which to perform the frequency count
   * @param <T> The type of the given list
   * @return a {@code Map} containing each unique item in the given list, paired with it's relative
   * frequency of occurrence.
   */
  public static <T> Map<T, Double> relativeFrequencyCount(List<T> list) {
    // Get frequency for each item
    Map<T, Double> freqMap = new HashMap<>();
    freqCount(list, freqMap);

    // Calculate relative frequency for each item
    Integer len = list.size();
    calcRelativeFrequency(freqMap, len);

    return freqMap;
  }

  /**
   * Calculates a frequency count from the given list, stored in the given map.
   *
   * @param list the list to count
   * @param map the storage map
   * @param <T> the type of object in the list
   */
  private static <T> void freqCount(List<T> list, Map<T, Double> map) {
    for (T item : list) {
      Double count = map.getOrDefault(item, 0.0);
      map.put(item, (count + 1.0));
    }
  }

  /**
   * Calculates the relative frequency of frequencies in the frequency map, given the original size
   * of the dataset.
   *
   * @param freqMap a map of items to frequencies
   * @param originalSize the original size of the data set that was used to build the map
   * @param <T> the type of the keys in the map
   */
  private static <T> void calcRelativeFrequency(Map<T, Double> freqMap, Integer originalSize) {
    for (T key : freqMap.keySet()) {
      Double freq = freqMap.get(key);
      freqMap.put(key, (freq / originalSize));
    }
  }
}
