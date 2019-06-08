package edu.neu.khoury.cs5004.problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScissorsTest {

  private Scissors scissors;
  private IState state;

  @Before
  public void setUp() throws Exception {
    scissors = new Scissors();
    state = new Scissors();
  }

  @Test
  public void beats() {
    assertTrue(scissors.beats(new Paper()));
    assertTrue(state.beats(new Paper()));

    assertFalse(scissors.beats(new Rock()));
    assertFalse(scissors.beats(new Scissors()));
    assertFalse(state.beats(new Rock()));
    assertFalse(state.beats(new Scissors()));
  }

  @Test
  public void getType() {
    assertEquals(RPS.SCISSORS, scissors.getType());
    assertEquals(RPS.SCISSORS, state.getType());
  }
}