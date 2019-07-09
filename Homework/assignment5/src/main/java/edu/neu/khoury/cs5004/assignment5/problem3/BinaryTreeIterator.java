package edu.neu.khoury.cs5004.assignment5.problem3;

import java.util.Iterator;
import java.util.Stack;

/**
 * Provides common data and functionality for iterators on an {@code IntegerBinaryTree}.
 *
 * @author evandouglass
 */
public abstract class BinaryTreeIterator implements Iterator<Integer> {

  protected IntegerBinaryTree tree;
  protected Stack<Node> stack;

  /**
   * Constructor for a {@code BinaryTreeIterator} for an {@code IntegerBinaryTree}.
   *
   * @param tree an IntegerBinaryTree to iterate over
   */
  public BinaryTreeIterator(IntegerBinaryTree tree) {
    this.tree = tree;
    this.stack = new Stack<>();
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }
}
