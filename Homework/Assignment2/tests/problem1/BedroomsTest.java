package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BedroomsTest {
  private Bedrooms room;

  @Before
  public void setUp() {
    room = new Bedrooms(65);
  }

  @Test
  public void badValuesInConstructor() {
    room= new Bedrooms(0);
    assertEquals(60, (int)room.getCurrentTemp());
    room = new Bedrooms(100);
    assertEquals(68, (int)room.getCurrentTemp());
  }

  @Test
  public void setAndGetCurrentTemp() {
    room.setCurrentTemp(40);
    assertEquals(60, (int)room.getCurrentTemp());
    room.setCurrentTemp(100);
    assertEquals(68, (int)room.getCurrentTemp());
    room.setCurrentTemp(67);
    assertEquals(67, (int)room.getCurrentTemp());
  }
}