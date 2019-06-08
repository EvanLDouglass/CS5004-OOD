package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BusTest {

  private Bus bus;

  @Before
  public void setUp() throws Exception {
    bus = new Bus("12345", (float) 25.0, (float) 50.0);

  }

  @Test
  public void toString1() {
    String result = "Bus{ID:'12345', AvgSpeed:25.000000, MaxSpeed:50.000000}";
    assertEquals(result, bus.toString());
  }
}