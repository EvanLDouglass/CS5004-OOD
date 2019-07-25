package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class TrendingTopicsTest {

  private TrendingTopics topics;
  private List<String> list;

  @Before
  public void setUp() throws Exception {
    String toSplit = "Seattle,wildfires,DEFCON26,NEU,NEU,Seattle,Seattle,NEU,DEFCON26,wildfires";
    list = Arrays.asList(toSplit.split(","));
    topics = new TrendingTopics();
  }

  @Test
  public void countTopics() {
    Map<String, Integer> expected = new HashMap<>();
    expected.put("Seattle", 3);
    expected.put("wildfires", 2);
    expected.put("DEFCON26", 2);
    expected.put("NEU", 3);

    Map<String, Integer> actual = topics.countTopics(list);
    assertEquals(expected, actual);
  }
}