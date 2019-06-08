package edu.neu.khoury.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyListTest {

  private IListOfStrings list;

  @Before
  public void setUp() throws Exception {
    list = new EmptyList();
  }

  @Test
  public void isEmpty() {
    assertTrue(list.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(0, (int) list.size());
  }

  @Test
  public void contains() {
    assertFalse(list.contains("Anything"));
    assertFalse(list.contains(""));
  }

  @Test
  public void containsAll() {
    IListOfStrings consList = new Cons("Hello", new EmptyList());
    consList = consList.add("There");

    assertFalse(list.containsAll(consList));
    assertFalse(list.containsAll(new EmptyList()));
  }

  @Test
  public void filterLargerThan() {
    assertEquals(list, list.filterLargerThan(2));
    assertEquals(list, list.filterLargerThan(0));
  }

  @Test
  public void hasDuplicates() {
    assertFalse(list.hasDuplicates());
  }

  @Test
  public void removeDuplicates() {
    assertEquals(list, list.removeDuplicates());
  }

  @Test
  public void add() {
    IListOfStrings cons = new Cons("Hello", new EmptyList());
    assertEquals(cons, list.add("Hello"));
  }

  @Test
  public void equals1() {
    assertEquals(list, list);
    assertNotEquals(null, list);
    assertNotEquals("Hello", list);

    IListOfStrings empty = new EmptyList();
    assertEquals(empty, list);

    IListOfStrings cons = new Cons("Hello", empty);
    assertNotEquals(cons, list);
  }

  @Test
  public void hashCode1() {
    assertEquals(list.hashCode(), list.hashCode());
    assertEquals(new EmptyList().hashCode(), list.hashCode());

    IListOfStrings cons = new Cons("Hello", new EmptyList());
    assertNotEquals(cons.hashCode(), list.hashCode());
  }

  @Test
  public void getPayload() {
    assertNull(list.getPayload());
  }

  @Test
  public void getRest() {
    assertNull(list.getRest());
  }
}