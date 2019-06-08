package edu.neu.khoury.cs5004.problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaperTest {

  private Paper paper;
  private IState state;

  @Before
  public void setUp() throws Exception {
    paper = new Paper();
    state = new Paper();
  }

  @Test
  public void beats() {
    assertTrue(paper.beats(new Rock()));
    assertTrue(state.beats(new Rock()));

    assertFalse(paper.beats(new Scissors()));
    assertFalse(state.beats(new Scissors()));
    assertFalse(paper.beats(new Paper()));
    assertFalse(state.beats(new Paper()));
  }

  @Test
  public void getType() {
    assertEquals(RPS.PAPER, paper.getType());
    assertEquals(RPS.PAPER, state.getType());
  }
}