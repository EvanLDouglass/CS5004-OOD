package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FleetManagerTest {

  private FleetManager mngr;

  @Before
  public void setUp() throws Exception {
    mngr = new FleetManager();
  }

  @Test
  public void drive() {
    Boat boat = new Boat("12345", (float) 25.0, (float) 50.0);
    TripReport report = mngr.drive((float) 100.0, boat);

    assertEquals(boat, report.getVehicle());
    assertEquals((float) 25.0, report.getSpeed(), 0.0);
    assertEquals((float) 100.0, report.getDistance(), 0.0);
    assertEquals(4, (int) report.getDuration());
  }
}