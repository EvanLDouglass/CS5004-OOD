import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Athlete;
import problem1.Name;

public class AthleteTest {

  private Athlete athlete;
  private Name name;

  @Before
  public void setUp() {
    name = new Name("Evan", "Lathrop", "Douglass");
    athlete = new Athlete(name, 182.88, (double) 195, "Fooseball");
  }

  @Test
  public void getAthletesName() {
    assertEquals(name, athlete.getAthletesName());
  }

  @Test
  public void getHeight() {
    assertEquals(182.88, athlete.getHeight(), 0.0);
  }

  @Test
  public void getWeight() {
    assertEquals(195.0, athlete.getWeight(), 0.0);
  }

  @Test
  public void getLeague() {
    assertEquals("Fooseball", athlete.getLeague());
  }
}