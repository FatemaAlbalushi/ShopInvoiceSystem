import java.lang.StackWalker.Option;
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
		
		
		ShopItem item = new ShopItem();
		
		Menu subMenuAdminAction1 = new Menu();
		subMenuAdminAction1.addMenuitem(new MenuItem(1, "Load Data"));
		subMenuAdminAction1.addMenuitem(new MenuItem(2, "Set Shop Name"));
		subMenuAdminAction1.addMenuitem(new MenuItem(3, "Set Invoice Header"));
		subMenuAdminAction1.addMenuitem(new MenuItem(4, "Go Back"));
		
		Menu subMenuAdminAction2 = new Menu();
		subMenuAdminAction2.addMenuitem(new MenuItem(1, "Add Items"));
		subMenuAdminAction2.addMenuitem(new MenuItem(2, "Delete Items"));
		subMenuAdminAction2.addMenuitem(new MenuItem(3, "Change Item Price"));
		subMenuAdminAction2.addMenuitem(new MenuItem(4, "Report All Items"));
		subMenuAdminAction2.addMenuitem(new MenuItem(5, "Go Back"));
		
		MenuItem adminActionMenu1= new MenuItem(1, "Shop Settings");
		adminActionMenu1.marktheItemAsMenu(subMenuAdminAction1);
		
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
        //patentMenu.printMenuitem();
        
        Integer choice;
        Integer option;
        Scanner userInput = new Scanner(System.in);
        do {
        	patentMenu.printMenuitem();
            System.out.print("Enter your Choice : ");
            choice = 0;
            try {
                choice = Integer.parseInt(userInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
                continue;
            }
            switch (choice) {
            case 1:
                do {
                    System.out.println("Shop Settings");
                    patentMenu.getMenuItem(1).menu.printMenuitem();
                    System.out.print("Enter your option : ");
                    option = 0;
                    try {
                    	option = Integer.parseInt(userInput.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Enter a number.");
                        continue;
                    }
                    switch (option) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("Going Back...");
                        break;
                    default:
                        System.out.println("Invalid option!!!");
                        break;
                    }
                } while (option != 4);
                break;
            case 2:
                do {
                    System.out.println("Shop Settings");
                    patentMenu.getMenuItem(2).menu.printMenuitem();
                    System.out.print("Enter your Choice : ");
                    option = Integer.parseInt(userInput.nextLine());
                    switch (option) {
		            case 1:
	            	System.out.println("Enter item id: ");
	                int itemId = userInput.nextInt();
	                System.out.println("Enter item name: ");
	                String itemName = userInput.next();
	                System.out.println("Enter item price: ");
	                double itemPrice = userInput.nextDouble();
	                System.out.println("Enter item quantity: ");
	                int itemQuantity = userInput.nextInt();
	              //  item.addItem(itemId, itemName, itemPrice, itemQuantity);
	            	//ShopItem.addItem(item);
	                break;
	            case 2:
	            //	ShopItem.deleteItem();
	                break;
	            case 3:
	            //	ShopItem.changeItemPrice();
	                break;
	            case 4:
	            	//ShopItem.reportAllItems();
	                break;
                    case 5:
                        System.out.println("Going Back...");
                        break;
                    default:
                        System.out.println("Invalid option!!");
                        break;
                    }
                } while (option != 5);
                break;
            case 3:
                System.out.println("Create New Invoice");
                break;
            case 4:
                System.out.println("Report - Statistics");
                break;
            case 5:
                System.out.println("Report - All Invoices");
                break;
            case 6:
                System.out.println("Search Invoice");
                break;
            case 7:
                System.out.println("Program Statistics");
                break;
            case 8:
                System.out.println("EXITING PROGRAM...");
                break;
            default:
                System.out.println("Invalid option!!!");
                break;
            }
        } while (choice != 8);
 
	}
}

