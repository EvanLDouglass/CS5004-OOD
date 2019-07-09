package edu.neu.khoury.cs5004.assignment5.problem3;

/**
 * A Node is a single element in an Integer Binary Tree.
 *
 * @author evandouglass
 */
public class Node {

  private Integer val;
  private Node left;
  private Node right;

  /**
   * Constructor for a Node.
   *
   * @param val the integer value for this node to store
   */
  public Node(Integer val) {
    this.val = val;
  }

  /**
   * Returns a string representation of this node.
   *
   * @return a string representation of this node
   */
  @Override
  public String toString() {
    return "Node{" + val + '}';
  }

  /**
   * Getter for value.
   *
   * @return this node's value
   */
  public Integer getVal() {
    return val;
  }

  /**
   * Gets this node's left node.
   *
   * @return left node
   */
  public Node getLeft() {
    return left;
  }

  /**
   * Sets the left node.
   *
   * @param left the new left node
   */
  public void setLeft(Node left) {
    this.left = left;
  }

  /**
   * Tests if the left node is null.
   *
   * @return true if left == null, else false
   */
  public boolean leftIsNull() {
    return left == null;
  }

  /**
   * Gets this node's right node.
   *
   * @return right node
   */
  public Node getRight() {
    return right;
  }

  /**
   * Sets the left node.
   *
   * @param right the new left node
   */
  public void setRight(Node right) {
    this.right = right;
  }

  /**
   * Tests if the right node is null.
   *
   * @return true if right == null, else false
   */
  public boolean rightIsNull() {
    return right == null;
  }
}
