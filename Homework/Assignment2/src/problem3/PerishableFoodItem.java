package problem3;

/**
 * Class PerishableFoodItem represents a perishable food item. It is a child of class FoodItem.
 *
 * @author evandouglass
 */
public class PerishableFoodItem extends FoodItem {

  public static final Integer MAX_QUANTITY = 100;

  private Integer orderDate;       // Days since May 15, 2019
  private Integer expirationDate;  // Days since May 15, 2019

  /**
   * Constructor for PerishableFoodItem.
   *
   * @param name name of the item
   * @param pricePerUnit the current price per unit of the item
   * @param quantity the current quantity of the item in stock
   * @param orderDate date of order, represented as the number of days since May 15, 2019
   * @param expirationDate date of expiration, represented as the number of days since May 15, 2019
   */
  public PerishableFoodItem(String name, Double pricePerUnit, Integer quantity,
      Integer orderDate, Integer expirationDate) throws IllegalArgumentException {
    super(name, pricePerUnit, quantity);

    // Validate
    if (orderDate >= expirationDate) {
      throw new IllegalArgumentException("don't order expired foods!");
    } else if (quantity > MAX_QUANTITY) {
      throw new IllegalArgumentException("we can't hold that many of this item!");
    }

    // Assign
    this.orderDate = orderDate;
    this.expirationDate = expirationDate;
  }

  /* ===== Getters ===== */

  /**
   * Get's the item's order date as the number of days since May 15, 2019.
   *
   * @return the item's order date as the number of days since May 15, 2019.
   */
  public Integer getOrderDate() {
    return orderDate;
  }

  /**
   * Get's the item's expiration date as the number of days since May 15, 2019.
   *
   * @return the item's expiration date as the number of days since May 15, 2019.
   */
  public Integer getExpirationDate() {
    return expirationDate;
  }
}
