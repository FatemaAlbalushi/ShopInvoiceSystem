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

	public void saveShopDetails(Shop shop, String fileName) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter writer = new FileWriter(fileName)) {
			gson.toJson(shop, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  void addItem() {
	   final String itemsListFile = "data/items.json";
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
		System.out.println("Enter item id: ");
		int itemId = userInput.nextInt();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		   Type type = new TypeToken<List<ShopItem>>(){}.getType();
		   List<ShopItem> items = new ArrayList<>();

		   try (FileReader reader = new FileReader("data/items.json")) {
		      items = gson.fromJson(reader, type);
		   } catch (IOException e) {
		      e.printStackTrace();
		   }

		   for (ShopItem item : items) {
		      if (item.getitemId() == itemId) {
		         System.out.println("Item with id " + itemId + " already exists.");
		         return;
		      }
		   }
		   
		System.out.println("Enter item name: ");
		String itemName = userInput.next();

		System.out.println("Enter item price: ");
		double itemPrice = userInput.nextDouble();

		System.out.println("Enter item quantity: ");
		int itemQuantity = userInput.nextInt();
		ShopItem shopItem1 = new ShopItem(itemId, itemName, itemPrice, itemQuantity);
		items.add(shopItem1);

		try (FileWriter writer = new FileWriter("data/items.json")) {
			gson.toJson(items, writer);
		} catch (IOException e) {
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

	
	
	
//	 public void changeItemPrice(int itemId, double newPrice) {
//		    Gson gson = new Gson();
//		    Type type = new TypeToken<List<ShopItem>>(){}.getType();
//		    try (FileReader reader = new FileReader("items.json")) {
//		      List<ShopItem> items = gson.fromJson(reader, type);
//		      for (ShopItem item : items) {
//		        if (item.getitemId() == itemId) {
//		          item.setUnitPrice(newPrice);
//		          break;
//		        }
//		      }
//		      try (FileWriter writer = new FileWriter("items.json")) {
//		        gson.toJson(items, writer);
//		      }
//		    } catch (IOException e) {
//		      e.printStackTrace();
//		    }
//		  }
	
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
