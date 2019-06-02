package edu.neu.khoury.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubstituteTeacherTest {

  private SubstituteTeacher t;

  @Before
  public void setUp() throws Exception {
    t = new SubstituteTeacher(
        new Name("Evan", "Douglass"),
        "306",
        new Name("John", "Johns"),
        false,
        5
    );
  }

  @Test
  public void toString1() {
    String result = "SubstituteTeacher: name=Evan Douglass classroom=306 coTeacher=John Johns "
    + "onVacation=false daysInClass=5";
    assertEquals(result, t.toString());
  }

  @Test
  public void equals1() {
    SubstituteTeacher t2 = new SubstituteTeacher(
        new Name("Evan", "Douglass"),
        "306",
        new Name("John", "Johns"),
        false,
        5
    );
    assertEquals(t, t2);

    t.setNumDaysInClass(0);
    assertNotEquals(t, t2);
  }

  @Test
  public void hashCode1() {
    SubstituteTeacher t2 = new SubstituteTeacher(
        new Name("Evan", "Douglass"),
        "306",
        new Name("John", "Johns"),
        false,
        5
    );
    assertEquals(t.hashCode(), t2.hashCode());

    t.setNumDaysInClass(0);
    assertNotEquals(t.hashCode(), t2.hashCode());
  }

  @Test
  public void getAndSetNumDaysInClass() {
    assertEquals(5, (int) t.getNumDaysInClass());
    t.setNumDaysInClass(6);
    assertEquals(6, (int) t.getNumDaysInClass());
    t.setNumDaysInClass(0);
    assertEquals(0, (int) t.getNumDaysInClass());

    try {
      t.setNumDaysInClass(-1);
      fail("Days in class cannot be negative");
    } catch (IllegalArgumentException e) {
      // Passed
    }
  }
}