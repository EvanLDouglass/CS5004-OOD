package problem3;

/**
 * Class Pasta represents a type of non-perishable food. It does not add any
 * functionality, but serves as a way to categorize perishable foods into sub-categories.
 *
 * @author evandouglass
 */
public class Pasta extends NonPerishableFoodItem {

  /**
   * Constructor for <pre>Pasta</pre>
   *
   * @param name name of the food
   * @param pricePerUnit the price per unit
   * @param quantity how many units of this item are in stock
   * @throws IllegalArgumentException if the price or quantity are negative
   */
  public Pasta(String name, Double pricePerUnit, Integer quantity) throws IllegalArgumentException {
    super(name, pricePerUnit, quantity);
  }
}
