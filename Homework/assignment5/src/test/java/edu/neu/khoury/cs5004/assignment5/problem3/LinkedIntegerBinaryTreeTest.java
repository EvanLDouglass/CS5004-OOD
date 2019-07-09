package edu.neu.khoury.cs5004.assignment5.problem3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LinkedIntegerBinaryTreeTest {

  private LinkedIntegerBinaryTree tree;
  private LinkedIntegerBinaryTree one;
  private LinkedIntegerBinaryTree three;

  @Before
  public void setUp() throws Exception {
    Node node1 = new Node(3);
    Node node2 = new Node(30);
    Node node3 = new Node(20);
    Node node4 = new Node(100);
    Node node5 = new Node(8);
    Node node6 = new Node(5);
    Node node7 = new Node(1);
    Node node8 = new Node(50);
    Node node9 = new Node(4);

    node1.setLeft(node2);
    node1.setRight(node3);
    node2.setLeft(node4);
    node2.setRight(node5);
    node5.setLeft(node6);
    node5.setRight(node7);
    node3.setLeft(node8);
    node3.setRight(node9);

    tree = new LinkedIntegerBinaryTree(node1);

    one = new LinkedIntegerBinaryTree(new Node(22));

    three = new LinkedIntegerBinaryTree();
    Node three1 = new Node(5);
    three1.setLeft(new Node(-1));
    three1.getLeft().setRight(new Node(90));
    three.setHead(three1);
  }

  @Test
  public void size() {
    assertEquals(9, (long) tree.size());
    assertEquals(1, (long) one.size());
    assertEquals(3, (long) three.size());
  }

  @Test
  public void sum() {
    assertEquals(22, (long) one.sum());
    assertEquals(94, (long) three.sum());
    assertEquals(221, (long) tree.sum());
  }

  @Test
  public void multiply() {
    assertEquals(22, (long) one.multiply());
    assertEquals(-450, (long) three.multiply());
    assertEquals(1440000000, (long) tree.multiply());
  }

  @Test
  public void contains() {
    assertTrue(one.contains(22));
    assertTrue(three.contains(5));
    assertTrue(three.contains(-1));
    assertTrue(three.contains(90));
    assertTrue(tree.contains(4));
    assertTrue(tree.contains(8));

    assertFalse(one.contains(0));
    assertFalse(three.contains(99));
    assertFalse(tree.contains(124));
  }

  @Test
  public void getHead() {
    Node head = one.getHead();
    assertEquals(22, (int) head.getVal());
  }
}