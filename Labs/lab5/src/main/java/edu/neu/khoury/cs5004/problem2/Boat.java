package edu.neu.khoury.cs5004.problem2;

/**
 * Boat is a type of vehicle.
 */
public class Boat extends Vehicle {

  /**
   * Constructor for a Boat.
   *
   * @param vehicleId a vehicle ID
   * @param avgSpeed the average speed of the vehicle
   * @param maxSpeed the max speed of the vehicle
   */
  public Boat(String vehicleId, Float avgSpeed, Float maxSpeed) {
    super(vehicleId, avgSpeed, maxSpeed);
  }

  @Override
  public String toString() {
    return "Boat{" + super.toString() + "}";
  }
}
