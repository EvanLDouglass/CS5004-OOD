package problem3;

/**
 * Class FoodItem represents a general food item in a store. It serves as a top level super class
 * for this package.
 *
 * @author evandouglass
 */
public class FoodItem {

  private String name;
  private Double pricePerUnit;
  private Integer quantity;

  /**
   * Constructor for FoodItem.
   *
   * @param name name of the item
   * @param pricePerUnit the current price per unit of the item
   * @param quantity the current quantity of the item in stock
   */
  public FoodItem(String name, Double pricePerUnit, Integer quantity)
      throws IllegalArgumentException {
    // Validate
    if (pricePerUnit < 0.0) {
      throw new IllegalArgumentException("price cannot be negative");
    } else if (quantity < 0) {
      throw new IllegalArgumentException("quantity cannot be negative");
    }

    // Assign
    this.name = name;
    this.pricePerUnit = pricePerUnit;
    this.quantity = quantity;
  }

  /* ===== Getters ===== */

  /**
   * Gets the item's name
   *
   * @return the item's name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the item's price per unit.
   *
   * @return the current price per unit
   */
  public Double getPricePerUnit() {
    return pricePerUnit;
  }

  /**
   * Gets the quantity of the item in stock.
   *
   * @return the quantity of the item
   */
  public Integer getQuantity() {
    return quantity;
  }
}
