package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AbstractServiceTest {

  private ConcreteService service;

  @Before
  public void setUp() throws Exception {
    service = new ConcreteService("0001", "123 4th Ave.",
        PropertySize.LARGE, true, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeServices() {
    service = new ConcreteService("0001", "123 4th Ave.",
        PropertySize.LARGE, true, -1);
  }

  @Test
  public void toString1() {
    String result = "invoice=0001 address='123 4th Ave.' size=Large monthly=true serviced=1";
    assertEquals(result, service.toString());
  }

  @Test
  public void equals1() {
    assertEquals(service, service);
    assertNotEquals(null, service);

    ConcreteService service1 = new ConcreteService("0001", "123 4th Ave.",
        PropertySize.LARGE, true, 1);
    assertEquals(service1, service);
  }

  @Test
  public void hashCode1() {
    ConcreteService service1 = new ConcreteService("0001", "123 4th Ave.",
        PropertySize.LARGE, true, 1);
    assertEquals(service1.hashCode(), service.hashCode());
  }

  @Test
  public void getInvoiceID() {
    assertEquals("0001", service.getInvoiceID());
  }

  @Test
  public void getServiceAddress() {
    assertEquals("123 4th Ave.", service.getServiceAddress());
  }

  @Test
  public void getPropertySize() {
    assertEquals(PropertySize.LARGE, service.getPropertySize());
  }

  @Test
  public void isMonthly() {
    assertTrue(service.isMonthly());
  }

  @Test
  public void getNumServices() {
    assertEquals(1, (int) service.getNumServices());
  }

  // Test class
  private class ConcreteService extends AbstractService {

    private ConcreteService(String invoiceID, String serviceAddress,
        PropertySize propertySize, boolean isMonthlyService, Integer numServicesAtAddr) {
      super(invoiceID, serviceAddress, propertySize, isMonthlyService, numServicesAtAddr);
    }

    @Override
    public Double calculatePrice() {
      return null;
    }
  }
}