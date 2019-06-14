package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FleetManagerTest {

  private FleetManager mngr;

  @Before
  public void setUp() throws Exception {
    mngr = new FleetManager();
  }

  @Test
  public void driveBoat() {
    Boat boat = new Boat("12345", (float) 25.0, (float) 50.0);
    TripReport report = mngr.drive((float) 100.0, boat);

    assertEquals(boat, report.getVehicle());
    assertEquals((float) 25.0, report.getSpeed(), 0.0);
    assertEquals((float) 100.0, report.getDistance(), 0.0);
    assertEquals(4, (int) report.getDuration());
  }

  @Test
  public void driveBus() {
    Bus bus = new Bus("12345", (float) 25.0, (float) 50.0);
    TripReport report = mngr.drive((float) 100.0, bus);

    assertEquals(bus, report.getVehicle());
    assertEquals((float) 25.0, report.getSpeed(), 0.0);
    assertEquals((float) 100.0, report.getDistance(), 0.0);
    assertEquals(4, (int) report.getDuration());
  }

  @Test
  public void driveTrain() {
    Train train = new Train("12345", (float) 25.0, (float) 50.0);
    TripReport report = mngr.drive((float) 100.0, train);

    assertEquals(train, report.getVehicle());
    assertEquals((float) 25.0, report.getSpeed(), 0.0);
    assertEquals((float) 100.0, report.getDistance(), 0.0);
    assertEquals(4, (int) report.getDuration());
  }

  @Test
  public void driveVehicle() {
    Vehicle vehicle = new Boat("12345", (float) 25.0, (float) 50.0);
    TripReport report = mngr.drive((float) 100.0, vehicle);

    assertEquals(vehicle, report.getVehicle());
    assertEquals((float) 25.0, report.getSpeed(), 0.0);
    assertEquals((float) 100.0, report.getDistance(), 0.0);
    assertEquals(4, (int) report.getDuration());
  }
}