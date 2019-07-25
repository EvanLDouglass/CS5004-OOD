package edu.neu.khoury.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HomebakeDataTest {

  private HomebakeData data;

  @Before
  public void setUp() throws Exception {
    String[] args = new String[]{"install", "chrome", "-q", "-v"};
    data = new HomebakeData(args);
  }

  @Test
  public void getFormula() {
    assertEquals("chrome", data.getFormula());
  }

  @Test
  public void getWarningsFlag() {
    assertTrue(data.getWarningsFlag());
  }

  @Test
  public void getVerboseFlag() {
    assertTrue(data.getVerboseFlag());
  }

  @Test
  public void getDebugFlag() {
    assertFalse(data.getDebugFlag());
  }
}