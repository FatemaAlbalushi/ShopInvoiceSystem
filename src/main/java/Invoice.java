import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

/**
 * @author LAP-10
 *
 */
public class Invoice {
	
	
	    private int InvoiceId;
	    private Customer customer;
	    private Date date;
	    private ArrayList<ShopItem> items;
	  

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

		public void saveToFile() {
			// TODO Auto-generated method stub
			 Gson gson = new Gson();
		        String json = gson.toJson(this);

		        try (FileWriter writer = new FileWriter("invoice.json")) {
		            gson.toJson(this, writer);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			
		}

	 
	    

}
