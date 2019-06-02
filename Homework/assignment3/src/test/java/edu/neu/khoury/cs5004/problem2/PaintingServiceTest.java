package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaintingServiceTest {

  private PaintingService service;

  @Before
  public void setUp() throws Exception {
    service = new PaintingService(
        "1-A",
        "123 4th",
        PropertySize.SMALL,
        true,
        3,
        0
    );
  }

  @Test
  public void calculatePrice() {
    assertEquals(1152.0, service.calculatePrice(), 0.0);

    service = new PaintingService(
        "1-A",
        "123 4th",
        PropertySize.MEDIUM,
        false,
        3,
        0
    );
    assertEquals(1280.0, service.calculatePrice(), 0.0);

    service = new PaintingService(
        "1-A",
        "123 4th",
        PropertySize.LARGE,
        false,
        3,
        0
    );
    assertEquals(1920.0, service.calculatePrice(), 0.0);

    service = new PaintingService(
        "1-A",
        "123 4th",
        PropertySize.LARGE,
        true,
        39,
        0
    );
    assertEquals(960.0, service.calculatePrice(), 0.0);
  }

  @Test
  public void priceWithPets() {
    service = new PaintingService(
        "1-A",
        "123 4th",
        PropertySize.SMALL,
        true,
        3,
        1
    );
    assertEquals(1344.0, service.calculatePrice(), 0.0);

    service = new PaintingService(
        "1-A",
        "123 4th",
        PropertySize.MEDIUM,
        true,
        3,
        2
    );
    assertEquals(1344.0, service.calculatePrice(), 0.0);

    service = new PaintingService(
        "1-A",
        "123 4th",
        PropertySize.LARGE,
        true,
        3,
        3
    );
    assertEquals(2054.4, service.calculatePrice(), 0.00001);
  }

  @Test
  public void toString1() {
    String result =
        "PaintingService: invoice=1-A address='123 4th' size=Small monthly=true serviced=3 pets=0";
    assertEquals(result, service.toString());
  }
}