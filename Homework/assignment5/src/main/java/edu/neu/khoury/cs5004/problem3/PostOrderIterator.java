package edu.neu.khoury.cs5004.problem3;

/**
 * An iterator that traverses an {@code IntegerBinaryTree} with post-order ordering.
 *
 * @author evandouglass
 */
public class PostOrderIterator extends BinaryTreeIterator {

  /**
   * Constructor for a {@code PostOrderIterator} for an {@code IntegerBinaryTree}.
   *
   * @param tree an IntegerBinaryTree to iterate over
   */
  public PostOrderIterator(IntegerBinaryTree tree) {
    super(tree);
    if (tree != null && tree.size() > 0) {
      fillStack(tree.getHead());
    }
  }

  /**
   * Fills the iterator's stack with the tree's nodes. Due to added complexity of breaking up an
   * iterative post-ordering algorithm, as with the other iterators in this package, this iterator
   * fills it's stack with every node upon initialization of the object. Assumes the given node is
   * not null.
   *
   * @param node a node to start filling the stack from
   */
  private void fillStack(Node node) {
    // Use DFS to achieve post-ordering
    // push in opposite order to achieve popping in correct order
    stack.push(node);
    if (!node.rightIsNull()) {
      fillStack(node.getRight());
    }
    if (!node.leftIsNull()) {
      fillStack(node.getLeft());
    }
  }

  @Override
  public Integer next() {
    return stack.pop().getVal();
  }
}
