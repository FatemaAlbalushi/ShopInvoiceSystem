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
		
		Shop shop= new Shop("fruit Shop", "99999998", "24000023", "fruitShop@gamil.com", "fruit.com");
		System.out.println("Application Main Menu:");
		
		
		//ShopItem item = new ShopItem();
		
		Menu ShopSettingssubMenu = new Menu();
		ShopSettingssubMenu.addMenuitem(new MenuItem(1, "Load Data"));
		ShopSettingssubMenu.addMenuitem(new MenuItem(2, "Set Shop Name"));
		ShopSettingssubMenu.addMenuitem(new MenuItem(3, "Set Invoice Header"));
		ShopSettingssubMenu.addMenuitem(new MenuItem(4, "Go Back"));
		
		Menu ManageShopItemssubMenu = new Menu();
		ManageShopItemssubMenu.addMenuitem(new MenuItem(1, "Add Items"));
		ManageShopItemssubMenu.addMenuitem(new MenuItem(2, "Delete Items"));
		ManageShopItemssubMenu.addMenuitem(new MenuItem(3, "Change Item Price"));
		ManageShopItemssubMenu.addMenuitem(new MenuItem(4, "Report All Items"));
		ManageShopItemssubMenu.addMenuitem(new MenuItem(5, "Go Back"));
		
		MenuItem ShopSettingsMenu= new MenuItem(1, "Shop Settings");
		ShopSettingsMenu.marktheItemAsMenu(ShopSettingssubMenu);
		
		MenuItem ManageShopItemsMenu= new MenuItem(2, "Manage Shop Items");
		ManageShopItemsMenu.marktheItemAsMenu(ManageShopItemssubMenu);
		
		
        Menu ApplicationMainMenu = new Menu();
        ApplicationMainMenu.addMenuitem(ShopSettingsMenu);
        ApplicationMainMenu.addMenuitem(ManageShopItemsMenu);
        ApplicationMainMenu.addMenuitem(new MenuItem(3, "Create New Invoice"));
        ApplicationMainMenu.addMenuitem(new MenuItem(4, "Report: Statistics"));
        ApplicationMainMenu.addMenuitem(new MenuItem(5, "Report: All Invoices"));
        ApplicationMainMenu.addMenuitem(new MenuItem(6, "Search for Invoice"));
        ApplicationMainMenu.addMenuitem(new MenuItem(7, "Program Statistics "));
        ApplicationMainMenu.addMenuitem(new MenuItem(8, "Exit"));
        //patentMenu.printMenuitem();
        
        Integer choice;
        Integer option;
        Scanner userInput = new Scanner(System.in);
        do {
        	ApplicationMainMenu.printMenuitem();
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
                    ApplicationMainMenu.getMenuItem(1).menu.printMenuitem();
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
                    	 System.out.println("Load Data");
                        break;
                    case 2:
                    	 System.out.println("Set Shop Name");
                    	 shop.SetShopName();
                        break;
                    case 3:
                    	 System.out.println("Set Invoice Header");
                    	 
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
                    ApplicationMainMenu.getMenuItem(2).menu.printMenuitem();
                    System.out.print("Enter your Choice : ");
                    option = Integer.parseInt(userInput.nextLine());
                    switch (option) {
		            case 1:
		            	System.out.println("Add Item");
		            	shop.addItem();
	                break;
	            case 2:
	            	System.out.println("Delete Items");
	            	shop.loadItems();
	            //	ShopItem.deleteItem();
	                break;
	            case 3:
	            	System.out.println("Change Item Price");
	            //	ShopItem.changeItemPrice();
	                break;
	            case 4:
	            	System.out.println("Report All Items");
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
               // Shop.addInvoice();
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
            	while (choice == 8) {
                    System.out.print("Are you sure you want to exit? (y/n) ");
                    String confirm = userInput.nextLine().toLowerCase();
                    if (confirm.equals("y")) {
                      System.out.println("User input: " + confirm);
                      System.out.println("Exiting program...");
                      break;
                    } else if (confirm.equals("n")) {
                      System.out.println("User input: " + confirm);
                      choice = 0;
                      break;
                    } else {
                      System.out.println("Invalid choice. Try again.");
                    }
                  }
            	break;
            default:
                System.out.println("Invalid option!!!");
                break;
            }
        } while (choice != 8);
 
	}
}

