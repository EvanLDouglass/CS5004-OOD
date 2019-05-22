package problem3;

/**
 * Class FoodOrderingSystem works with with FoodItems and it's child classes to implement the basic
 * functionality of an automatic food ordering system.
 *
 * @author evandouglass
 */
public class FoodOrderingSystem {

  // I've separated out the perishable food items from the non-perishable items
  // because they have different functionality. As of now, the child classes of
  // each do not have additional functionality, so any Meat, Fruit or Vegetable
  // can be treated as a Perishable food item, same for Rice and Pasta objects in
  // the NonPerishableFoodItem array.
  //
  // Tracking could work by adding objects to each list as appropriate then updating
  // the amount in-stock of different items in the lists when necessary. To create
  // a list of orders, we could scan through each array and see which objects
  // had below half of their maximum stock.
  private PerishableFoodItem[] perishableInventory;
  private NonPerishableFoodItem[] nonPerishableInventory;

  /**
   * Constructor for <pre>FoodOrderingSystem</pre>.
   *
   * @param perishables an array of <pre>PerishableFoodItem</pre>s
   * @param nonPerishables an array of <pre>NonPerishableFoodItem</pre>s
   */
  public FoodOrderingSystem(PerishableFoodItem[] perishables,
      NonPerishableFoodItem[] nonPerishables) {
    this.perishableInventory = perishables;
    this.nonPerishableInventory = nonPerishables;
  }

  /* ===== Getters ===== */

  public PerishableFoodItem[] getPerishables() {
    return perishableInventory;
  }

  public NonPerishableFoodItem[] getNonPerishables() {
    return nonPerishableInventory;
  }

  /* ===== Methods ===== */
  // For this assignment, this class is not required to be functional.
  // However, I wanted to include an idea of basic future functionality.
  // Below are method signatures that could be used in this class
  // to implement a food ordering system using the other classes in this
  // package.

  /*
   * Generates a list of food items to order and how many units of each are needed. The list is in
   * the form:
   * <pre>
   * Perishable:
   *     item name - quantity to order
   *     ...
   * Non-perishable:
   *     item name - quantity to order
   *     ...
   * </pre>
   *
   * @return a list of items and how many of each are ordered, as a String
   */
  //public String generateOrderList();

  /*
   * Adds a food item to the inventory tracking system.
   *
   * @param item a perishable food item to add to inventory
   * @return a new <pre>FoodOrderingSystem</pre> with the new item.
   */
  //public FoodOrderingSystem addItemToTrack(PerishableFoodItem item);

  /*
   * Adds a food item to the inventory tracking system.
   *
   * @param item a non-perishable food item to add to inventory
   * @return a new <pre>FoodOrderingSystem</pre> with the new item.
   */
  //public FoodOrderingSystem addItemToTrack(NonPerishableFoodItem item);

  /*
   * Updates a food item in the tracking system with the given quantity.
   *
   * @param foodName the name of the item; must be an exact match
   * @param isPerishable <pre>true</pre> if the item is perishable, else <pre>false</pre>
   * @param numInStock the amount of this item currently in stock.
   * @return a new <pre>FoodOrderingSystem</pre> with the new amount
   */
  //public FoodOrderingSystem updateQuantity(String foodName, boolean isPerishable, Integer numInStock);
}
