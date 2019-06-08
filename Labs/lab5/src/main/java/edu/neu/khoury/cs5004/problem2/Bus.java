package edu.neu.khoury.cs5004.problem2;

/**
 * Bus is a type of vehicle.
 */
public class Bus extends Vehicle {

  /**
   * Constructor for a Bus.
   *
   * @param vehicleId a vehicle ID
   * @param avgSpeed the average speed of the vehicle
   * @param maxSpeed the max speed of the vehicle
   */
  public Bus(String vehicleId, Float avgSpeed, Float maxSpeed) {
    super(vehicleId, avgSpeed, maxSpeed);
  }

  @Override
  public String toString() {
    return "Bus{" + super.toString() + "}";
  }
}
