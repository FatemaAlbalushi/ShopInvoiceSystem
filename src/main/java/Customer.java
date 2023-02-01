
/**
 * Class to represent a customer object
 */
public class Customer {
	// Private instance variable for the customer's id
	private int Customerid;
	
	// Private instance variable for the customer's name
	private String Customername;
	
	// Private instance variable for the customer's phone number
	private String CustomerphoneNumber;

	/**
	 * Constructor to create a new customer object
	 * @param Ccustomerid the customer's id
	 * @param customername the customer's name
	 * @param customerphoneNumber the customer's phone number
	 */
	public Customer(int Ccustomerid, String customername, String customerphoneNumber) {
		// Assign the parameter values to the instance variables
		this.Customerid = Ccustomerid;
		this.Customername = customername;
		this.CustomerphoneNumber = customerphoneNumber;
	}

	/**
	 * Getter method for the customer's id
	 * @return the customer's id
	 */
	public int getId() {
		return Customerid;
	}

	/**
	 * Setter method for the customer's id
	 * @param Ccustomerid the new customer's id
	 */
	public void setId(int Ccustomerid) {
		this.Customerid = Ccustomerid;
	}

	/**
	 * Getter method for the customer's name
	 * @return the customer's name
	 */
	public String getName() {
		return Customername;
	}

	/**
	 * Setter method for the customer's name
	 * @param customername the new customer's name
	 */
	public void setName(String customername) {
		this.Customername = customername;
	}

	/**
	 * Getter method for the customer's phone number
	 * @return the customer's phone number
	 */
	public String getPhoneNumber() {
		return CustomerphoneNumber;
	}

	/**
	 * Setter method for the customer's phone number
	 * @param customerphoneNumber the new customer's phone number
	 */
	public void setPhoneNumber(String customerphoneNumber) {
		this.CustomerphoneNumber = customerphoneNumber;
	}

}
