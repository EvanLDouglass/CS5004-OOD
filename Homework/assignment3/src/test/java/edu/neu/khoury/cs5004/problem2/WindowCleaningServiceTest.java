package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class WindowCleaningServiceTest {

  private WindowCleaningService service;

  @Before
  public void setUp() throws Exception {
    service = new WindowCleaningService(
        "0001",
        "2432 9th",
        PropertySize.SMALL,
        false,
        5,
        4,
        1
    );
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeFloors() throws TooManyFloorsException {
    service = new WindowCleaningService(
        "0001",
        "2432 9th",
        PropertySize.SMALL,
        false,
        5,
        4,
        0
    );
  }

  @Test(expected = TooManyFloorsException.class)
  public void tooManyFloors() throws TooManyFloorsException {
    service = new WindowCleaningService(
        "0001",
        "2432 9th",
        PropertySize.SMALL,
        false,
        5,
        4,
        4
    );
  }

  @Test
  public void calculatePrice() throws TooManyFloorsException {
    assertEquals(160.0, service.calculatePrice(), 0.0);

    service = new WindowCleaningService(
        "0001",
        "2432 9th",
        PropertySize.SMALL,
        false,
        5,
        4,
        2
    );
    assertEquals(168.0, service.calculatePrice(), 0.0);

    service = new WindowCleaningService(
        "0001",
        "2432 9th",
        PropertySize.MEDIUM,
        false,
        5,
        4,
        3
    );
    assertEquals(168.0, service.calculatePrice(), 0.0);

    service = new WindowCleaningService(
        "0001",
        "2432 9th",
        PropertySize.LARGE,
        false,
        5,
        4,
        3
    );
    assertEquals(336.0, service.calculatePrice(), 0.0);

    service = new WindowCleaningService(
        "0001",
        "2432 9th",
        PropertySize.LARGE,
        true,
        5,
        4,
        3
    );
    assertEquals(302.4, service.calculatePrice(), 0.00001);

    service = new WindowCleaningService(
        "0001",
        "2432 9th",
        PropertySize.LARGE,
        true,
        29,
        4,
        3
    );
    assertEquals(168.0, service.calculatePrice(), 0.0);
  }

  @Test
  public void toString1() {
    String result =
        "WindowCleaningService: invoice=0001 address='2432 9th' "
            + "size=Small monthly=false serviced=5 month=4 floors=1";
    assertEquals(result, service.toString());
  }

  @Test
  public void equals1() throws TooManyFloorsException {
    assertEquals(service, service);
    assertNotEquals(null, service);
    assertNotEquals("Hello", service);

    WindowCleaningService service1 = new WindowCleaningService(
        "0001",
        "2432 9th",
        PropertySize.SMALL,
        false,
        5,
        4,
        1
    );
    assertEquals(service1, service);

    service1 = new WindowCleaningService(
        "0001",
        "2432 9th",
        PropertySize.SMALL,
        false,
        5,
        4,
        2
    );
    assertNotEquals(service1, service);
  }

  @Test
  public void hashCode1() throws TooManyFloorsException {
    WindowCleaningService service1 = new WindowCleaningService(
        "0001",
        "2432 9th",
        PropertySize.SMALL,
        false,
        5,
        4,
        1
    );
    assertEquals(service1.hashCode(), service.hashCode());

    service1 = new WindowCleaningService(
        "0001",
        "2432 9th",
        PropertySize.MEDIUM,
        false,
        5,
        4,
        1
    );
    assertNotEquals(service1.hashCode(), service.hashCode());
  }

  @Test
  public void getNumFloors() {
    assertEquals(1, (int) service.getNumFloors());
  }
}