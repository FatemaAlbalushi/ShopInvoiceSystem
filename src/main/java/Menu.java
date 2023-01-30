import java.util.ArrayList;

/**
 * This is the menu class that stores and displays the menu items
 *
 */
public class Menu {
	String title; // Title of the menu
	private ArrayList<MenuItem> listOfMenuItems = new ArrayList<>();// ArrayList to store the menu items


	/**
	 * Returns the title of the menu.
	 * 
	 * @return the title of the menu
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the menu.
	 * 
	 * @param title the title of the menu
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Method to add menu item to the ArrayList
	 * 
	 * @param menuItem
	 */
	public void addMenuitem(MenuItem menuItem) {
		listOfMenuItems.add(menuItem);
	}

	/**
	 * Method to get a menu item based on its id
	 * 
	 * @param id
	 * @return
	 */
	public MenuItem getMenuItem(int id) {
		return listOfMenuItems.get(id - 1);
	}

	/**
	 * Method to print the menu items
	 */
	public void printMenuitem() {

		if (title != null) { // Print the title if it is not null
			System.out.println(title);
		}
		for (MenuItem currItem : listOfMenuItems) { // Loop through the menu items and print
			System.out.println(currItem.id + " : " + currItem.desc);
		}
	}
}
