package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BathroomsTest {
  private Bathrooms room;

  @Before
  public void setUp() {
    room = new Bathrooms(65);
  }

  @Test
  public void badValuesInConstructor() {
    room= new Bathrooms(0);
    assertEquals(58, (int)room.getCurrentTemp());
    room = new Bathrooms(100);
    assertEquals(70, (int)room.getCurrentTemp());
  }

  @Test
  public void setAndGetCurrentTemp() {
    room.setCurrentTemp(40);
    assertEquals(58, (int)room.getCurrentTemp());
    room.setCurrentTemp(100);
    assertEquals(70, (int)room.getCurrentTemp());
    room.setCurrentTemp(67);
    assertEquals(67, (int)room.getCurrentTemp());
  }
}