package edu.neu.khoury.cs5004.problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RockTest {

  private Rock rock;
  private IState state;

  @Before
  public void setUp() throws Exception {
    rock = new Rock();
    state = new Rock();
  }

  @Test
  public void beats() {
    assertTrue(rock.beats(new Scissors()));
    assertTrue(state.beats(new Scissors()));

    assertFalse(rock.beats(new Paper()));
    assertFalse(rock.beats(new Rock()));
    assertFalse(state.beats(new Paper()));
    assertFalse(state.beats(new Rock()));
  }

  @Test
  public void getType() {
    assertEquals(RPS.ROCK, rock.getType());
    assertEquals(RPS.ROCK, state.getType());
  }
}