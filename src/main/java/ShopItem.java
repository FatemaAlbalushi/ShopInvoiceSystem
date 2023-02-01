/**
 * ShopItem class represents a single item in a shop with its id, name, unit
 * price, and quantity.
 */
public class ShopItem {

	/**
	 * An integer value to store the id of the item
	 */
	private int itemId;
	/**
	 * A string value to store the name of the item
	 */
	private String itemName;
	/**
	 * A double value to store the unit price of the item
	 */
	private double unitPrice;
	/**
	 * An integer value to store the quantity of the item
	 */
	private int quantity;

	/**
	 * Constructor that initializes all the fields of the class
	 * 
	 * @param itemId    The id of the item
	 * @param itemName  The name of the item
	 * @param unitPrice The unit price of the item
	 * @param quantity  The quantity of the item
	 */
	public ShopItem(int itemId, String itemName, double unitPrice, int quantity) {

		this.itemId = itemId;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;

	}

	/**
	 * Gets the id of the item
	 * 
	 * @return The id of the item
	 */
	public int getitemId() {
		return itemId;
	}

	/**
	 * Sets the id of the item
	 * 
	 * @param itemId The new id of the item
	 */
	public void setId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * Gets the name of the item
	 * 
	 * @return The name of the item
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Sets the name of the item
	 * 
	 * @param name The new name of the item
	 */
	public void setName(String name) {
		this.itemName = name;
	}

	/**
	 * Gets the unit price of the item
	 * 
	 * @return The unit price of the item
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * Sets the unit price of the item
	 * 
	 * @param newPrice The new unit price of the item
	 */
	public void setUnitPrice(double newPrice) {
		this.unitPrice = newPrice;
	}

	/**
	 * Gets the quantity of the item
	 * 
	 * @return The quantity of the item
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Calculates the total amount for the item by multiplying the unit price with
	 * the quantity.
	 * 
	 * @return The total amount for the item
	 */
	public double getQtyAmount() {
		return unitPrice * quantity;
	}

}
