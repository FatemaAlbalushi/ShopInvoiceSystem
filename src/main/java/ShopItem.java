import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

/**
 * @author LAP-10
 *
 */
public class ShopItem {

	private int id;
	private String name;
	private float unitPrice;
	private int quantity;

	public ShopItem(int id, String name, float unitPrice, int quantity) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getAmount() {
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

}
