package edu.neu.khoury.cs5004.problem3;

/**
 * A Linked Integer Binary Tree implementation.
 *
 * @author evandouglass
 */
public class LinkedIntegerBinaryTree implements IntegerBinaryTree {

  private Node head;

  /**
   * Constructor that sets head.
   *
   * @param head a Node to set head to
   */
  public LinkedIntegerBinaryTree(Node head) {
    this.head = head;
  }

  /**
   * Basic constructor. Initializes head to null.
   */
  public LinkedIntegerBinaryTree() {
  }

  /* ===== Methods ===== */

  /**
   * Returns the number of nodes in this tree.
   *
   * @return the size of this tree
   */
  @Override
  public Long size() {
    Long counter = (long) 0;
    return sizeHelper(head, counter);
  }

  /**
   * Helper for size. Counts the number of nodes given an initial node and counter.
   *
   * @param node the node to start at
   * @param counter a counter to start counting with
   * @return the number of nodes in the tree starting at node
   */
  private Long sizeHelper(Node node, Long counter) {
    if (node == null) {
      return counter;
    }

    if (! node.leftIsNull()) {
      counter = sizeHelper(node.getLeft(), counter);
    }

    if (! node.rightIsNull()) {
      // works because I'm passing in the previously
      // updated counter, which is then updated again,
      // before returning it.
      counter = sizeHelper(node.getRight(), counter);
    }

    counter++;
    return counter;
  }

  /**
   * Calculates the sum of each node's value in this tree.
   *
   * @return the sum of each node's value
   */
  @Override
  public Long sum() {
    Long sum = (long) 0;
    return sumHelper(head, sum);
  }

  /**
   * A helper for sum.
   *
   * @param node a node in the tree
   * @param sum a variable to keep track of the sum
   * @return the sum of the nodes visited so far.
   */
  private Long sumHelper(Node node, Long sum) {
    if (! node.leftIsNull()) {
      sum = sumHelper(node.getLeft(), sum);
    }

    if (! node.rightIsNull()) {
      sum = sumHelper(node.getRight(), sum);
    }

    sum += node.getVal();
    return sum;
  }

  /**
   * Calculates the sum of each node's value in the tree.
   *
   * @return the product of each node's value
   */
  @Override
  public Long multiply() {
    Long product = (long) 1;
    return multiplyHelper(head, product);
  }

  /**
   * A helper for multiply.
   *
   * @param node a node in the tree
   * @param product a variable to keep track of the sum
   * @return the sum of the nodes visited so far.
   */
  private Long multiplyHelper(Node node, Long product) {
    if (! node.leftIsNull()) {
      product = multiplyHelper(node.getLeft(), product);
    }

    if (! node.rightIsNull()) {
      product = multiplyHelper(node.getRight(), product);
    }

    product *= node.getVal();
    return product;
  }

  /**
   * Determines if a given number is contained in the tree.
   *
   * @param num an integer to search for
   * @return true if the number was found, else false
   */
  @Override
  public boolean contains(Integer num) {
    return containsHelper(head, num);
  }

  /**
   * Helper for contains.
   *
   * @param node a node to check
   * @param num the number to test for
   * @return recursively, true if found, false otherwise
   */
  private boolean containsHelper(Node node, Integer num) {
    if (node == null) {
      return false;
    }

    if (node.getVal() == num) {
      return true;
    } else {
      return containsHelper(node.getLeft(), num) || containsHelper(node.getRight(), num);
    }
  }

  @Override
  public PreOrderIterator preOrderIter() {
    return new PreOrderIterator(this);
  }

  @Override
  public PostOrderIterator postOrderIter() {
    return new PostOrderIterator(this);
  }

  @Override
  public InOrderIterator inOrderIter() {
    return new InOrderIterator(this);
  }

  @Override
  public Node getHead() {
    return head;
  }

  @Override
  public void setHead(Node head) {
    this.head = head;
  }
}
