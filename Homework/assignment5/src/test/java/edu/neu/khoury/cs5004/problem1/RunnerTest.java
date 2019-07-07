package edu.neu.khoury.cs5004.problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class RunnerTest {

  private Runner runner;

  @Before
  public void setUp() throws Exception {
    List<Double> fiveK = new ArrayList<>(3);
    fiveK.add(1.2);
    fiveK.add(2.3);
    fiveK.add(3.4);

    List<Double> tenK = new ArrayList<>(3);
    tenK.add(5.6);
    tenK.add(6.7);
    tenK.add(7.8);

    List<Double> halfMar = new ArrayList<>(3);
    halfMar.add(10.11);
    halfMar.add(11.12);
    halfMar.add(12.13);

    runner = new Runner("Evan", fiveK, tenK, halfMar);
  }

  @Test
  public void getName() {
    assertEquals("Evan", runner.getName());
  }

  @Test
  public void getFiveKRaceTimes() {
    List<Double> expected = new ArrayList<>(3);
    expected.add(1.2);
    expected.add(2.3);
    expected.add(3.4);
    assertEquals(expected, runner.getFiveKRaceTimes());
  }

  @Test
  public void getTenKRaceTimes() {
    List<Double> expected = new ArrayList<>(3);
    expected.add(5.6);
    expected.add(6.7);
    expected.add(7.8);
    assertEquals(expected, runner.getTenKRaceTimes());
  }

  @Test
  public void getHalfMarathonTimes() {
    List<Double> expected = new ArrayList<>(3);
    expected.add(10.11);
    expected.add(11.12);
    expected.add(12.13);
    assertEquals(expected, runner.getHalfMarathonTimes());
  }

  @Test
  public void compareToLower() {
    List<Double> fiveK = new ArrayList<>(3);
    fiveK.add(0.2);
    fiveK.add(1.3);
    fiveK.add(2.4);

    List<Double> tenK = new ArrayList<>();
    List<Double> halfMar = new ArrayList<>();

    Runner other = new Runner("Evan", fiveK, tenK, halfMar);

    assertTrue(runner.compareTo(other) > 0);
  }

  @Test
  public void compareToNoRaces() {
    List<Double> fiveK = new ArrayList<>();
    List<Double> tenK = new ArrayList<>();
    List<Double> halfMar = new ArrayList<>();

    Runner other = new Runner("Evan", fiveK, tenK, halfMar);

    assertTrue(runner.compareTo(other) > 0);
  }

  @Test
  public void compareToHigher() {
    List<Double> fiveK = new ArrayList<>(3);
    fiveK.add(4.2);
    fiveK.add(5.3);
    fiveK.add(6.4);

    List<Double> tenK = new ArrayList<>();
    List<Double> halfMar = new ArrayList<>();

    Runner other = new Runner("Evan", fiveK, tenK, halfMar);

    assertTrue(runner.compareTo(other) < 0);
  }

  @Test
  public void compareToSame() {
    List<Double> fiveK = new ArrayList<>(3);
    fiveK.add(1.2);
    fiveK.add(2.3);
    fiveK.add(3.4);

    List<Double> tenK = new ArrayList<>();
    List<Double> halfMar = new ArrayList<>();

    Runner other = new Runner("Evan", fiveK, tenK, halfMar);

    assertTrue(runner.compareTo(other) == 0);
  }
}