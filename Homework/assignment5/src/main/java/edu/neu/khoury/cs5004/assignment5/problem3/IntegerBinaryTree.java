package edu.neu.khoury.cs5004.assignment5.problem3;

/**
 * A blueprint for an IntegerBinaryTree.
 *
 * @author evandouglass
 */
public interface IntegerBinaryTree {

  /**
   * Returns the number of nodes in this tree.
   *
   * @return the number of nodes in the tree
   */
  Long size();

  /**
   * Calculates the sum of all integers found within this tree.
   *
   * @return the sum of each node in the tree
   */
  Long sum();

  /**
   * Calculates the product of all integers found within this tree.
   *
   * @return the product of each node in the tree
   */
  Long multiply();

  /**
   * Determines if a given integer is contained inside this tree.
   *
   * @param num an integer to search for.
   * @return true if the number is found, else false
   */
  boolean contains(Integer num);

  /**
   * Returns an iterator that traverses the tree in pre-order.
   *
   * @return an iterator that traverses the tree in pre-order
   */
  PreOrderIterator preOrderIter();

  /**
   * Returns an iterator that traverses the tree in post-order.
   *
   * @return an iterator that traverses the tree in post-order
   */
  PostOrderIterator postOrderIter();

  /**
   * Returns an iterator that traverses the tree in order.
   *
   * @return an iterator that traverses the tree in order
   */
  InOrderIterator inOrderIter();

  /**
   * Getter for head of this tree.
   *
   * @return the head of this tree
   */
  Node getHead();

  /**
   * Setter for the head of this tree.
   *
   * @param head the new head.
   */
  void setHead(Node head);
}
