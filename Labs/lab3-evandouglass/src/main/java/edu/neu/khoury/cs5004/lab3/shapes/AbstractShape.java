package edu.neu.khoury.cs5004.lab3.shapes;

public abstract class AbstractShape implements Shape {

  protected Posn reference;

  public AbstractShape(Posn reference) {
    this.reference = reference;
  }

  @Override
  public double distanceFromOrigin() {
    return reference.distToOrigin();
  }

  public double getX() {
    return reference.getX();
  }

  public double getY() {
    return reference.getY();
  }
}
