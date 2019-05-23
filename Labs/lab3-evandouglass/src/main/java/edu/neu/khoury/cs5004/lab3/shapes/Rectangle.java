package edu.neu.khoury.cs5004.lab3.shapes;

/**
 * This class represents a rectangle.  It defines all the operations mandated by the Shape
 * interface
 */
public class Rectangle extends AbstractShape {

  private double width;
  private double height;

  /**
   * Constructs a rectangle object with the given location of its lower-left corner and dimensions.
   *
   * @param cordX x coordinate of the lower-left corner of this rectangle
   * @param cordY y coordinate of the lower-left corner of this rectangle
   * @param width width of this rectangle
   * @param height height of this rectangle
   * @throws IllegalArgumentException if width or height is not positive
   */
  public Rectangle(double cordX, double cordY, double width, double height)
      throws IllegalArgumentException {
    super(new Posn(cordX, cordY));
    this.width = width;
    this.height = height;
    this.validateSides();
  }

  @Override
  public double area() {
    return this.width * this.height;
  }

  @Override
  public double perimeter() {
    return 2 * (this.width + this.height);
  }

  @Override
  public Rectangle resize(double factor) {
    return new Rectangle(
        this.reference.getX(),
        this.reference.getY(),
        factor * this.width,
        factor * this.height);
  }

  /**
   * Creates a string representation of this object.
   *
   * @return a string representation
   */
  public String toString() {
    return String.format("Rectangle: LL corner (%.3f,%.3f) width %.3f height "
            + "%.3f",
        this.reference.getX(), this.reference.getY(), this.width, this.height);
  }

  private void validateSides() throws IllegalArgumentException {
    if (width <= 0) {
      throw new IllegalArgumentException("width must be positive");
    } else if (height <= 0) {
      throw new IllegalArgumentException("height must be positive");
    }
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }
}