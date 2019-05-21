import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Name;
import problem1.Runner;

public class RunnerTest {

  private Runner runner;

  @Before

  public void setUp() {
    Name name = new Name("Evan", "Lathrop", "Douglass");
    runner = new Runner(name, 182.88, 195.9, "Fooseball", 10.0,
        120.5, "Kentucky Derby");
  }

  @Test
  public void getBest5KTime() {
    assertEquals(10.0, runner.getBest5KTime(), 0.0);
  }

  @Test
  public void getBestHalfMarathonTime() {
    assertEquals(120.5, runner.getBestHalfMarathonTime(), 0.0);
  }

  @Test
  public void getFavRunningEvent() {
    assertEquals("Kentucky Derby", runner.getFavRunningEvent());
  }
}