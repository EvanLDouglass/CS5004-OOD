package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoomTest {
  private Room room;

  @Before
  public void setUp() throws Exception {
    room = new Room(65);
  }

  @Test
  public void getCurrentTemp() {
    assertEquals(65, (int)room.getCurrentTemp());
  }

  @Test
  public void setCurrentTemp() {
    room.setCurrentTemp(40);
    assertEquals(40, (int)room.getCurrentTemp());
    room.setCurrentTemp(0);
    assertEquals(0, (int)room.getCurrentTemp());
    room.setCurrentTemp(-50);
    assertEquals(-50, (int)room.getCurrentTemp());
  }
}