package problem3;

/**
 * Class Vegetable represents a type of vegetable. It is a child of PerishableFoodItem. It does not
 * add any functionality, but serves as a way to categorize perishable foods into sub-categories.
 *
 * @author evandouglass
 */
public class Vegetable extends PerishableFoodItem {

  // Note that the equals method does not need to be updated because the super equals
  // checks if the two classes are the same. They have the same fields otherwise,
  // so it doesn't matter that the other object is then turned into the super class.

  /**
   * Constructor for <pre>Vegetable</pre>.
   *
   * @param name name of the item
   * @param pricePerUnit the current price per unit of the item
   * @param quantity the current quantity of the item in stock
   * @param orderDate date of order, represented as the number of days since May 15, 2019
   * @param expirationDate date of expiration, represented as the number of days since May 15, 2019
   */
  public Vegetable(String name, Double pricePerUnit, Integer quantity, Integer orderDate,
      Integer expirationDate) throws IllegalArgumentException {
    super(name, pricePerUnit, quantity, orderDate, expirationDate);
  }
}
