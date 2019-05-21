package problem3;

import java.util.Objects;

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

  /* ===== Overrides ===== */

  /**
   * Formats item as a string
   *
   * @return the item as a string
   */
  public String toString() {
    return super.toString() +
        String.format(", ordered on day %d, expires on day %d",
            orderDate, expirationDate);
  }

  /**
   * Tests for equality
   *
   * @param o the object to test
   * @return <pre>true</pre> if equal, else <pre>false</pre>
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    PerishableFoodItem that = (PerishableFoodItem) o;
    return orderDate.equals(that.orderDate) &&
        expirationDate.equals(that.expirationDate);
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
