package edu.neu.khoury.cs5004.problem3;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

  @Test
  public void setChoiceAndPlay() {
    Player player = new Player();
    Rock rock = new Rock();
    player.setChoice(rock);
    assertEquals(rock, player.play());
  }
}