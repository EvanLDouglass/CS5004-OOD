package edu.neu.khoury.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PreschoolTeacherTest {

  private PreschoolTeacher t;

  @Before
  public void setUp() throws Exception {
    t = new PreschoolTeacher(new Name("Evan", "Douglass"),
        "306",
        new Name("John", "Johns"),
        false,
        2,
        8,
        1
    );
  }

  @Test
  public void toString1() {
    String result = "PreschoolTeacher: name=Evan Douglass classroom=306 coTeacher=John Johns "
        + "onVacation=false numChildren=2 maxChildren=8 childrenCanRead=1";
    assertEquals(result, t.toString());
  }

  @Test
  public void equals1() {
    PreschoolTeacher t2 = new PreschoolTeacher(new Name("Evan", "Douglass"),
        "306",
        new Name("John", "Johns"),
        false,
        2,
        8,
        1
    );
    assertEquals(t2, t);

    t2.setCurrNumCanRead(2);
    assertNotEquals(t2, t);
  }

  @Test
  public void hashCode1() {
    PreschoolTeacher t2 = new PreschoolTeacher(new Name("Evan", "Douglass"),
        "306",
        new Name("John", "Johns"),
        false,
        2,
        8,
        1
    );
    assertEquals(t2.hashCode(), t.hashCode());

    t2.setCurrNumCanRead(0);
    assertNotEquals(t2.hashCode(), t.hashCode());
  }

  @Test
  public void getAndSetCurrNumCanRead() {
    assertEquals(1, (int) t.getCurrNumCanRead());
    t.setCurrNumCanRead(2);
    assertEquals(2, (int) t.getCurrNumCanRead());
    t.setCurrNumCanRead(0);
    assertEquals(0, (int) t.getCurrNumCanRead());

    try {
      t.setCurrNumCanRead(3);
      fail("cannot have more readers (3) than are in the class (2)");
    } catch (IllegalArgumentException e) {
      // Passed
    }

    try {
      t.setCurrNumCanRead(-1);
      fail("cannot have a negative number of readers");
    } catch (IllegalArgumentException e) {
      // Passed
    }
  }
}