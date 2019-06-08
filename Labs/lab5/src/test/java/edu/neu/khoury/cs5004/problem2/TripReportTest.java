package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TripReportTest {

  private TripReport report;

  @Before
  public void setUp() throws Exception {
    report = new TripReport(
        new Boat("1234", (float) 20.5, (float) 40.0),
        (float) 35.0,
        (float) 50.0,
        124
    );
  }

  @Test
  public void toString1() {
    String result =
        "TripReport{Vehicle:'Boat{ID:'1234', AvgSpeed:20.500000, MaxSpeed:40.000000}', "
        + "Speed:35.000000, Distance:50.000000, Duration:124}";
    assertEquals(result, report.toString());
  }

  @Test
  public void equals1() {
    TripReport tr = new TripReport(
        new Boat("1234", (float) 20.5, (float) 40.0),
        (float) 35.0,
        (float) 50.0,
        124
    );
    assertEquals(tr, report);
    assertEquals(report, report);
  }

  @Test
  public void notEquals() {
    assertNotEquals(null, report);
    assertNotEquals("Test", report);

    TripReport tr = new TripReport(
        new Boat("12345", (float) 20.5, (float) 40.0),
        (float) 35.0,
        (float) 50.0,
        124
    );
    assertNotEquals(tr, report);

    tr.setSpeed((float) 22.2);
    assertNotEquals(tr, report);

    tr.setDistance((float) 54.2);
    assertNotEquals(tr, report);

    tr.setDuration(220);
    assertNotEquals(tr, report);
  }

  @Test
  public void hashCode1() {
    TripReport tr = new TripReport(
        new Boat("1234", (float) 20.5, (float) 40.0),
        (float) 35.0,
        (float) 50.0,
        124
    );
    assertEquals(tr.hashCode(), report.hashCode());

    tr.setDuration(222);
    assertNotEquals(tr.hashCode(), report.hashCode());
  }

  @Test
  public void getVehicle() {
    assertEquals(new Boat("1234", (float) 20.5, (float) 40.0), report.getVehicle());
  }

  @Test
  public void getAndSetSpeed() {
    assertEquals((float) 35.0, report.getSpeed(), 0.0);
    report.setSpeed((float) 33.0);
    assertEquals((float) 33.0, report.getSpeed(), 0.0);
  }

  @Test
  public void getAndSetDistance() {
    assertEquals((float) 50.0, report.getDistance(), 0.0);
    report.setDistance((float) 33.0);
    assertEquals((float) 33.0, report.getDistance(), 0.0);
  }

  @Test
  public void getAndSetDuration() {
    assertEquals(124, (int) report.getDuration());
    report.setDuration(100);
    assertEquals(100, (int) report.getDuration());
  }
}