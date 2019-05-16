package problem3;

/**
 * Class Menu represents a menu used in a restaurant.
 */
public class Menu {
  private String meals;
  private String desserts;
  private String beverages;
  private String drinks;

  /**
   * Constructor fo Menu
   * @param meals - meals offered
   * @param desserts - desserts offered
   * @param beverages - beverages offered
   * @param drinks - drinks offered
   */
  public Menu(String meals, String desserts, String beverages, String drinks) {
    this.meals = meals;
    this.desserts = desserts;
    this.beverages = beverages;
    this.drinks = drinks;
  }

  /**
   * @return meals offered
   */
  public String getMeals() {
    return meals;
  }

  /**
   * @param meals - meals offered
   */
  public void setMeals(String meals) {
    this.meals = meals;
  }

  /**
   * @return desserts offered
   */
  public String getDesserts() {
    return desserts;
  }

  /**
   * @param desserts - desserts offered
   */
  public void setDesserts(String desserts) {
    this.desserts = desserts;
  }

  /**
   * @return beverages offered
   */
  public String getBeverages() {
    return beverages;
  }

  /**
   * @param beverages - beverages offered
   */
  public void setBeverages(String beverages) {
    this.beverages = beverages;
  }

  /**
   * @return drinks offered
   */
  public String getDrinks() {
    return drinks;
  }

  /**
   * @param drinks - drinks offered
   */
  public void setDrinks(String drinks) {
    this.drinks = drinks;
  }
}
