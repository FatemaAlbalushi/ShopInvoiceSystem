import java.util.ArrayList;
import java.util.Date;

/**
 * 
 *
 */
public class Invoice {
	    private int InvoiceId;
	    private Customer customer;
	    private Date date;
	    private ArrayList<ShopItem> items;
	    private Shop shop;
	    private float paidAmount;
	  

	    public Invoice(int InvoiceId, Date date) {
	        this.InvoiceId = InvoiceId;
	        this.date = date;
	    }

	    public int getInvoiceId() {
	        return InvoiceId;
	    }

	    public void setInvoiceId(int InvoiceId) {
	        this.InvoiceId = InvoiceId;
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
	            totalAmount += item.getQtyAmount();
	        }
	        return totalAmount;
	    }

	    

	    public float getPaidAmount() {
	        return paidAmount;
	    }

	    public void setPaidAmount(float paidAmount) {
	        this.paidAmount = paidAmount;
	    }

	    public float getBalance() {
	        return getTotalAmount() - paidAmount;
	    }
	    

	    public void setInvoiceHeader(Shop shop) {
		    this.shop = shop;
		  }

		  public Shop getShop() {
		    return shop;
		  }

		  public void setShop(Shop shop) {
		    this.shop = shop;
		  }	    

}
