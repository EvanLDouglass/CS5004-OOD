package edu.neu.khoury.cs5004.problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class FrequencyDistributionTest {

  private List<Integer> ints;

  @Before
  public void setUp() throws Exception {
    ints = new ArrayList<>();
  }

  @Test
  public void freqCount_Basic_Ints() {
    ints.add(68);
    ints.add(86);
    ints.add(86);
    ints.add(80);
    ints.add(68);
    ints.add(55);
    ints.add(68);
    ints.add(68);
    ints.add(95);
    ints.add(-45);
    Map<Integer, Double> intMap = FrequencyDistribution.relativeFrequencyCount(ints);
    assertEquals(0.4, intMap.get(68), 0.0000001);
    assertEquals(0.2, intMap.get(86), 0.0000001);
    assertEquals(0.1, intMap.get(80), 0.0000001);
    assertEquals(0.1, intMap.get(55), 0.0000001);
    assertEquals(0.1, intMap.get(95), 0.0000001);
    assertEquals(0.1, intMap.get(-45), 0.0000001);
  }

  @Test
  public void freqCount_Basic_Strs() {
    List<String> strs = new ArrayList<>();
    strs.add("T");
    strs.add("z");
    strs.add("p");
    strs.add("1");
    strs.add("T");
    strs.add("T");
    strs.add("p");
    strs.add("p");
    strs.add("p");
    strs.add("p");
    Map<String, Double> strMap = FrequencyDistribution.relativeFrequencyCount(strs);
    assertEquals(0.3, strMap.get("T"), 0.0000001);
    assertEquals(0.1, strMap.get("z"), 0.0000001);
    assertEquals(0.5, strMap.get("p"), 0.0000001);
    assertEquals(0.1, strMap.get("1"), 0.0000001);
  }

  @Test
  public void freqCount_AllSingleValue() {
    ints.add(2);
    ints.add(2);
    ints.add(2);
    ints.add(2);
    Map<Integer, Double> intMap = FrequencyDistribution.relativeFrequencyCount(ints);
    assertEquals(1.0, intMap.get(2), 0.00000001);
  }
}