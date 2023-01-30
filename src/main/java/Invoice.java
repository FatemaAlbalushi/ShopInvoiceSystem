import java.util.ArrayList;
import java.util.Date;

/**
 * @author LAP-10
 *
 */
public class Invoice {
	
	
	    private int id;
	    private Customer customer;
	    private Date date;
	    private ArrayList<ShopItem> items;

	    public Invoice(int id, Customer customer, Date date, ArrayList<ShopItem> items) {
	        this.id = id;
	        this.customer = customer;
	        this.date = date;
	        this.items = items;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public ArrayList<ShopItem> getItems() {
	        return items;
	    }
	    
	    public void setItems(ArrayList<ShopItem> items) {
	        this.items = items;
	    }

	    public float getTotalAmount() {
	        float totalAmount = 0;
	        for (ShopItem item : items) {
	            totalAmount += item.getAmount();
	        }
	        return totalAmount;
	    }

	    private float paidAmount;

	    public float getPaidAmount() {
	        return paidAmount;
	    }

	    public void setPaidAmount(float paidAmount) {
	        this.paidAmount = paidAmount;
	    }

	    public float getBalance() {
	        return getTotalAmount() - paidAmount;
	    }


}
