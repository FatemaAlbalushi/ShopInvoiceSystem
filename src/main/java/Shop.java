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

public class Shop {
	String Shopname;
	private String tel;
	private String fax;
	private String email;
	private String website;

	private ArrayList<ShopItem> shopitemlist = new ArrayList<ShopItem>();
	private ArrayList<Invoice> invoices = new ArrayList<Invoice>();

	public Shop(String shopname, String tel, String fax, String email, String website) {
		this.Shopname = shopname;
		this.tel = tel;
		this.fax = fax;
		this.email = email;
		this.website = website;
	}

	public Shop(String shopname) {
		this.Shopname = shopname;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void SetShopName() {
		String newShopName = null;
		System.out.print("Enter the new shop name: ");
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

//	public  void addItem() {
//	   final String itemsListFile = "data/items.json";
//	        File itemsFile = new File(itemsListFile);
//	        try {
//	            if (!itemsFile.exists()) {
//	                itemsFile.createNewFile();
//	            }
//	        } catch (IOException e) {
//	            System.out.println("Error creating file: " + e.getMessage());
//	            return;
//	        }
//		Scanner userInput = new Scanner(System.in);
//		System.out.println("Enter item id: ");
//		int itemId = userInput.nextInt();
//
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		   Type type = new TypeToken<List<ShopItem>>(){}.getType();
//		   List<ShopItem> items = new ArrayList<>();
//
//		   try (FileReader reader = new FileReader("data/items.json")) {
//		      items = gson.fromJson(reader, type);
//		   } catch (IOException e) {
//		      e.printStackTrace();
//		   }
//
//		   for (ShopItem item : items) {
//		      if (item.getitemId() == itemId) {
//		         System.out.println("Item with id " + itemId + " already exists.");
//		         return;
//		      }
//		   }
//		   
//		System.out.println("Enter item name: ");
//		String itemName = userInput.next();
//
//		System.out.println("Enter item price: ");
//		double itemPrice = userInput.nextDouble();
//
//		System.out.println("Enter item quantity: ");
//		int itemQuantity = userInput.nextInt();
//		ShopItem shopItem1 = new ShopItem(itemId, itemName, itemPrice, itemQuantity);
//		items.add(shopItem1);
//
//		try (FileWriter writer = new FileWriter("data/items.json")) {
//			gson.toJson(items, writer);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
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


	
	
	
	public void loadItems() {
			    Gson gson = new Gson();
			    Type type = new TypeToken<List<ShopItem>>(){}.getType();
			    try (FileReader reader = new FileReader("data/items.json")) {
			      List<ShopItem> items = gson.fromJson(reader, type);
			      System.out.println("Item ID\tItem Name\tUnit Price\tQuantity\tQty Amount");
			      for (ShopItem item : items) {
			        System.out.println(item.getitemId() + "\t" + item.getItemName() + "\t"+"\t" + item.getUnitPrice() + "\t" +"\t"+ item.getQuantity() + "\t"+ "\t"+ item.getQtyAmount());
			      }
			    } catch (IOException e) {
			      e.printStackTrace();
			    }	  
	    
	}
	
	
	public void deleteItem(int itemId) {
		  //Gson gson = new Gson();
		  Gson gson = new GsonBuilder().setPrettyPrinting().create();
		  Type type = new TypeToken<List<ShopItem>>(){}.getType();
		  try (FileReader reader = new FileReader("data/items.json")) {
		    List<ShopItem> items = gson.fromJson(reader, type);
		    List<ShopItem> itemsToSave = new ArrayList<>();
		    boolean itemFound = false;
		    for (ShopItem item : items) {
		      if (item.getitemId() != itemId) {
		        itemsToSave.add(item);
		      } else {
		        itemFound = true;
		      }
		    }
		    if (!itemFound) {
		      System.out.println("Item with id " + itemId + " was not found.");
		      return;
		    }
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
