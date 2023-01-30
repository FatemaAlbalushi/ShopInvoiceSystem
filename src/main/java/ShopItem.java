import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 * @author LAP-10
 *
 */
public class ShopItem {
	
	  private int itemId;
	  private String itemName;
	  private double unitPrice;
	  private int quantity;
	  private double qtyAmount;

	public ShopItem() {
	  //int itemId, String itemName, double unitPrice, int quantity, double qtyAmount) {
//		this.itemId = itemId;
//		this.itemName = itemName;
//		this.unitPrice = unitPrice;
//		this.quantity = quantity;
//		this.qtyAmount= qtyAmount;
	}

	public int getitemId() {
		return itemId;
	}

	public void setId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setName(String name) {
		this.itemName = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double newPrice) {
		this.unitPrice = newPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getQtyAmount() {
		return unitPrice * quantity;
	}
	
	public void addItem(ShopItem item) {
	    Gson gson = new Gson();
	    try (FileWriter writer = new FileWriter("items.json")) {
	      gson.toJson(item, writer);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	  public void deleteItem(int itemId) {
		    Gson gson = new Gson();
		    java.lang.reflect.Type type = new TypeToken<List<ShopItem>>(){}.getType();
		    try (FileReader reader = new FileReader("items.json")) {
		      List<ShopItem> items = gson.fromJson(reader, type);
		      List<ShopItem> itemsToSave = new ArrayList<>();
		      for (ShopItem item : items) {
		        if (item.getitemId() != itemId) {
		          itemsToSave.add(item);
		        }
		      }
		      try (FileWriter writer = new FileWriter("items.json")) {
		        gson.toJson(itemsToSave, writer);
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }

	  public void changeItemPrice(int itemId, double newPrice) {
		    Gson gson = new Gson();
		    Type type = new TypeToken<List<ShopItem>>(){}.getType();
		    try (FileReader reader = new FileReader("items.json")) {
		      List<ShopItem> items = gson.fromJson(reader, type);
		      for (ShopItem item : items) {
		        if (item.getitemId() == itemId) {
		          item.setUnitPrice(newPrice);
		          break;
		        }
		      }
		      try (FileWriter writer = new FileWriter("items.json")) {
		        gson.toJson(items, writer);
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }

	
	
	 public void reportAllItems() {
		    Gson gson = new Gson();
		    Type type = new TypeToken<List<ShopItem>>(){}.getType();
		    try (FileReader reader = new FileReader("items.json")) {
		      List<ShopItem> items = gson.fromJson(reader, type);
		      System.out.println("Item ID\tItem Name\tUnit Price\tQuantity\tQty Amount");
		      for (ShopItem item : items) {
		        System.out.println(item.getitemId() + "\t" + item.getItemName() + "\t" + item.getUnitPrice() + "\t" + item.getQuantity() + "\t" + item.getQtyAmount());
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }
}
