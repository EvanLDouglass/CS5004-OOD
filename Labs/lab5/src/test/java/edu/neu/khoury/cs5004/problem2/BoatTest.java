package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

// Tests the super class Vehicle as well
public class BoatTest {

  private Boat boat;

  @Before
  public void setUp() throws Exception {
    boat = new Boat("12345", (float) 25.0, (float) 50.0);
  }

  @Test
  public void toString1() {
    String result = "Boat{ID:'12345', AvgSpeed:25.000000, MaxSpeed:50.000000}";
    assertEquals(result, boat.toString());
  }

  @Test
  public void equals1() {
    Boat b = new Boat("12345", (float) 25.0, (float) 50.0);
    assertEquals(b, boat);
    assertEquals(boat, boat);

    b.setAvgSpeed((float) 24.0);
    assertNotEquals(b, boat);
    assertNotEquals(null, boat);
    assertNotEquals("Test", boat);
  }

  @Test
  public void hashCode1() {
    Boat b = new Boat("12345", (float) 25.0, (float) 50.0);
    assertEquals(b.hashCode(), boat.hashCode());

    b.setAvgSpeed((float) 33.3);
    assertNotEquals(b.hashCode(), boat.hashCode());
  }

  @Test
  public void getVehicleId() {
    assertEquals("12345", boat.getVehicleId());
  }

  @Test
  public void getAndSetAvgSpeed() {
    assertEquals((float) 25.0, boat.getAvgSpeed(), 0.0);
    boat.setAvgSpeed((float) 22.2);
    assertEquals((float) 22.2, boat.getAvgSpeed(), 0.0);
  }

  @Test
  public void getMaxSpeed() {
    assertEquals((float) 50.0, boat.getMaxSpeed(), 0.0);
  }
}