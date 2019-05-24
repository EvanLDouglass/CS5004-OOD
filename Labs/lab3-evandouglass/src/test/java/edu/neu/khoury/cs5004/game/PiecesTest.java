package edu.neu.khoury.cs5004.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PiecesTest {

  public class ConcretePieces extends Pieces {

    public ConcretePieces(Name name, Age age) {
      super(name, age);
    }
  }

  private ConcretePieces p;

  @Before
  public void setUp() throws Exception {
    p = new ConcretePieces(
        new Name("Evan", "Douglass"),
        new Age(28)
    );
  }

  @Test
  public void getName() {
    Name n = new Name("Evan", "Douglass");
    assertEquals(n, p.getName());
  }

  @Test
  public void getAge() throws IncorrectAgeRangeException {
    Age a = new Age(28);
    assertEquals(a, p.getAge());
  }

  @Test
  public void equals1() throws IncorrectAgeRangeException {
    ConcretePieces p1 = new ConcretePieces(
        new Name("Evan", "Douglass"),
        new Age(28)
    );
    assertEquals(p1, p);
  }
}