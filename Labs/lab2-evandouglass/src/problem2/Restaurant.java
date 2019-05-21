package problem2;

import problem3.Menu;

/**
 * Class Restaurant represents a restaurant, with a name, address, and notification if it is open or closed.
 * @author evandouglass
 */
public class Restaurant {

  private String name;
  private String address;
  private boolean open;
  private Menu menu;

  /**
   * Detailed constructor for Restaurant.
   * @param name - name of the restaurant
   * @param address - street address
   * @param open - whether the restaurant is open (true) or closed (false)
   * @param menu - the restaurant's menu as a String
   */
  public Restaurant(String name, String address, boolean open, Menu menu) {
    this.name = name;
    this.address = address;
    this.open = open;
    this.menu = menu;
  }

  /**
   * Basic constructor. Does not instantiate fields
   */
  public Restaurant() {
  }

  /**
   * @return the restaurant name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the restaurant name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the restaurant address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the restaurant address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return true if open, false if closed
   */
  public boolean isOpen() {
    return open;
  }

  /**
   * @param open true if open, false if closed
   */
  public void setOpen(boolean open) {
    this.open = open;
  }

  /**
   * @return the menu
   */
  public Menu getMenu() {
    return menu;
  }

  /**
   * @param menu - the menu
   */
  public void setMenu(Menu menu) {
    this.menu = menu;
  }
}
