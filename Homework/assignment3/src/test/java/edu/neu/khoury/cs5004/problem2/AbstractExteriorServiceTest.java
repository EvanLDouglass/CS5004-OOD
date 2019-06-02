package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class AbstractExteriorServiceTest {

  private ConcreteExteriorService service;

  @Before
  public void setUp() throws Exception {
    service = new ConcreteExteriorService(
        "000-1",
        "2121 5th",
        PropertySize.SMALL,
        true,
        9,
        6
    );
  }

  @Test(expected = IllegalArgumentException.class)
  public void monthTooLow() {
    service = new ConcreteExteriorService(
        "000-1",
        "2121 5th",
        PropertySize.SMALL,
        true,
        9,
        0
    );
  }

  @Test(expected = IllegalArgumentException.class)
  public void monthTooLHigh() {
    service = new ConcreteExteriorService(
        "000-1",
        "2121 5th",
        PropertySize.SMALL,
        true,
        9,
        13
    );
  }

  @Test
  public void calculatePrice() {
    assertEquals(160.0, service.calculatePrice(), 0.0);

    service = new ConcreteExteriorService(
        "000-1",
        "2121 5th",
        PropertySize.MEDIUM,
        true,
        9,
        6
    );
    assertEquals(160.0, service.calculatePrice(), 0.0);

    service = new ConcreteExteriorService(
        "000-1",
        "2121 5th",
        PropertySize.LARGE,
        true,
        9,
        6
    );
    assertEquals(320.0, service.calculatePrice(), 0.0);
  }

  @Test
  public void toString1() {
    String result =
        "invoice=000-1 address='2121 5th' size=Small monthly=true serviced=9 month=6";
    assertEquals(result, service.toString());
  }

  @Test
  public void equals1() {
    assertEquals(service, service);
    assertNotEquals(null, service);
    assertNotEquals("Hello", service);

    ConcreteExteriorService service1 = new ConcreteExteriorService(
        "000-1",
        "2121 5th",
        PropertySize.SMALL,
        true,
        9,
        4
    );
    assertNotEquals(service1, service);

    service1 = new ConcreteExteriorService(
        "000-1",
        "2121 5th",
        PropertySize.SMALL,
        true,
        9,
        6
    );
    assertEquals(service1, service);
  }

  @Test
  public void hashCode1() {
    ConcreteExteriorService service1 = new ConcreteExteriorService(
        "000-1",
        "2121 5th",
        PropertySize.SMALL,
        true,
        9,
        6
    );
    assertEquals(service1.hashCode(), service.hashCode());

    service1 = new ConcreteExteriorService(
        "000-1",
        "2121 5th",
        PropertySize.SMALL,
        true,
        9,
        5
    );
    assertNotEquals(service1.hashCode(), service.hashCode());
  }

  @Test
  public void getMonth() {
    assertEquals(6, (int) service.getMonth());
  }

  // Test class
  private class ConcreteExteriorService extends AbstractExteriorService {

    private ConcreteExteriorService(String invoiceID, String serviceAddress,
        PropertySize propertySize, boolean isMonthlyService, Integer numServicesAtAddr,
        Integer month) throws IllegalArgumentException {
      super(invoiceID, serviceAddress, propertySize, isMonthlyService, numServicesAtAddr, month);
    }
  }
}