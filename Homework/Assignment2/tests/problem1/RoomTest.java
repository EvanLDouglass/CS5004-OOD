package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {
  private Room room;

  @Test
  public void setCurrentTemp() {
    room = new Room();
    room.setCurrentTemp(40);
    assertEquals(40, (int)room.getCurrentTemp());
    room.setCurrentTemp(100);
    assertEquals(100, (int)room.getCurrentTemp());
    room.setCurrentTemp(-89);
    assertEquals(-89, (int)room.getCurrentTemp());
  }
}