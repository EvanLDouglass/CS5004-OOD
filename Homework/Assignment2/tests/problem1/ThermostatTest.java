package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ThermostatTest {
  private Thermostat therm;

  @Before
  public void setUp() {
    therm = new Thermostat(65, 66, 67);
  }

  @Test
  public void altConstructor() {
    Bedrooms bed = new Bedrooms(60);
    Bathrooms bath = new Bathrooms(61);
    LivingRooms living = new LivingRooms(62);
    therm = new Thermostat(bed, bath, living);

    assertEquals(bed, therm.getBedrooms());
    assertEquals(bath, therm.getBathrooms());
    assertEquals(living, therm.getLivingRooms());
  }

  @Test
  public void getAndSetBedTemp() {
    assertEquals(65, (int)therm.getBedTemp());
    therm.setBedTemp(60);
    assertEquals(60, (int)therm.getBedTemp());
    therm.setBedTemp(0);
    assertEquals(60, (int)therm.getBedTemp());
    therm.setBedTemp(100);
    assertEquals(68, (int)therm.getBedTemp());
  }

  @Test
  public void getAndSetBathTemp() {
    assertEquals(66, (int)therm.getBathTemp());
    therm.setBathTemp(60);
    assertEquals(60, (int)therm.getBathTemp());
    therm.setBathTemp(0);
    assertEquals(58, (int)therm.getBathTemp());
    therm.setBathTemp(100);
    assertEquals(70, (int)therm.getBathTemp());
  }

  @Test
  public void getAndSetLivingTemp() {
    assertEquals(67, (int)therm.getLivingTemp());
    therm.setLivingTemp(60);
    assertEquals(60, (int)therm.getLivingTemp());
    therm.setLivingTemp(0);
    assertEquals(60, (int)therm.getLivingTemp());
    therm.setLivingTemp(100);
    assertEquals(72, (int)therm.getLivingTemp());
  }

  @Test
  public void setHouseTemp() {
    // Start with low temps and move up
    therm.setHouseTemp(0);
    assertEquals(60, (int)therm.getBedTemp());
    assertEquals(58, (int)therm.getBathTemp());
    assertEquals(60, (int)therm.getLivingTemp());

    therm.setHouseTemp(59);
    assertEquals(60, (int)therm.getBedTemp());
    assertEquals(59, (int)therm.getBathTemp());
    assertEquals(60, (int)therm.getLivingTemp());

    therm.setHouseTemp(61);
    assertEquals(61, (int)therm.getBedTemp());
    assertEquals(61, (int)therm.getBathTemp());
    assertEquals(61, (int)therm.getLivingTemp());

    therm.setHouseTemp(69);
    assertEquals(68, (int)therm.getBedTemp());
    assertEquals(69, (int)therm.getBathTemp());
    assertEquals(69, (int)therm.getLivingTemp());

    therm.setHouseTemp(71);
    assertEquals(68, (int)therm.getBedTemp());
    assertEquals(70, (int)therm.getBathTemp());
    assertEquals(71, (int)therm.getLivingTemp());

    therm.setHouseTemp(100);
    assertEquals(68, (int)therm.getBedTemp());
    assertEquals(70, (int)therm.getBathTemp());
    assertEquals(72, (int)therm.getLivingTemp());
  }

  @Test
  public void getAndSetBedrooms() {
    Bedrooms b = new Bedrooms(68);
    therm.setBedrooms(b);
    assertEquals(b, therm.getBedrooms());
  }

  @Test
  public void getAndSetBathrooms() {
    Bathrooms b = new Bathrooms(68);
    therm.setBathrooms(b);
    assertEquals(b, therm.getBathrooms());
  }

  @Test
  public void getAndSetLivingRooms() {
    LivingRooms l = new LivingRooms(68);
    therm.setLivingRooms(l);
    assertEquals(l, therm.getLivingRooms());
  }
}