package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThermostatTest {

  // This test includes calls to all getters and setters (through setHouseTemp) for Thermostat
  @Test
  public void setLivingRoomTemp() {
    Thermostat therm = new Thermostat(65, 66, 67);
    assertEquals(65, (int)therm.getBedTemp());
    assertEquals(66, (int)therm.getBathTemp());
    assertEquals(67, (int)therm.getLivingRoomTemp());

    // Start at low temps and move up
    therm = therm.setHouseTemp(0);
    assertEquals(60, (int)therm.getBedTemp());
    assertEquals(58, (int)therm.getBathTemp());
    assertEquals(60, (int)therm.getLivingRoomTemp());

    therm = therm.setHouseTemp(59);
    assertEquals(60, (int)therm.getBedTemp());
    assertEquals(59, (int)therm.getBathTemp());
    assertEquals(60, (int)therm.getLivingRoomTemp());

    therm = therm.setHouseTemp(65);
    assertEquals(65, (int)therm.getBedTemp());
    assertEquals(65, (int)therm.getBathTemp());
    assertEquals(65, (int)therm.getLivingRoomTemp());

    therm = therm.setHouseTemp(69);
    assertEquals(68, (int)therm.getBedTemp());
    assertEquals(69, (int)therm.getBathTemp());
    assertEquals(69, (int)therm.getLivingRoomTemp());

    therm = therm.setHouseTemp(71);
    assertEquals(68, (int)therm.getBedTemp());
    assertEquals(70, (int)therm.getBathTemp());
    assertEquals(71, (int)therm.getLivingRoomTemp());

    therm = therm.setHouseTemp(100);
    assertEquals(68, (int)therm.getBedTemp());
    assertEquals(70, (int)therm.getBathTemp());
    assertEquals(72, (int)therm.getLivingRoomTemp());
  }
}