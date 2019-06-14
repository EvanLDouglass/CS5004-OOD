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
        (int) (distance / vehicle.getAvgSpeed())
    );
  }

  /**
   * Creates a trip report given a distance and boat.
   *
   * @param distance the distance the vehicle has traveled
   * @param boat the vehicle
   * @return a trip report
   */
  public TripReport drive(float distance, Boat boat) {
    return new TripReport(
        boat,
        boat.getAvgSpeed(),
        distance,
        (int) (distance / boat.getAvgSpeed())
    );
  }

  /**
   * Creates a trip report given a distance and bus.
   *
   * @param distance the distance the vehicle has traveled
   * @param bus the vehicle
   * @return a trip report
   */
  public TripReport drive(float distance, Bus bus) {
    return new TripReport(
        bus,
        bus.getAvgSpeed(),
        distance,
        (int) (distance / bus.getAvgSpeed())
    );
  }

  /**
   * Creates a trip report given a distance and train.
   *
   * @param distance the distance the vehicle has traveled
   * @param train the vehicle
   * @return a trip report
   */
  public TripReport drive(float distance, Train train) {
    return new TripReport(
        train,
        train.getAvgSpeed(),
        distance,
        (int) (distance / train.getAvgSpeed())
    );
  }
}
