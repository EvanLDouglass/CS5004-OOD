package edu.neu.khoury.cs5004.problem2;

/**
 * Describes a doubly linked node used in a linked list.
 *
 * @author evandouglass
 */
public interface Node<T> {

  /**
   * Determines if this node is the first in the list.
   *
   * @return true if node is first, else false
   */
  Boolean isFirst();

  /**
   * Determines if this node is the last in the list.
   *
   * @return true if node is last, else false
   */
  Boolean isLast();

  /**
   * Gets the next node.
   *
   * @return the next node.
   */
  Node<T> getNext();

  /**
   * Sets the next node to that given.
   *
   * @param node the node to add
   */
  void setNext(Node<T> node);

  /**
   * Gets the previous node.
   *
   * @return the previous node
   */
  Node<T> getPrevious();

  /**
   * Sets the previous node to that given.
   *
   * @param node the node to add
   */
  void setPrevious(Node<T> node);

  /**
   * Gets the payload of this node.
   *
   * @return the payload
   */
  T getPayload();

  /**
   * Sets the payload of this node.
   *
   * @param payload the new payload
   */
  void setPayload(T payload);
}
