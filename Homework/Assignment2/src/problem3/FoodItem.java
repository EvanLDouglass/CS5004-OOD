package problem3;

import java.util.Objects;

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
   * @throws IllegalArgumentException if price or quantity is negative
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

  /* ===== Overrides ===== */

  /**
   * Represents the item as a string
   *
   * @return a string representation of this item
   */
  @Override
  public String toString() {
    return String.format("'%s', $%.2f/unit, %d in stock",
        name, pricePerUnit, quantity);
  }

  /**
   * Test equality of this FoodItem to another object.
   *
   * @param o the object to test
   * @return <pre>true</pre> if objects are equal, else <pre>false</pre>
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FoodItem foodItem = (FoodItem) o;
    return name.equals(foodItem.name) &&
        pricePerUnit.equals(foodItem.pricePerUnit) &&
        quantity.equals(foodItem.quantity);
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
