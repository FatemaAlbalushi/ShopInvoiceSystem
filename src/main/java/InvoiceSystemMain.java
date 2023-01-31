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
	
		
		Menu ShopSettingssubMenu = new Menu();
		ShopSettingssubMenu.addMenuitem(new MenuItem(1, "Load Data"));
		ShopSettingssubMenu.addMenuitem(new MenuItem(2, "Set Shop Name"));
		ShopSettingssubMenu.addMenuitem(new MenuItem(3, "Set Invoice Header   Not Implemented..."));
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
        ApplicationMainMenu.addMenuitem(new MenuItem(3, "Create New Invoice   Not Implemented..."));
        ApplicationMainMenu.addMenuitem(new MenuItem(4, "Report: Statistics   Not Implemented..."));
        ApplicationMainMenu.addMenuitem(new MenuItem(5, "Report: All Invoices Not Implemented..."));
        ApplicationMainMenu.addMenuitem(new MenuItem(6, "Search for Invoice   Not Implemented..."));
        ApplicationMainMenu.addMenuitem(new MenuItem(7, "Program Statistics   Not Implemented... "));
        ApplicationMainMenu.addMenuitem(new MenuItem(8, "Exit"));
       
        
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
                    	 shop.loadShopDetails();
                    	 
                    	 
                        break;
                    case 2:
                    	 System.out.println("Set Shop Name");
                    	 shop.setShopName();
                    	 shop.saveShopDetails(shop);
                    	 
                        break;
                    case 3:
                    	 System.out.println("Set Invoice Header Not Implemented...");
                    	 
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
                    System.out.println("Manage Shop Items");
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
	            	System.out.println("What item you went to deleat");
               	    shop.loadItems();
	            	System.out.print("Enter Item Id : ");
	                int input = 0;
	                try {
	                	input = Integer.parseInt(userInput.nextLine());
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid input. Enter a number.");
	                   
	                }
	            	shop.deleteItem(input);
	         
	                break;
	            case 3:
	            	System.out.println("Change Item Price");
	            	System.out.print("Enter Item Id : ");
	                int id = 0;
	                try {
	                	id = Integer.parseInt(userInput.nextLine());
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid input. Enter a number.");
	                   
	                }
	                System.out.println("Enter item price: ");
	        		double price = Double.parseDouble(userInput.nextLine()) ;
	               
	           
	                Shop.changeItemPrice(id,price);
	                break;
	            case 4:
	            	System.out.println("Report All Items");
	            	shop.loadItems();
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
                System.out.println("Create New Invoice   Not Implemented..." );
               // Shop.addInvoice();
                break;
            case 4:
                System.out.println("Report - Statistics  Not Implemented...");
                break;
            case 5:
                System.out.println("Report - All Invoices  Not Implemented...");
                break;
            case 6:
                System.out.println("Search Invoice  Not Implemented...");
                break;
            case 7:
                System.out.println("Program Statistics  Not Implemented...");
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

