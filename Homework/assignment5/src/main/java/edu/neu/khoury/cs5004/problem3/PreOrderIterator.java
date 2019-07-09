package edu.neu.khoury.cs5004.problem3;

/**
 * An iterator that traverses an {@code IntegerBinaryTree} with pre-order ordering.
 *
 * @author evandouglass
 */
public class PreOrderIterator extends BinaryTreeIterator {

  /**
   * Constructor for a {@code PreOrderIterator} for an {@code IntegerBinaryTree}.
   *
   * @param tree an IntegerBinaryTree to iterate over
   */
  public PreOrderIterator(IntegerBinaryTree tree) {
    super(tree);
    if (tree != null && tree.size() > 0) {
      stack.push(tree.getHead());
    }
  }

  @Override
  public Integer next() {
    // Get next node
    Node node = stack.pop();
    // Add right node, then left node (left popped first)
    if (!node.rightIsNull()) {
      stack.push(node.getRight());
    }
    if (!node.leftIsNull()) {
      stack.push(node.getLeft());
    }
    return node.getVal();
  }
}
