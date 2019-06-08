package edu.neu.khoury.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConsTest {

  private IListOfStrings cons;

  @Before
  public void setUp() throws Exception {
    cons = new Cons("Hello", new EmptyList());
  }

  @Test
  public void isEmpty() {
    assertFalse(cons.isEmpty());

    cons.add("There");
    assertFalse(cons.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(1, (int) cons.size());

    cons = cons.add("There");
    assertEquals(2, (int) cons.size());

    cons = cons.add("You");
    assertEquals(3, (int) cons.size());
  }

  @Test
  public void contains() {
    assertTrue(cons.contains("Hello"));
    assertFalse(cons.contains("There"));

    cons = cons.add("There");
    assertTrue(cons.contains("There"));
  }

  @Test
  public void containsAll() {
    IListOfStrings other = new Cons("There",
        new Cons("Hello",
            new Cons("You",
                new Cons("Test",
                    new EmptyList()))));
    assertFalse(cons.containsAll(other));
    cons = cons.add("There");
    assertFalse(cons.containsAll(other));
    cons = cons.add("Test");
    assertFalse(cons.containsAll(other));
    cons = cons.add("You");
    assertTrue(cons.containsAll(other));
  }

  @Test
  public void filterLargerThan() {
    cons = new Cons("There",
        new Cons("Hello",
            new Cons("You",
                new Cons("Test",
                    new EmptyList()))));
    IListOfStrings newCons = cons.filterLargerThan(4);
    IListOfStrings expected = new Cons("You", new Cons("Test", new EmptyList()));
    assertEquals(expected, newCons);

    newCons = cons.filterLargerThan(3);
    expected = new Cons("You", new EmptyList());
    assertEquals(expected, newCons);

    newCons = cons.filterLargerThan(80);
    assertEquals(cons, newCons);

    newCons = cons.filterLargerThan(0);
    assertEquals(new EmptyList(), newCons);
  }

  @Test
  public void hasDuplicates() {
    cons = new Cons("There",
        new Cons("Hello",
            new Cons("You",
                new Cons("Test",
                    new EmptyList()))));
    assertFalse(cons.hasDuplicates());

    cons = cons.add("Test");
    assertTrue(cons.hasDuplicates());
  }

  @Test
  public void removeDuplicates() {
    cons = new Cons("There",
        new Cons("Hello",
            new Cons("You",
                new Cons("Test",
                    new Cons("You",
                        new EmptyList())))));
    IListOfStrings expected = new Cons("There",
        new Cons("Hello",
            new Cons("Test",
                new Cons("You",
                    new EmptyList()))));
    cons = cons.removeDuplicates();
    assertEquals(expected, cons);
    assertEquals(expected, cons.removeDuplicates());
  }

  @Test
  public void add() {
    assertFalse(cons.contains("There"));
    cons = cons.add("There");
    assertTrue(cons.contains("There"));
  }

  @Test
  public void equals1() {
    IListOfStrings other = new Cons("Hello", new EmptyList());
    assertEquals(other, cons);

    cons = cons.add("There");
    assertNotEquals(other, cons);

    other = other.add("There");
    assertEquals(other, cons);

    assertEquals(cons, cons);
    assertNotEquals(null, cons);
    assertNotEquals("Hello", cons);
  }

  @Test
  public void hashCode1() {
    IListOfStrings other = new Cons("Hello", new EmptyList());
    assertEquals(other.hashCode(), cons.hashCode());

    other = new Cons("hello", new EmptyList());
    assertNotEquals(other.hashCode(), cons.hashCode());

    assertNotEquals(new EmptyList().hashCode(), cons.hashCode());
  }

  @Test
  public void getPayload() {
    assertEquals("Hello", cons.getPayload());
  }

  @Test
  public void getRest() {
    assertEquals(new EmptyList(), cons.getRest());
    cons.add("There");
  }
}