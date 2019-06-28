package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CircularLinkedListTest {

  private Queue<String> queue;

  @Before
  public void setUp() throws Exception {
    queue = new CircularLinkedList<>();
  }

  @Test
  public void isEmpty() {
    assertTrue(queue.isEmpty());
    queue.enqueue("Test");
    assertFalse(queue.isEmpty());
  }

  @Test
  public void enqueueAndDequeue1() throws EmptyQueueException {
    queue.enqueue("test");
    assertEquals("test", queue.dequeue());
  }

  @Test
  public void enqueueAndDequeue2() throws EmptyQueueException {
    queue.enqueue("test");
    queue.enqueue("hello");
    assertEquals("test", queue.dequeue());
    assertEquals("hello", queue.dequeue());
  }

  @Test
  public void enqueueAndDequeue3() throws EmptyQueueException {
    queue.enqueue("test");
    queue.enqueue("hello");
    queue.enqueue("another one");
    assertEquals("test", queue.dequeue());
    assertEquals("hello", queue.dequeue());
    assertEquals("another one", queue.dequeue());
  }

  @Test(expected = EmptyQueueException.class)
  public void dequeueEmpty() throws EmptyQueueException {
    queue.dequeue();
  }

  @Test
  public void removeFirst() throws EmptyQueueException {
    queue.enqueue("test");
    queue.enqueue("hello");
    queue.enqueue("another one");

    queue.remove("test");
    assertEquals("hello", queue.dequeue());
  }

  @Test
  public void removeMiddle() throws EmptyQueueException {
    queue.enqueue("test");
    queue.enqueue("hello");
    queue.enqueue("another one");

    queue.remove("hello");
    assertEquals("test", queue.dequeue());
    assertEquals("another one", queue.dequeue());
  }

  @Test
  public void removeLast() throws EmptyQueueException {
    queue.enqueue("test");
    queue.enqueue("hello");
    queue.enqueue("another one");

    queue.remove("another one");
    assertEquals("test", queue.dequeue());
    assertEquals("hello", queue.dequeue());
    try {
      queue.dequeue();
      fail("Queue should have been empty");
    } catch (EmptyQueueException e) {
      // Passed test
    }
  }

  @Test
  public void size() throws EmptyQueueException {
    assertEquals(0, (int) queue.size());

    // Add elements
    queue.enqueue("hello");
    assertEquals(1, (int) queue.size());
    queue.enqueue("hello");
    assertEquals(2, (int) queue.size());
    queue.enqueue("one more");
    assertEquals(3, (int) queue.size());

    // Remove elements
    queue.remove("one more");
    assertEquals(2, (int) queue.size());
    queue.dequeue();
    assertEquals(1, (int) queue.size());
    queue.dequeue();
    assertEquals(0, (int) queue.size());
  }

  @Test
  public void equals1() {
    Queue<String> queue1 = new CircularLinkedList<>();
    queue.enqueue("test1");
    queue1.enqueue("test1");
    queue.enqueue("test2");
    queue1.enqueue("test2");
    queue.enqueue("test3");
    queue1.enqueue("test3");

    assertEquals(queue, queue1);
    assertEquals(queue1, queue);
    assertEquals(queue, queue);
  }

  @Test
  public void equalsDiffLength() {
    Queue<String> queue1 = new CircularLinkedList<>();
    queue.enqueue("test1");
    queue1.enqueue("test1");
    queue.enqueue("test2");
    queue.enqueue("test3");

    assertNotEquals(queue1, queue);
    assertNotEquals(queue, queue1);
  }

  @Test
  public void notEqualsBasic() {
    assertNotEquals(queue, null);
    assertNotEquals(queue, "Not a Queue");
  }

  @Test
  public void notEqualsSameLength1() {
    Queue<String> queue1 = new CircularLinkedList<>();
    queue.enqueue("test1");
    queue1.enqueue("test3");
    queue.enqueue("test2");
    queue1.enqueue("test2");
    queue.enqueue("test3");
    queue1.enqueue("test3");

    assertNotEquals(queue1, queue);
  }

  @Test
  public void notEqualsSameLength2() {
    Queue<String> queue1 = new CircularLinkedList<>();
    queue.enqueue("test1");
    queue1.enqueue("test1");
    queue.enqueue("test2");
    queue1.enqueue("test5");
    queue.enqueue("test3");
    queue1.enqueue("test3");

    assertNotEquals(queue1, queue);
  }

  @Test
  public void notEqualsSameLength3() {
    Queue<String> queue1 = new CircularLinkedList<>();
    queue.enqueue("test1");
    queue1.enqueue("test1");
    queue.enqueue("test2");
    queue1.enqueue("test2");
    queue.enqueue("test3");
    queue1.enqueue("test1");

    assertNotEquals(queue1, queue);
  }

  @Test
  public void hashCode1() throws EmptyQueueException {
    Queue<String> queue1 = new CircularLinkedList<>();
    queue.enqueue("test1");
    queue1.enqueue("test1");
    queue.enqueue("test2");
    queue1.enqueue("test2");
    queue.enqueue("test3");
    queue1.enqueue("test3");

    assertEquals(queue.hashCode(), queue.hashCode());
    assertEquals(queue1.hashCode(), queue.hashCode());

    // Diff lengths
    queue1.enqueue("test4");
    assertNotEquals(queue1.hashCode(), queue.hashCode());

    // Same length, diff elements
    queue1.dequeue();
    assertNotEquals(queue1.hashCode(), queue.hashCode());
  }

  @Test
  public void toString1() {
    String expected = "DoublyLinkedList{test, test, another test, hello}";

    queue.enqueue("test");
    queue.enqueue("test");
    queue.enqueue("another test");
    queue.enqueue("hello");

    assertEquals(expected, queue.toString());
  }
}