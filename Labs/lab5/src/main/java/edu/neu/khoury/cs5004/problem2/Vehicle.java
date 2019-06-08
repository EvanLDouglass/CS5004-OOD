package edu.neu.khoury.cs5004.problem2;

import java.util.Objects;

/**
 * A {@code Vehicle} contains information about a general vehicle, including an ID number, average
 * speed and max speed.
 *
 * @author evandouglass
 */
public abstract class Vehicle {

  private String vehicleId;
  private Float avgSpeed;
  private Float maxSpeed;

  /**
   * Constructor for a vehicle.
   *
   * @param vehicleId a vehicle ID
   * @param avgSpeed the average speed of the vehicle
   * @param maxSpeed the max speed of the vehicle
   */
  public Vehicle(String vehicleId, Float avgSpeed, Float maxSpeed) {
    this.vehicleId = vehicleId;
    this.avgSpeed = avgSpeed;
    this.maxSpeed = maxSpeed;
  }

  /* ===== Object Overrides ===== */

  /**
   * Returns a string representation of this object.
   *
   * @return a string representation of this object
   */
  @Override
  public String toString() {
    return String.format("ID:'%s', AvgSpeed:%f, MaxSpeed:%f",
        vehicleId, avgSpeed, maxSpeed);
  }

  /**
   * Tests equality between this and another object.
   *
   * @param o the object to test
   * @return true if equal, else false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return vehicleId.equals(vehicle.vehicleId)
        && avgSpeed.equals(vehicle.avgSpeed)
        && maxSpeed.equals(vehicle.maxSpeed);
  }

  /**
   * Generates a hash code for this object.
   *
   * @return a hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(vehicleId, avgSpeed, maxSpeed);
  }

  /* ===== Getters ===== */

  /**
   * Gets the vehicle ID.
   *
   * @return the vehicle ID
   */
  public String getVehicleId() {
    return vehicleId;
  }

  /**
   * Gets the average vehicle speed.
   *
   * @return the average vehicle speed
   */
  public Float getAvgSpeed() {
    return avgSpeed;
  }

  /**
   * Sets the average vehicle speed.
   *
   * @param avgSpeed the new average speed
   */
  public void setAvgSpeed(Float avgSpeed) {
    this.avgSpeed = avgSpeed;
  }

  /**
   * Gets the max speed of this vehicle.
   *
   * @return the max speed of the vehicle
   */
  public Float getMaxSpeed() {
    return maxSpeed;
  }
}
