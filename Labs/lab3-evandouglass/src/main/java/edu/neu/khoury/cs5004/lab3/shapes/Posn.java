package edu.neu.khoury.cs5004.lab3.shapes;

/**
 * This class represents a 2D point. This point is denoted in Cartesian coordinates as (x, y).
 */
public class Posn {

  private double cordX;
  private double cordY;

  /**
   * Construct a 2d point with the given coordinates.
   *
   * @param cordX the x-coordinate of this point
   * @param cordY the y-coordinate of this point
   */
  public Posn(double cordX, double cordY) {
    this.cordX = cordX;
    this.cordY = cordY;
  }

  /**
   * Compute and return the Euclidean distance of this point to the origin.
   *
   * @return the euclidean distance
   */

  public double distToOrigin() {
    return Math.sqrt(cordX * cordX + cordY * cordY);
  }

  /**
   * Return the cordX-coordinate of this point.
   *
   * @return cordX-coordinate of this point
   */
  public double getX() {
    return cordX;
  }

  /**
   * Return the cordY-coordinate of this point.
   *
   * @return cordY-coordinate of this point
   */
  public double getY() {
    return cordY;
  }
}