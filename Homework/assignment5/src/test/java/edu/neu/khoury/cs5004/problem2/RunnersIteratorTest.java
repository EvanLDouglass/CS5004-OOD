package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.khoury.cs5004.problem1.Runner;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class RunnersIteratorTest {

  private List<Runner> runners;
  private RunnersIterator iter;

  private Runner run1;
  private Runner run2;
  private Runner run3;
  private Runner run4;
  private Runner run5;
  private Runner run6;
  private Runner run7;
  private Runner run8;
  private Runner run9;

  @Before
  public void setUp() throws Exception {
    // First set up run time lists for runners
    List<Double> threeFiveK = new ArrayList<>(3);
    threeFiveK.add(1.2);
    threeFiveK.add(2.3);
    threeFiveK.add(3.4);

    List<Double> fiveFiveK = new ArrayList<>(5);
    fiveFiveK.add(4.5);
    fiveFiveK.add(5.5);
    fiveFiveK.add(6.7);
    fiveFiveK.add(10.0);
    fiveFiveK.add(2.3);

    List<Double> sixFiveK = new ArrayList<>(6);
    sixFiveK.add(2.2);
    sixFiveK.add(4.3);
    sixFiveK.add(1.34);
    sixFiveK.add(5.4);
    sixFiveK.add(2.0);
    sixFiveK.add(6.54321);

    List<Double> tenK = new ArrayList<>();

    List<Double> noQualHalfMar = new ArrayList<>(3);
    noQualHalfMar.add(10.11);
    noQualHalfMar.add(11.12);
    noQualHalfMar.add(12.13);

    List<Double> oneQualHalfMar = new ArrayList<>(3);
    oneQualHalfMar.add(12.2);
    oneQualHalfMar.add(9.9999);
    oneQualHalfMar.add(13.2);

    List<Double> twoQualHalfMar = new ArrayList<>(3);
    twoQualHalfMar.add(9.8);
    twoQualHalfMar.add(10.0);
    twoQualHalfMar.add(7.999);

    // Setup runners
    run1 = new Runner("three 5k, no half", threeFiveK, tenK, noQualHalfMar);
    run2 = new Runner("five 5k, no half", fiveFiveK, tenK, noQualHalfMar);
    run3 = new Runner("six 5k, no half", sixFiveK, tenK, noQualHalfMar);
    run4 = new Runner("three 5k, one half", threeFiveK, tenK, oneQualHalfMar);
    run5 = new Runner("five 5k, one half", fiveFiveK, tenK, oneQualHalfMar);
    run6 = new Runner("six 5k, one half", sixFiveK, tenK, oneQualHalfMar);
    run7 = new Runner("three 5k, two half", threeFiveK, tenK, twoQualHalfMar);
    run8 = new Runner("five 5k, two half", fiveFiveK, tenK, twoQualHalfMar);
    run9 = new Runner("six 5k, two half", sixFiveK, tenK, twoQualHalfMar);

    // Setup list of runners
    runners = new ArrayList<>(9);
    runners.add(run1);
    runners.add(run2);
    runners.add(run3);
    runners.add(run4);
    runners.add(run5);
    runners.add(run6);
    runners.add(run7);
    runners.add(run8);
    runners.add(run9);

    // Setup iterator
    iter = new RunnersIterator(runners);
  }

  @Test
  public void hasNext() {
    assertTrue(iter.hasNext());
  }

  @Test
  public void notHasNext() {
    iter = new RunnersIterator(new ArrayList<>());
    assertFalse(iter.hasNext());
  }

  @Test
  public void next() {
    assertEquals(run2, iter.next());
    assertEquals(run3, iter.next());
    assertEquals(run4, iter.next());
    assertEquals(run5, iter.next());
    assertEquals(run6, iter.next());
    assertEquals(run7, iter.next());
    assertEquals(run8, iter.next());
    assertEquals(run9, iter.next());
    assertFalse(iter.hasNext());
  }
}