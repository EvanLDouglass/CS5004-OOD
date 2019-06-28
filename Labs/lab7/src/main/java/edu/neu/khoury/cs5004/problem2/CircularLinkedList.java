package edu.neu.khoury.cs5004.problem2;

/**
 * An implementation of the Queue ADT using a circular linked
 * list.
 *
 * @author evandouglass
 */
public class CircularLinkedList<T> implements Queue<T> {

  private Node head;
  private Node tail;
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

  /* ===== Getters & Setters ===== */

  /**
   * Returns the first element in the list as a {@code Node}.
   *
   * @return the first element
   */
  public Node getHead() {
    return head;
  }

  /**
   * Returns the last element in the list as a {@code Node}.
   *
   * @return the last element
   */
  public Node getTail() {
    return tail;
  }
}
