package edu.neu.khoury.cs5004.problem2;

/**
 * Manages the fleet of vehicles and produces trip reports.
 *
 * @author evandouglass
 */
public class FleetManager {

  /**
   * Creates a trip report given a distance and vehicle.
   *
   * @param distance the distance the vehicle has traveled
   * @param vehicle the vehicle
   * @return a trip report
   */
  public TripReport drive(float distance, Vehicle vehicle) {
    return new TripReport(
        vehicle,
        vehicle.getAvgSpeed(),
        distance,
        (int) (distance/vehicle.getAvgSpeed())
    );
  }
}
