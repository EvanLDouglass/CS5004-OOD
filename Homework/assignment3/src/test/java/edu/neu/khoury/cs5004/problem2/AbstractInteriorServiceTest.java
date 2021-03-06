package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class AbstractInteriorServiceTest {

  private ConcreteInteriorService service;

  @Before
  public void setUp() throws Exception {
    service = new ConcreteInteriorService(
        "123ABC",
        "11th St.",
        PropertySize.MEDIUM,
        false,
        3,
        2
    );
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeNumPets() {
    service = new ConcreteInteriorService(
        "123ABC",
        "11th St.",
        PropertySize.MEDIUM,
        false,
        3,
        -1
    );
  }

  @Test
  public void petFee() {
    assertEquals(105.0, service.addPetFee(100.0), 0.0);

    service = new ConcreteInteriorService(
        "123ABC",
        "11th St.",
        PropertySize.MEDIUM,
        false,
        3,
        3
    );
    assertEquals(107.0, service.addPetFee(100.0), 0.0);

    service = new ConcreteInteriorService(
        "123ABC",
        "11th St.",
        PropertySize.MEDIUM,
        false,
        3,
        1
    );
    assertEquals(105.0, service.addPetFee(100.0), 0.0);

    service = new ConcreteInteriorService(
        "123ABC",
        "11th St.",
        PropertySize.MEDIUM,
        false,
        3,
        0
    );
    assertEquals(100.0, service.addPetFee(100.0), 0.0);
  }

  @Test
  public void toString1() {
    String result =
        "invoice=123ABC address='11th St.' size=Medium monthly=false serviced=3 pets=2";
    assertEquals(result, service.toString());
  }

  @Test
  public void equals1() {
    assertEquals(service, service);
    assertNotEquals(null, service);
    assertNotEquals("Hello", service);

    ConcreteInteriorService service1 = new ConcreteInteriorService(
        "123ABC",
        "11th St.",
        PropertySize.MEDIUM,
        false,
        3,
        2
    );
    assertEquals(service1, service);

    service1 = new ConcreteInteriorService(
        "123ABC",
        "11th St.",
        PropertySize.MEDIUM,
        false,
        2,
        2
    );
    assertNotEquals(service1, service);

    service1 = new ConcreteInteriorService(
        "123ABC",
        "11th St.",
        PropertySize.MEDIUM,
        false,
        3,
        0
    );
    assertNotEquals(service1, service);
  }

  @Test
  public void hashCode1() {
    ConcreteInteriorService service1 = new ConcreteInteriorService(
        "123ABC",
        "11th St.",
        PropertySize.MEDIUM,
        false,
        3,
        2
    );
    assertEquals(service1.hashCode(), service.hashCode());

    service1 = new ConcreteInteriorService(
        "123ABC",
        "11th St.",
        PropertySize.MEDIUM,
        false,
        3,
        1
    );
    assertNotEquals(service1.hashCode(), service.hashCode());
  }

  @Test
  public void getNumPetsAtAddr() {
    assertEquals(2, (int) service.getNumPetsAtAddr());
  }

  // Test class
  private class ConcreteInteriorService extends AbstractInteriorService {

    private ConcreteInteriorService(String invoiceID, String serviceAddress,
        PropertySize propertySize, boolean isMonthlyService, Integer numServicesAtAddr,
        Integer numPetsAtAddr) throws IllegalArgumentException {
      super(invoiceID, serviceAddress, propertySize, isMonthlyService, numServicesAtAddr,
          numPetsAtAddr);
    }

    @Override
    public Double calculatePrice() {
      return null;
    }
  }
}