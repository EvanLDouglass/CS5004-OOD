package edu.neu.khoury.cs5004.bagofwords;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RecursiveBagOfWordsTest {

  private BagOfWords bag;

  @Before
  public void setUp() throws Exception {
    bag = new RecursiveBagOfWords("hello",
        new RecursiveBagOfWords("you",
            new RecursiveBagOfWords("there",
                new RecursiveBagOfWords("hello",
                    new RecursiveBagOfWords("cats",
                        new EmptyBag()
                    )
                )
            )
        )
    );
  }

  @Test
  public void isEmpty() {
    assertFalse(bag.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(5, (int) bag.size());
  }

  @Test
  public void add() {
    bag = bag.add("another");
    assertEquals(6, (int) bag.size());
    assertTrue(bag.contains("another"));
  }

  @Test
  public void contains() {
    bag = bag.add("another");
    assertTrue(bag.contains("another"));
    bag = bag.add("two");
    assertTrue(bag.contains("two"));
  }

  @Test
  public void equals1() {
    BagOfWords other = new RecursiveBagOfWords("hello",
        new RecursiveBagOfWords("you",
            new RecursiveBagOfWords("there",
                new RecursiveBagOfWords("hello",
                    new RecursiveBagOfWords("cats",
                        new EmptyBag()
                    )
                )
            )
        )
    );
    assertEquals(other, bag);
    assertEquals(bag, other);
    bag = bag.add("another");
    assertNotEquals(bag, other);
    assertNotEquals(other, bag);
    bag = bag.add("hello");
    assertNotEquals(other, bag);
    assertNotEquals(bag, other);
  }

  @Test
  public void equals2() {
    assertEquals(bag, bag);
    assertNotEquals(null, bag);
    assertNotEquals("hello", bag);
  }

  @Test
  public void hashCode1() {
    BagOfWords other = new RecursiveBagOfWords("hello",
        new RecursiveBagOfWords("you",
            new RecursiveBagOfWords("there",
                new RecursiveBagOfWords("hello",
                    new RecursiveBagOfWords("cats",
                        new EmptyBag()
                    )
                )
            )
        )
    );
    assertEquals(other.hashCode(), bag.hashCode());
    bag = bag.add("another");
    assertNotEquals(bag.hashCode(), other.hashCode());
  }
}