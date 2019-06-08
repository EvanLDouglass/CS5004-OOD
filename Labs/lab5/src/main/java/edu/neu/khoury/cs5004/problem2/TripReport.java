package edu.neu.khoury.cs5004.problem2;

import java.util.Objects;

/**
 * Tracks the trip of a single vehicle.
 *
 * @author evandouglass
 */
public class TripReport {

  private Vehicle vehicle;
  private Float speed;
  private Float distance;
  private Integer duration;

  /**
   * Constructor for a TripReport.
   *
   * @param vehicle the vehicle for the report
   * @param speed the speed of the vehicle
   * @param distance the distance the vehicle has traveled
   * @param duration the duration of the vehicle's trip
   */
  public TripReport(Vehicle vehicle, Float speed, Float distance, Integer duration) {
    this.vehicle = vehicle;
    this.speed = speed;
    this.distance = distance;
    this.duration = duration;
  }

  /* ===== Object Overrides ===== */

  /**
   * Makes a string representation.
   *
   * @return a string representation
   */
  @Override
  public String toString() {
    return String.format("TripReport{Vehicle:'%s', Speed:%f, Distance:%f, Duration:%d}",
        vehicle, speed, distance, duration);
  }

  /**
   * Tests equality of another option.
   *
   * @param o another object
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
    TripReport that = (TripReport) o;
    return vehicle.equals(that.vehicle)
        && speed.equals(that.speed)
        && distance.equals(that.distance)
        && duration.equals(that.duration);
  }

  /**
   * Returns a hash code.
   *
   * @return a hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(vehicle, speed, distance, duration);
  }

  /* ===== Getters & Setters ===== */

  /**
   * Getter for vehicle.
   *
   * @return the vehicle
   */
  public Vehicle getVehicle() {
    return vehicle;
  }

  /**
   * Getter for speed.
   *
   * @return the speed
   */
  public Float getSpeed() {
    return speed;
  }

  /**
   * Setter for speed.
   *
   * @param speed a new speed
   */
  public void setSpeed(Float speed) {
    this.speed = speed;
  }

  /**
   * Getter for distance.
   *
   * @return the distance
   */
  public Float getDistance() {
    return distance;
  }

  /**
   * Setter for distance.
   *
   * @param distance the new distance
   */
  public void setDistance(Float distance) {
    this.distance = distance;
  }

  /**
   * Getter for duration.
   *
   * @return the duration
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * Setter for duration.
   *
   * @param duration the new duration
   */
  public void setDuration(Integer duration) {
    this.duration = duration;
  }
}
