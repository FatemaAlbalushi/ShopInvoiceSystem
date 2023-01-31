import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 * The Shop class represents a shop object with a name, phone number, fax number, email and website.
 * It contains an ArrayList of ShopItems and Invoices.
 * There are two constructors available: one with 5 parameters to initialize all member variables
 * and one with only 1 parameter to only initialize the shop name.
 * The class also provides setters for the phone number, fax number, email and website.
 */

public class Shop {
	String Shopname; // Name of the shop
	private String tel; // Telephone number of the shop
	private String fax; // Fax number of the shop
	private String email; // Email address of the shop
	private String website; // Website of the shop

	private ArrayList<ShopItem> shopitemlist = new ArrayList<ShopItem>(); // List of shop items
	private ArrayList<Invoice> invoices = new ArrayList<Invoice>(); // List of invoices

	/**
	 * Constructor for creating a Shop object with all contact information.
	 * @param shopname Name of the shop.
	 * @param tel Telephone number of the shop.
	 * @param fax Fax number of the shop.
	 * @param email Email address of the shop.
	 * @param website Website of the shop.
	 */
	public Shop(String shopname, String tel, String fax, String email, String website) {
		this.Shopname = shopname;
		this.tel = tel;
		this.fax = fax;
		this.email = email;
		this.website = website;
	}

	/**
	 * Constructor for creating a Shop object with only the name.
	 * @param shopname Name of the shop.
	 */
	public Shop(String shopname) {
		this.Shopname = shopname;
	}

	/**
	 * Setter method for setting the telephone number of the shop.
	 * @param tel Telephone number of the shop.
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * Setter method for setting the fax number of the shop.
	 * @param fax Fax number of the shop.
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * Setter method for setting the email address of the shop.
	 * @param email Email address of the shop.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Setter method for setting the website of the shop.
	 * @param website Website of the shop.
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	
	
	/**
	 * Method to change the name of the shop.
	 * Prompts user to enter the new name for the shop.
	 * Updates the shop name with the new name entered by the user
	*/
	public void setShopName() {
		//Prompt the user to enter a new shop name
		System.out.print("Enter the new shop name: ");
		
		//Create a variable to hold the new shop name
		String newShopName = null;
		
		//Get the input from the user and store it in the newShopName variable
	
		//Set the shop name of the object to the new shop name
		this.Shopname = newShopName;
	}
	
	/**
	 * Saves the details of a Shop object to a file using Gson library.
	 *
	 * @param shop The Shop object to be saved.
	 * @param fileName The name of the file to which the details of the Shop object will be saved.
	 */
	public void saveShopDetails(Shop shop, String fileName) {
	    // Create a Gson object with pretty printing enabled.
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();

	    try (FileWriter writer = new FileWriter(fileName)) {
	        // Convert the Shop object to a JSON string and write it to the file.
	        gson.toJson(shop, writer);
	    } catch (IOException e) {
	        // Print the stack trace of the IOException if it occurs.
	        e.printStackTrace();
	    }
	}

	/**
	 * Adds a new item to the list of items in the shop.
	 *
	 * The item details are read from the standard input (keyboard) and the updated list of items is saved to a file.
	 */
	public void addItem() {
	    // Define the file name for the items list
	    final String itemsListFile = "data/items.json";
	    // Create a File object for the items list file
	    File itemsFile = new File(itemsListFile);

	    // Try to create the file if it doesn't exist
	    try {
	        if (!itemsFile.exists()) {
	            itemsFile.createNewFile();
	        }
	    } catch (IOException e) {
	        // Print an error message if there was an issue creating the file
	        System.out.println("Error creating file: " + e.getMessage());
	        // Return from the method to stop execution
	        return;
	    }

	    // Create a Scanner to get user input
	    Scanner userInput = new Scanner(System.in);

	    // Ask for the item id
	    System.out.println("Enter item id: ");
	    int itemId = userInput.nextInt();

	    // Create a Gson object for serializing and deserializing JSON
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    // Define the type for the items list
	    Type type = new TypeToken<List<ShopItem>>(){}.getType();
	    // Create an empty items list
	    List<ShopItem> items = new ArrayList<>();

	    // Try to read the items list from the file
	    try (FileReader reader = new FileReader("data/items.json")) {
	        // Deserialize the JSON data into the items list
	        items = gson.fromJson(reader, type);
	    } catch (IOException e) {
	        // Print the error message if there was an issue reading the file
	        e.printStackTrace();
	    }

	    // Check if the item with the same id already exists in the items list
	    for (ShopItem item : items) {
	        if (item.getitemId() == itemId) {
	            // Print a message if the item already exists and return from the method
	            System.out.println("Item with id " + itemId + " already exists.");
	            return;
	        }
	    }

	    // Ask for the item name
	    System.out.println("Enter item name: ");
	    String itemName = userInput.next();

	    // Ask for the item price
	    System.out.println("Enter item price: ");
	    double itemPrice = userInput.nextDouble();

	    // Ask for the item quantity
	    System.out.println("Enter item quantity: ");
	    int itemQuantity = userInput.nextInt();

	    // Create a new ShopItem object with the obtained information
	    ShopItem shopItem = new ShopItem(itemId, itemName, itemPrice, itemQuantity);
	    // Add the new ShopItem to the items list
	    items.add(shopItem);

	    // Try to write the updated items list back to the file
	    try (FileWriter writer = new FileWriter("data/items.json")) {
	        // Serialize the items list into JSON and write it to the file
	        gson.toJson(items, writer);
	    } catch (IOException e) {
	        // Print the error message if there was an issue writing to the file
	        e.printStackTrace();
	    }
	}


	
	/**
	 * The method 'loadItems' is used to load the shop items from the JSON file 'data/items.json'.
	 * The items are then displayed on the console with the following format:
	 * Item ID Item Name Unit Price Quantity Qty Amount
	 * The method uses the Gson library to parse the JSON file. A type is defined using the TypeToken class to indicate that the JSON file contains a list of ShopItem objects.
	 * A try-with-resources block is used to open the reader for the JSON file, and the items are read and stored in a List.
	 * The items are then displayed on the console with the specified format.
	 * In case of an IOException, the stack trace is printed.
	*/
	public void loadItems() {
	    // Initialize the Gson object
	    Gson gson = new Gson();
	    // Define the type of object to be used for parsing
	    Type type = new TypeToken<List<ShopItem>>(){}.getType();
	    try (FileReader reader = new FileReader("data/items.json")) {
	      // Read and parse the JSON data into a list of ShopItem objects
	      List<ShopItem> items = gson.fromJson(reader, type);
	      // Display the items details
	      System.out.println("Item ID\tItem Name\tUnit Price\tQuantity\tQty Amount");
	      for (ShopItem item : items) {
	        System.out.println(item.getitemId() + "\t" + item.getItemName() + "\t"+"\t" + item.getUnitPrice() + "\t" +"\t"+ item.getQuantity() + "\t"+ "\t"+ item.getQtyAmount());
	      }
	    } catch (IOException e) {
	      // Print the stack trace in case of any error
	      e.printStackTrace();
	    }	  

}
	/**

	Method to delete a ShopItem from the list of items stored in a JSON file.
	@param itemId The ID of the item to be deleted.
	*/
	public void deleteItem(int itemId) {
	Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Gson instance with pretty printing enabled
	Type type = new TypeToken<List<ShopItem>>(){}.getType(); // type parameter for the list of ShopItems
	try (FileReader reader = new FileReader("data/items.json")) {
	// Read the JSON file into a list of ShopItems
	List<ShopItem> items = gson.fromJson(reader, type);
	// Create a new list to store the items that will be saved
	List<ShopItem> itemsToSave = new ArrayList<>();

	// Flag to keep track of whether the item was found or not
	boolean itemFound = false;

	// Loop through the list of items and add the items that are not being deleted to the new list
	for (ShopItem item : items) {
	  if (item.getitemId() != itemId) {
	    itemsToSave.add(item);
	  } else {
	    itemFound = true;
	  }
	}

	// If the item was not found, display a message and return
	if (!itemFound) {
	  System.out.println("Item with id " + itemId + " was not found.");
	  return;
	}

	// Write the updated list of items to the JSON file
	try (FileWriter writer = new FileWriter("data/items.json")) {
	  gson.toJson(itemsToSave, writer);
	}
	} catch (IOException e) {
		e.printStackTrace();
		}
}


	
	public static void changeItemPrice(int itemId, double newPrice) {
		  //Gson gson = new Gson();
		  Gson gson = new GsonBuilder().setPrettyPrinting().create();
		  Type type = new TypeToken<List<ShopItem>>(){}.getType();
		  try (FileReader reader = new FileReader("data/items.json")) {
		    List<ShopItem> items = gson.fromJson(reader, type);
		    boolean itemExists = false;
		    for (ShopItem item : items) {
		      if (item.getitemId() == itemId) {
		        itemExists = true;
		        item.setUnitPrice(newPrice);
		        break;
		      }
		    }
		    if (!itemExists) {
		      System.out.println("Item with id " + itemId + " not found.");
		      return;
		    }
		    try (FileWriter writer = new FileWriter("data/items.json")) {
		      gson.toJson(items, writer);
		    }
		  } catch (IOException e) {
		    e.printStackTrace();
		  }
		}

	
	public void addInvoice() {
		
		 final String itemsListFile = "data/invoices.json";
	        File itemsFile = new File(itemsListFile);
	        try {
	            if (!itemsFile.exists()) {
	                itemsFile.createNewFile();
	            }
	        } catch (IOException e) {
	            System.out.println("Error creating file: " + e.getMessage());
	            return;
	        }

		Scanner userInput = new Scanner(System.in);

		int invoiceId = userInput.nextInt();
		System.out.println("Enter invoice Id: ");

		System.out.print("Enter date (mm/dd/yyyy): ");
		String dateString = new Scanner(System.in).nextLine();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		}

		Invoice invoice1 = new Invoice(invoiceId, date);
		invoices.add(invoice1);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter writer = new FileWriter("data/invoices.json")) {
			gson.toJson(invoice1, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
