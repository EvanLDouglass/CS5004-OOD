package edu.neu.khoury.cs5004.problem2;

import java.util.Objects;

/**
 * An implementation of the Queue ADT using a circular linked
 * list.
 *
 * @author evandouglass
 */
public class CircularLinkedList<T> implements Queue<T> {

  private ListNode head;
  private ListNode tail;
  private Integer len;

  /**
   * Constructor for an empty list.
   */
  public CircularLinkedList() {
    head = null;
    tail = null;
    len = 0;
  }

  /* ===== Methods ===== */

  @Override
  public Boolean isEmpty() {
    return null;
  }

  @Override
  public void enqueue(T element) {

  }

  @Override
  public T dequeue() throws EmptyQueueException {
    return null;
  }

  @Override
  public void remove(T element) {

  }

  @Override
  public Integer size() {
    return null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CircularLinkedList<?> that = (CircularLinkedList<?>) o;
    return false;
  }

  @Override
  public int hashCode() {
    // TODO: Have to make this traverse the list
    return Objects.hash(head, tail, len);
  }

  @Override
  public String toString() {
    return null;
  }
}
