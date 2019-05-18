package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LivingRoomsTest {
  private LivingRooms room;

  @Before
  public void setUp() {
    room = new LivingRooms(65);
  }

  @Test
  public void badValuesInConstructor() {
    room= new LivingRooms(0);
    assertEquals(60, (int)room.getCurrentTemp());
    room = new LivingRooms(100);
    assertEquals(72, (int)room.getCurrentTemp());
  }

  @Test
  public void setAndGetCurrentTemp() {
    room.setCurrentTemp(40);
    assertEquals(60, (int)room.getCurrentTemp());
    room.setCurrentTemp(100);
    assertEquals(72, (int)room.getCurrentTemp());
    room.setCurrentTemp(67);
    assertEquals(67, (int)room.getCurrentTemp());
  }
}