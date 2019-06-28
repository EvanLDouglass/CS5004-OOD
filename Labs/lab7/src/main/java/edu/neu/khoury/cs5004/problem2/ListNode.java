package edu.neu.khoury.cs5004.problem2;

public class ListNode<T> implements Node<T> {

  private T payload;
  private Node<T> previous;
  private Node<T> next;

  /**
   * Constructor that sets the payload only.
   *
   * @param payload the payload
   */
  public ListNode(T payload) {
    this(payload, null, null);
  }

  /**
   * Constructor that sets the payload and the previous and next nodes.
   *
   * @param payload the payload
   * @param previous the previous node
   * @param next the next node
   */
  public ListNode(T payload, Node<T> previous, Node<T> next) {
    this.payload = payload;
    this.previous = previous;
    this.next = next;
  }

  /* ===== Methods ===== */

  @Override
  public Boolean isFirst() {
    return next == null;
  }

  @Override
  public Boolean isLast() {
    return previous == null;
  }

  @Override
  public Node<T> getNext() {
    return next;
  }

  @Override
  public void setNext(Node<T> node) {
    next = node;
  }

  @Override
  public Node<T> getPrevious() {
    return previous;
  }

  @Override
  public void setPrevious(Node<T> node) {
    previous = node;
  }

  @Override
  public T getPayload() {
    return payload;
  }

  @Override
  public void setPayload(T payload) {
    this.payload = payload;
  }

  @Override
  public String toString() {
    return "ListNode{" + payload + '}';
  }
}
