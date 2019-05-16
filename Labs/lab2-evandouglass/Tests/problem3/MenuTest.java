package problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MenuTest {
  private Menu menu;

  @Before
  public void setUp() {
    menu = new Menu("", "", "", "");
  }

  @Test
  public void getAndSetMeals() {
    assertEquals("", menu.getMeals());
    menu.setMeals("Burgers");
    assertEquals("Burgers", menu.getMeals());
  }

  @Test
  public void getAndSetDesserts() {
    assertEquals("", menu.getDesserts());
    menu.setDesserts("Ice Cream");
    assertEquals("Ice Cream", menu.getDesserts());
  }

  @Test
  public void getAndSetBeverages() {
    assertEquals("", menu.getBeverages());
    menu.setBeverages("Coke");
    assertEquals("Coke", menu.getBeverages());
  }

  @Test
  public void getAndSetDrinks() {
    assertEquals("", menu.getDrinks());
    menu.setDrinks("Rum and Coke");
    assertEquals("Rum and Coke", menu.getDrinks());
  }
}