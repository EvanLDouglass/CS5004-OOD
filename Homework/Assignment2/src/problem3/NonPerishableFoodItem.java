package problem3;

/**
 * Class NonPerishableFoodItem represents a non-perishable food item, such as dried goods.
 *
 * @author evandouglass
 */
public class NonPerishableFoodItem extends FoodItem {

  public static final Integer MAX_QUANTITY = 250;

  /**
   * Constructor for FoodItem.
   *
   * @param name name of the item
   * @param pricePerUnit the current price per unit of the item
   * @param quantity the current quantity of the item in stock
   */
  public NonPerishableFoodItem(String name, Double pricePerUnit, Integer quantity)
      throws IllegalArgumentException {
    super(name, pricePerUnit, quantity);

    // Validate
    // Has to be after creation due to syntax rules
    if (quantity > MAX_QUANTITY) {
      throw new IllegalArgumentException("we can't hold that many of these items!");
    }
  }
}
