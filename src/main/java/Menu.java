import java.util.ArrayList;

/**
 * This is the menu class that allows the user to add the menu 
 *
 */
public class Menu {
	  String title;
	  ArrayList<MenuItem>listOfMenuItems =  new ArrayList<MenuItem>();
	
	public Menu() {
//		this.title= title;
//		listOfMenuItems.add(menuItem);
	}
	
	public void addMenuitem(MenuItem menuItem) {
		listOfMenuItems.add(menuItem);	
	}
	
	
	public MenuItem getMenuItem(int id) {
		return listOfMenuItems.get(id-1);
	}
	
	public void printMenuitem() {
		
		if (title!=null) {
			System.out.println(title);
		}
		for(MenuItem currItem: listOfMenuItems) {
			System.out.println(currItem.id+" : "+ currItem.desc);
		}
		
	}
}
 