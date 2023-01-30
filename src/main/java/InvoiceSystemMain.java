import java.util.Scanner;



/**
 * @author LAP-10
 *
 */
public class InvoiceSystemMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Application Main Menu:");
		//System.out.println();
		
		Menu subMenuAdminAction1 = new Menu();
		subMenuAdminAction1.addMenuitem(new MenuItem(1, "Load Data"));
		subMenuAdminAction1.addMenuitem(new MenuItem(2, "Set Shop Name"));
		subMenuAdminAction1.addMenuitem(new MenuItem(3, "Set Invoice Header"));
		subMenuAdminAction1.addMenuitem(new MenuItem(4, "Go Back"));
		
		Menu subMenuAdminAction2 = new Menu();
		subMenuAdminAction2.addMenuitem(new MenuItem(1, "Add Items"));
		subMenuAdminAction2.addMenuitem(new MenuItem(2, "Delete Items"));
		subMenuAdminAction2.addMenuitem(new MenuItem(3, "Change Item Price"));
		subMenuAdminAction2.addMenuitem(new MenuItem(3, "Report All Items"));
		subMenuAdminAction2.addMenuitem(new MenuItem(4, "Go Back"));
		
		MenuItem adminActionMenu1= new MenuItem(1, "Shop Settings");
		adminActionMenu1.marktheItemAsMenu(subMenuAdminAction2);
		
		MenuItem adminActionMenu2= new MenuItem(2, "Manage Shop Items");
		adminActionMenu2.marktheItemAsMenu(subMenuAdminAction2);
		
		
        Menu patentMenu = new Menu();
        patentMenu.addMenuitem(adminActionMenu1);
        patentMenu.addMenuitem(adminActionMenu2);
        patentMenu.addMenuitem(new MenuItem(3, "Create New Invoice"));
        patentMenu.addMenuitem(new MenuItem(4, "Report: Statistics"));
        patentMenu.addMenuitem(new MenuItem(5, "Report: All Invoices"));
        patentMenu.addMenuitem(new MenuItem(6, "Search for Invoice"));
        patentMenu.addMenuitem(new MenuItem(7, "Program Statistics "));
        patentMenu.addMenuitem(new MenuItem(8, "Exit"));
        patentMenu.printMenuitem();
        
        
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please Enter Your choice: ");
        Integer choice = Integer.parseInt(userInput.nextLine());
        
        
        if (choice==1) {
        	
			patentMenu.getMenuItem(1).menu.printMenuitem();
			
		}
        
        else if (choice==2) {
        	
			patentMenu.getMenuItem(2).menu.printMenuitem();
			
		}
        
        
        
        System.out.println("Application Ended");
	}

}

