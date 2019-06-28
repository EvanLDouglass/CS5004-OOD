package edu.neu.khoury.cs5004.problem2;

/**
 * Describes a queue data structure and it's behaviors.
 *
 * @author evandouglass
 */
public interface Queue<T> {

  /**
   * Generates an empty {@code Queue}.
   *
   * @return a new empty Queue
   */
  static <X> Queue<X> create() {
    return new CircularLinkedList<>();
  }

  /**
   * Determines if the {@code Queue} is empty.
   *
   * @return true if the Queue is empty, else false
   */
  Boolean isEmpty();

  /**
   * Adds an element to the end of the {@code Queue}.
   *
   * @param element the element to put in the Queue
   */
  void enqueue(T element);

  /**
   * Removes and returns the element from the beginning of the {@code Queue}.
   *
   * @return the element at the front of the Queue
   * @throws EmptyQueueException if called on an empty list
   */
  T dequeue() throws EmptyQueueException;

  /**
   * Removes the first occurrence of the given element from the {@code Queue} regardless of it's
   * position. This operation has no effect on an empty {@code Queue}, or one without the given
   * element.
   *
   * @param element the element to remove.
   */
  void remove(T element);

  /**
   * Returns the number of elements in the {@code Queue}.
   *
   * @return the number of elements
   */
  Integer size();
}
