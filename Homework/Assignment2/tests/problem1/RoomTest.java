package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {
  private Room room;

  @Test
  public void setCurrentTemp() {
    room = new Room(55);
    assertEquals(55, (int)room.getCurrentTemp());

    room = new Room(-40);
    assertEquals(-40, (int)room.getCurrentTemp());
  }
}