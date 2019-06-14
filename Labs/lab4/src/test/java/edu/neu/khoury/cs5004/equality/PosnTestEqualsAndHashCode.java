package edu.neu.khoury.cs5004.equality;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PosnTestEqualsAndHashCode {

  private Posn pt1;
  private Posn pt2;
  private Posn pt3;  // One two three should be the same
  private Posn diff;

  @Before
  public void setUp() throws Exception {
    pt1 = new Posn(3, 4);
    pt2 = new Posn(3, 4);
    pt3 = new Posn(3, 4);
    diff = new Posn(5, 6);
  }

  @Test
  public void equals_Reflexive() {
    assertEquals(pt1, pt1);
    assertEquals(pt2, pt2);
    assertEquals(pt3, pt3);
    assertEquals(diff, diff);
  }

  @Test
  public void equals_Symmetric() {
    assertEquals(pt1, pt2);
    assertEquals(pt2, pt1);
  }

  @Test
  public void equals_Transitive() {
    assertEquals(pt1, pt2);
    assertEquals(pt2, pt3);
    assertEquals(pt1, pt3);
  }

  @Test
  public void equals_Consistent() {
    assertEquals(pt1, pt2);
    assertEquals(pt1, pt2);
    assertEquals(pt1, pt2);
    assertEquals(pt1, pt2);
    assertEquals(pt1, pt2);
  }

  @Test
  public void equals_Null() {
    assertNotEquals(pt1, null);
    assertNotEquals(pt2, null);
    assertNotEquals(pt3, null);
    assertNotEquals(diff, null);
  }

  @Test
  public void hashCode_Consistent() {
    int hash = pt1.hashCode();
    assertEquals(hash, pt1.hashCode());
    assertEquals(hash, pt1.hashCode());
    assertEquals(hash, pt1.hashCode());
    assertEquals(hash, pt1.hashCode());
    assertEquals(hash, pt1.hashCode());
    assertEquals(hash, pt1.hashCode());
  }

  @Test
  public void hashCode_Equality() {
    assertEquals(pt1.hashCode(), pt2.hashCode());
    assertEquals(pt2.hashCode(), pt3.hashCode());
    assertEquals(pt1.hashCode(), pt3.hashCode());
  }

  @Test
  public void hashCode_NotEqual() {
    assertNotEquals(pt1.hashCode(), diff.hashCode());
  }
}