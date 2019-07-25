package edu.neu.khoury.cs5004.problem2;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TrendingTopics {

  /**
   * Counts the number of occurrences of each string in the given list, and returns
   * the count in the form of a Map.
   *
   * @param list a list of strings
   * @return a map from each unique string to the number of times it occurs
   */
  public Map<String, Integer> countTopics(List<String> list) {
    List<String> unique = list.stream().distinct().collect(Collectors.toList());
    return unique.stream()
        .collect(Collectors.toMap(Function.identity(),  // The string itself
            str -> Collections.frequency(list, str))    // The number of times it occurs in list
    );
  }
}
