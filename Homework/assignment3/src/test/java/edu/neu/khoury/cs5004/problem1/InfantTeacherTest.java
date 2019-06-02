package edu.neu.khoury.cs5004.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*
 * Contains all the tests for this class as well as those for
 * AbstractTeacher and AbstractFullTimeTeacher.
 */
public class InfantTeacherTest {

  private InfantTeacher t;

  @Before
  public void setUp() throws Exception {
    t = new InfantTeacher(
        new Name("Evan", "Douglass"),
        "306",
        new Name("John", "Johns"),
        false,
        2,
        8,
        1,
        1
    );
  }

  @Test
  public void toString1() {
    // The super class toString methods are strung together
    // so this will test all of them.
    String result = "InfantTeacher: name=Evan Douglass classroom=306 coTeacher=John Johns "
    + "onVacation=false numChildren=2 maxChildren=8 crawlers=1 walkers=1";

    assertEquals(result, t.toString());
  }

  @Test
  public void equals1() {
    // The super class equals methods are strung together
    // so this will test all of them.
    InfantTeacher t2 = new InfantTeacher(
        new Name("Evan", "Douglass"),
        "306",
        new Name("John", "Johns"),
        false,
        2,
        8,
        1,
        1
    );
    assertEquals(t, t2);

    t2.setCurrNumCrawlers(0);
    assertNotEquals(t, t2);
  }

  @Test
  public void hashCode1() {
    // The super class hashCode methods are strung together
    // so this will test all of them.
    InfantTeacher t2 = new InfantTeacher(
        new Name("Evan", "Douglass"),
        "306",
        new Name("John", "Johns"),
        false,
        2,
        8,
        1,
        1
    );
    assertEquals(t2.hashCode(), t.hashCode());

    t2.setCurrNumWalkers(0);
    assertNotEquals(t2.hashCode(), t.hashCode());
  }

  @Test
  public void getName() {
    assertEquals(new Name("Evan", "Douglass"), t.getName());
  }

  @Test
  public void getAndSetClassroom() {
    assertEquals("306", t.getClassroom());
    t.setClassroom("Orcas");
    assertEquals("Orcas", t.getClassroom());
  }

  @Test
  public void getAndSetCoTeacher() {
    assertEquals(new Name("John", "Johns"), t.getCoTeacher());
    t.setCoTeacher(new Name("", ""));
    assertEquals(new Name("", ""), t.getCoTeacher());
  }

  @Test
  public void getAndSetVacationStatus() {
    assertFalse(t.getVacationStatus());
    t.setVacationStatus(true);
    assertTrue(t.getVacationStatus());
  }

  @Test
  public void getAndSetCurrNumChildren() {
    assertEquals(2, (int) t.getCurrNumChildren());
    t.setCurrNumChildren(6);
    assertEquals(6, (int) t.getCurrNumChildren());

    try {
      // more than max
      t.setCurrNumChildren(9);
      fail("Max is 8, set to 9");
    } catch (IllegalArgumentException e) {
      // Pass
    }

    try {
      // more than max
      t.setCurrNumChildren(-1);
      fail("Can't have negative students");
    } catch (IllegalArgumentException e) {
      // Pass
    }
  }

  @Test
  public void getMaxChildren() {
    assertEquals(8, (int) t.getMaxChildren());
    t.setCoTeacher(new Name("", ""));  // Max must be lowered
    assertEquals(4, (int) t.getMaxChildren());
  }

  @Test
  public void getAndSetCurrNumCrawlers() {
    assertEquals(1, (int) t.getCurrNumCrawlers());
    t.setCurrNumCrawlers(0);
    assertEquals(0, (int) t.getCurrNumCrawlers());

    try {
      t.setCurrNumCrawlers(2);
      fail("number set was above number of children");
    } catch (IllegalArgumentException e){
      // Pass
    }

    try {
      t.setCurrNumCrawlers(-1);
      fail("number set was below zero");
    } catch (IllegalArgumentException e){
      // Pass
    }
  }

  @Test
  public void getAndSetCurrNumWalkers() {
    assertEquals(1, (int) t.getCurrNumWalkers());
    t.setCurrNumWalkers(0);
    assertEquals(0, (int) t.getCurrNumWalkers());

    try {
      t.setCurrNumWalkers(2);  // only 2 children and now 3 between walkers and crawlers
      fail("number set was above max");
    } catch (IllegalArgumentException e){
      // Pass
    }

    try {
      t.setCurrNumWalkers(-1);
      fail("number set was below zero");
    } catch (IllegalArgumentException e){
      // Pass
    }
  }

  @Test
  public void hasCoTeacher() {
    assertTrue(t.hasCoTeacher());
    t.setCoTeacher(new Name("", ""));
    assertFalse(t.hasCoTeacher());
  }
}