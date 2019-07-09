package edu.neu.khoury.cs5004.problem3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {

  private Node node;

  @Before
  public void setUp() throws Exception {
    node = new Node(5);
  }

  @Test
  public void toString1() {
    assertEquals("Node{5}", node.toString());
  }

  @Test
  public void testGettersSetters() {
    Node right = new Node(6);
    Node left = new Node(4);
    node.setLeft(left);
    node.setRight(right);

    assertEquals(right, node.getRight());
    assertEquals(left, node.getLeft());
    assertEquals(5, (int) node.getVal());
  }

  @Test
  public void testIsNull() {
    assertTrue(node.leftIsNull());
    assertTrue(node.rightIsNull());

    Node right = new Node(6);
    Node left = new Node(4);
    node.setLeft(left);
    node.setRight(right);

    assertFalse(node.rightIsNull());
    assertFalse(node.leftIsNull());
  }
}