package edu.neu.khoury.cs5004.assignment5.problem3;


/**
 * An iterator that traverses an {@code IntegerBinaryTree} with an in-order ordering.
 *
 * @author evandouglass
 */
public class InOrderIterator extends BinaryTreeIterator {

  /**
   * Constructor for an {@code InOrderIterator} for an {@code IntegerBinaryTree}.
   *
   * @param tree an IntegerBinaryTree to iterate over
   */
  public InOrderIterator(IntegerBinaryTree tree) {
    super(tree);
    if (tree != null && tree.size() > 0) {
      addLeftToStack(tree.getHead());
    }
  }

  /**
   * Adds to the iterator's stack. Includes the given node and those on it's left. Assumes the given
   * node is not null.
   *
   * @param node a node to start with
   */
  private void addLeftToStack(Node node) {
    if (tree.size() == 0) {
      // leave the stack empty if there is nothing in the tree
      return;
    }
    // Push all available leftmost nodes to the stack
    stack.push(node);
    while (!node.leftIsNull()) {
      node = node.getLeft();
      stack.push(node);
    }
  }

  @Override
  public Integer next() {
    Node node = stack.pop();
    final Integer val = node.getVal();
    if (!node.rightIsNull()) {
      addLeftToStack(node.getRight());
    }
    return val;
  }
}
