package edu.neu.khoury.sc5004.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

// Tests are not extensive as this is a Lab and we have limited time in-class.

public class MatrixUtilsTest {
  private Integer[][] m1;
  private Integer[][] diffSize;

  @Before
  public void setUp() throws Exception {
    m1 = new Integer[2][3];
    diffSize = new Integer[3][2];
  }

  @Test
  public void constantMultiplication() {
    Integer[][] expected = new Integer[2][3];
    // fill result
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        expected[i][j] = 10;
      }
    }

    // fill m1
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        m1[i][j] = 5;
      }
    }

    // operation
    Integer[][] result = MatrixUtils.constantMultiplication(m1, 2);
    assertArrayEquals(expected, result);
  }

  @Test
  public void add() throws MatrixDifferentSizesException {
    Integer[][] expected = new Integer[2][3];
    // fill result
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        expected[i][j] = 10;
      }
    }

    // fill m1
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        m1[i][j] = 5;
      }
    }

    // operation
    Integer[][] result = MatrixUtils.add(m1, m1);
    assertArrayEquals(expected, result);
  }

  @Test(expected = MatrixDifferentSizesException.class)
  public void addDiffSizes() throws MatrixDifferentSizesException {
    // fill m1
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        m1[i][j] = 5;
      }
    }

    // fill m1
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 2; j++) {
        diffSize[i][j] = 5;
      }
    }

    // operation
    MatrixUtils.add(m1, diffSize);
  }

  @Test
  public void transpose() {
    // fill m1
    m1[0][0] = 1;
    m1[0][1] = 2;
    m1[0][2] = 3;
    m1[1][0] = 4;
    m1[1][1] = 5;
    m1[1][2] = 6;

    // fill diffSize
    diffSize[0][0] = 1;
    diffSize[0][1] = 4;
    diffSize[1][0] = 2;
    diffSize[1][1] = 5;
    diffSize[2][0] = 3;
    diffSize[2][1] = 6;

    Integer[][] result = MatrixUtils.transpose(m1);
    assertArrayEquals(result, diffSize);
  }
}