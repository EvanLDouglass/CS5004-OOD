package edu.neu.khoury.cs5004.lab3.shapes;

/**
 * Class Square represents a square.
 */
public class Square extends Rectangle {

  /**
   * Constructs a rectangle object with the given location of its lower-left corner and dimensions.
   *
   * @param cordX x coordinate of the lower-left corner of this rectangle
   * @param cordY y coordinate of the lower-left corner of this rectangle
   * @param side length of this square's sides
   * @throws IllegalArgumentException if side is not positive
   */
  public Square(double cordX, double cordY, double side)
      throws IllegalArgumentException {
    super(cordX, cordY, side, side);
  }

  @Override
  public Square resize(double factor) {
    return new Square(
        this.getX(),
        this.getY(),
        factor * this.getSide()
    );
  }

  @Override
  public String toString() {
    return String.format("Square: LL corner (%.3f,%.3f) side %.3f",
        this.reference.getX(), this.reference.getY(), this.getWidth());
  }

  public double getSide() {
    return this.getWidth();
  }
}
