package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ListNodeTest {

  private Node<Double> node;

  @Before
  public void setUp() throws Exception {
    node = new ListNode<>(5.0);
  }

  @Test
  public void isFirstOneElem() {
    assertTrue(node.isFirst());
  }

  @Test
  public void isFirstTwoElem() {
    Node<Double> node2 = new ListNode<>(3.0, null, node);
    node.setPrevious(node2);
    assertTrue(node.isFirst());
    assertFalse(node2.isFirst());
  }

  @Test
  public void isFistThreeElem() {
    Node<Double> node2 = new ListNode<>(3.0);
    Node<Double> node3 = new ListNode<>(3.0);

    // Set up links
    node.setPrevious(node2);
    node2.setNext(node);
    node2.setPrevious(node3);
    node3.setNext(node2);

    // Tests
    assertTrue(node.isFirst());
    assertFalse(node2.isFirst());
    assertFalse(node3.isFirst());
  }

  @Test
  public void isLastOneElem() {
    assertTrue(node.isLast());
  }

  @Test
  public void isLastTwoElem() {
    Node<Double> node2 = new ListNode<>(3.0, null, node);
    node.setPrevious(node2);
    assertFalse(node.isLast());
    assertTrue(node2.isLast());
  }

  @Test
  public void isLastThreeElem() {
    Node<Double> node2 = new ListNode<>(3.0);
    Node<Double> node3 = new ListNode<>(3.0);

    // Set up links
    node.setPrevious(node2);
    node2.setNext(node);
    node2.setPrevious(node3);
    node3.setNext(node2);

    // Tests
    assertFalse(node.isLast());
    assertFalse(node2.isLast());
    assertTrue(node3.isLast());
  }

  @Test
  public void getAndSetNext() {
    assertNull(node.getNext());

    Node<Double> node2 = new ListNode<>(2.9, node, null);
    node.setNext(node2);
    assertEquals(node2, node.getNext());
  }

  @Test
  public void getAndSetPrevious() {
    assertNull(node.getPrevious());

    Node<Double> node2 = new ListNode<>(2.9, null, node);
    node.setPrevious(node2);
  }

  @Test
  public void getPayload() {
    assertEquals(5.0, node.getPayload(), 0.0);

    node.setPayload(3.1415);
    assertEquals(3.1415, node.getPayload(), 0.0);
  }

  @Test
  public void toString1() {
    String expected = "ListNode{5.0}";
    assertEquals(expected, node.toString());
  }
}