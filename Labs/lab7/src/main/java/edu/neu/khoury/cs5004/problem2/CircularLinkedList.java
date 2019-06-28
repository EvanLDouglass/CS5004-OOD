package edu.neu.khoury.cs5004.problem2;

import java.util.Objects;

/**
 * An implementation of the Queue ADT using a circular linked list.
 *
 * @author evandouglass
 */
public class CircularLinkedList<T> implements Queue<T> {

  private Node<T> head;
  private Node<T> tail;
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
    return len == 0;
  }

  @Override
  public void enqueue(T element) {
    if (isEmpty()) {
      enqueueEmpty(element);
    } else {
      enqueueNotEmpty(element);
    }
  }

  /**
   * Enqueues an element when the list is empty.
   *
   * @param element the element to add
   */
  private void enqueueEmpty(T element) {
    Node<T> node = new ListNode<>(element);
    head = node;
    tail = node;
    len++;
  }

  /**
   * Enqueues an element when the list is not empty.
   *
   * @param element the element to add.
   */
  private void enqueueNotEmpty(T element) {
    // Make a new node at the back of the list
    Node<T> node = new ListNode<>(element, null, tail);
    // Reset tail to be the second to last element
    tail.setPrevious(node);
    tail = node;
    len++;
  }

  @Override
  public T dequeue() throws EmptyQueueException {
    if (isEmpty()) {
      throw new EmptyQueueException();
    }
    if (size() == 1) {
      return dequeueSizeOfOne();
    }
    return dequeueSizeGreaterThanOne();
  }

  /**
   * Dequeue an element when there is only one element in the list.
   *
   * @return the payload of the only node in the list
   */
  private T dequeueSizeOfOne() {
    final T payload = head.getPayload();
    head = null;
    tail = null;
    len--;
    return payload;
  }

  /**
   * Dequeue an element when there is more than one element in the list.
   *
   * @return the first element in the list (the head)
   */
  private T dequeueSizeGreaterThanOne() {
    Node<T> node = head;
    head = node.getPrevious();
    head.setNext(null);
    len--;
    return node.getPayload();
  }

  @Override
  public void remove(T element) {
    // Ignore remove on empty list
    if (isEmpty()) {
      return;
    }
    if (size() == 1) {
      removeFromSizeOne(element);
    } else {
      removeFromSizeGreaterThanOne(element);
    }
  }

  /**
   * Removes the given element from the list, if the list has a single element.
   *
   * @param element the element (node payload) to remove
   */
  private void removeFromSizeOne(T element) {
    if (head.getPayload().equals(element)) {
      head = null;
      tail = null;
      len--;
    }
  }

  /**
   * Removes the given element from the list, if the list has more than one element.
   *
   * @param element the element (node payload) to remove
   */
  private void removeFromSizeGreaterThanOne(T element) {
    Node<T> node = head;

    // Test first node
    if (node.getPayload().equals(element)) {
      head = node.getPrevious();
      head.setNext(null);
      len--;
      return;
    }
    node = node.getPrevious();

    // Test the rest of the list, but not the last node
    while (!node.isLast()) {
      if (node.getPayload().equals(element)) {
        // remove node from list and exit method
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
        len--;
        return;
      }
      node = node.getPrevious();
    }

    // Test the last node
    if (node.getPayload().equals(element)) {
      tail = node.getNext();
      tail.setPrevious(null);
      len--;
    }
  }

  @Override
  public Integer size() {
    return len;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    CircularLinkedList<?> that = (CircularLinkedList<?>) obj;
    return isSame(that);
  }

  /**
   * Assuming another object is a CircularLinkedList, checks if the two are equivalent or not.
   *
   * @param that the other list
   * @return true if all nodes have the same values in the same location of the lists, else false
   */
  private Boolean isSame(CircularLinkedList<?> that) {
    // Test size diffs
    if (!that.size().equals(size())) {
      return false;
    }

    // Are both empty?
    if (isEmpty()) {
      return true;
    }

    // Traverse list, checking value of each node
    Node<?> node = head;
    Node<?> nodeOther = that.getHead();
    if (!node.getPayload().equals(nodeOther.getPayload())) {
      return false;
    }
    while (!node.isLast()) {
      node = node.getPrevious();
      nodeOther = nodeOther.getPrevious();
      if (!node.getPayload().equals(nodeOther.getPayload())) {
        return false;
      }
    }
    // All nodes checked and all the same
    return true;
  }

  @Override
  public int hashCode() {
    int hash;
    // Traverse list, adding each payload to the final hash value
    Node<T> node = head;  // wildcard prevents unchecked assignment warning
    hash = Objects.hash(node.getPayload());
    while (!node.isLast()) {
      node = node.getPrevious();
      hash += Objects.hash(node.getPayload());
    }
    return hash;
  }

  @Override
  public String toString() {
    return "CircularLinkedList{" + listToString() + "}";
  }

  /**
   * Helper for toString. Cycles through the list and appends each node's payload to a {@code
   * StringBuilder} and returns the result.
   *
   * @return a comma separated list of each node's payload, as a string
   */
  private String listToString() {
    if (isEmpty()) {
      return "";
    }
    // Make a string from each element
    StringBuilder builder = new StringBuilder();
    Node<T> node = head;
    builder.append(node.getPayload().toString());
    while (!node.isLast()) {
      node = node.getPrevious();
      builder.append(", ");
      builder.append(node.getPayload().toString());
    }
    return builder.toString();
  }

  /* ===== Getters ===== */

  /**
   * Returns the first node in the list.
   *
   * @return the first node
   */
  public Node<T> getHead() {
    return head;
  }

  /**
   * Returns the last node in the list.
   *
   * @return the last node
   */
  public Node<T> getTail() {
    return tail;
  }
}
