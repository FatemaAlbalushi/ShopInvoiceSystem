
/**
 * This is the menu item class that represent the action that can be selected 
 *
 */
public class MenuItem {
	
	int id;
	String desc;
	Menu menu = null; // To chech if its menu or submenu if it doesnot point to null then its submenu
	
	/**
	 * @param id 
	 * @param desc
	 */
	public MenuItem(int id, String desc) {
		this.id = id;
		this.desc = desc;
		
	}
	
	public  void marktheItemAsMenu(Menu menu) {
	      this.menu=menu;
		
	}
	
	
	public boolean isMenu() {
		return menu!=null;
		
	}
	
	public void printItem() {
		System.out.println(this.id + " : " + this.desc);
		if (this.isMenu()) {
			menu.printMenuitem();
		}
		
	}

}
