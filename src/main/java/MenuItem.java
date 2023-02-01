/**
 * Class to represent a menu item which can either be a main menu or a submenu
 * 
 */
public class MenuItem {
	
	// Private instance variable for the menu item's id
	int id;
	
	// Private instance variable for the menu item's description
	String desc;
	
	// Private instance variable to represent the submenu if this menu item is a main menu
	// If it is a submenu, this variable will hold the reference to its parent menu
	Menu menu = null; 
	
	/**
	 * Constructor to create a new menu item
	 * @param id the menu item's id
	 * @param desc the menu item's description
	 */
	public MenuItem(int id, String desc) {
		// Assign the parameter values to the instance variables
		this.id = id;
		this.desc = desc;
	}
	
	/**
	 * Method to mark a menu item as a main menu and set its submenu
	 * @param menu the submenu to be set for this menu item
	 */
	public  void marktheItemAsMenu(Menu menu) {
		// Assign the submenu to the menu instance variable
		this.menu = menu;
	}
	
	/**
	 * Method to check if a menu item is a main menu or a submenu
	 * @return true if this menu item is a main menu, false if it is a submenu
	 */
	public boolean isMenu() {
		// Check if the menu instance variable is pointing to a submenu
		return menu != null;
	}
	
	/**
	 * Method to print a menu item and its submenu if it is a main menu
	 */
	public void printItem() {
		// Print the id and description of this menu item
		System.out.println(this.id + " : " + this.desc);
		
		// If this menu item is a main menu, print its submenu
		if (this.isMenu()) {
			menu.printMenuitem();
		}
	}
}
