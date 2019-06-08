package edu.neu.khoury.cs5004.problem2;

/**
 * Train is a type of vehicle.
 */
public class Train extends Vehicle {

  /**
   * Constructor for a Train.
   *
   * @param vehicleId a vehicle ID
   * @param avgSpeed the average speed of the vehicle
   * @param maxSpeed the max speed of the vehicle
   */
  public Train(String vehicleId, Float avgSpeed, Float maxSpeed) {
    super(vehicleId, avgSpeed, maxSpeed);
  }

  @Override
  public String toString() {
    return "Train{" + super.toString() + "}";
  }
}
