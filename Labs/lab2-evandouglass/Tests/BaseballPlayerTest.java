import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.BaseballPlayer;
import problem1.Name;

public class BaseballPlayerTest {

  private BaseballPlayer player;

  @Before
  public void setUp() {
    Name name = new Name("Evan", "Lathrop", "Douglass");
    player = new BaseballPlayer(name, 182.88, 195.9, "MLB", "Mariners",
        0.999, 56);
  }

  @Test
  public void getTeam() {
    assertEquals("Mariners", player.getTeam());
  }

  @Test
  public void getBattingAvg() {
    assertEquals(0.999, player.getBattingAvg(), 0.0);
  }

  @Test
  public void getSeasonHomeRuns() {
    assertEquals(new Integer(56), player.getSeasonHomeRuns());
  }
}