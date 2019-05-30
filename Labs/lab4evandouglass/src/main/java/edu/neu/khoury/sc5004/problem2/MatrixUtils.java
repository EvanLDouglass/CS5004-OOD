package edu.neu.khoury.sc5004.problem2;

/**
 * MatrixUtils contains functionality for matrix operations, including scalar multiplication,
 * addition and transposing.
 *
 * @author evandouglass
 */
public class MatrixUtils {

  /**
   * Multiplies the given array by an integer constant.
   *
   * @param matrix the matrix to multiply
   * @param cons the constant to multiply
   * @return the resulting matrix
   */
  public static Integer[][] constantMultiplication(Integer[][] matrix, Integer cons) {
    int outerLen = matrix.length;
    int innerLen = matrix[0].length;
    Integer[][] newMatrix = new Integer[outerLen][innerLen];

    // loop through each value and multiply -> populate newMatrix
    for (int i = 0; i < outerLen; i++) {
      for (int j = 0; j < innerLen; j++) {
        newMatrix[i][j] = matrix[i][j] * cons;
      }
    }
    return newMatrix;
  }

  /**
   * Adds two matrices together.
   *
   * @param matrixA a matrix of integers
   * @param matrixB a matrix of integers
   * @return the resulting matrix
   */
  public static Integer[][] add(Integer[][] matrixA, Integer[][] matrixB)
      throws MatrixDifferentSizesException {
    // Validity test
    if (! isSameSize(matrixA, matrixB)) {
      throw new MatrixDifferentSizesException("matrices must be the same size");
    }

    // Calculation
    int outerLen = matrixA.length;
    int innerLen = matrixA[0].length;
    Integer[][] result = new Integer[outerLen][innerLen];
    for (int i = 0; i < outerLen; i++) {
      for (int j = 0; j < innerLen; j++) {
        result[i][j] = matrixA[i][j] + matrixB[i][j];
      }
    }

    return result;
  }

  /**
   * Produces the transpose of a matrix.
   *
   * @param matrix a matrix of integers
   * @return the resulting matrix
   */
  public static Integer[][] transpose(Integer[][] matrix) {
    int outerLen = matrix.length;
    int innerLen = matrix[0].length;
    Integer[][] result = new Integer[innerLen][outerLen];

    for (int i = 0; i < outerLen; i++) {
      for (int j = 0; j < innerLen; j++) {
        result[j][i] = matrix[i][j];
      }
    }

    return result;
  }

  /**
   * Checks if two matrices are the same size (i.e. both dimensions have the same length).
   *
   * @param m1 a matrix of integers
   * @param m2 a matrix of integers
   * @return true if both matrices have the same size, else false
   */
  private static boolean isSameSize(Integer[][] m1, Integer[][] m2) {
    return (m1.length == m2.length) && (m1[0].length == m2[0].length);
  }
}
