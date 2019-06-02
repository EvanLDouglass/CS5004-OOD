package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GardeningServiceTest {

  private GardeningService service;

  @Before
  public void setUp() throws Exception {
    service = new GardeningService(
        "0001",
        "1st Ave",
        PropertySize.SMALL,
        false,
        1,
        12
    );
  }

  @Test
  public void calculatePrice() {
    assertEquals(180.0, service.calculatePrice(), 0.0);

    service = new GardeningService(
        "0001",
        "1st Ave",
        PropertySize.MEDIUM,
        false,
        1,
        12
    );
    assertEquals(180.0, service.calculatePrice(), 0.0);

    service = new GardeningService(
        "0001",
        "1st Ave",
        PropertySize.LARGE,
        false,
        1,
        12
    );
    assertEquals(340.0, service.calculatePrice(), 0.0);
  }

  @Test
  public void toString1() {
    String result =
        "GardeningService: invoice=0001 address='1st Ave' size=Small "
            + "monthly=false serviced=1 month=12";
    assertEquals(result, service.toString());
  }
}