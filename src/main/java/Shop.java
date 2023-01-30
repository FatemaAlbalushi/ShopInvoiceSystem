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

public class Shop {
  private String name;
  private String tel;
  private String fax;
  private String email;
  private String website;
  private List<ShopItem> shopItem = new ArrayList<>();
  private List<Invoice> invoices = new ArrayList<>();

  public Shop(String name) {
    this.name = name;
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
  
  public static void saveShopDetails(Shop shop, String fileName) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      try (FileWriter writer = new FileWriter(fileName)) {
         gson.toJson(shop, writer);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

  public void addItem(ShopItem shopItem) {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter item id: ");
    int itemId = userInput.nextInt();
    System.out.println("Enter item name: ");
    String itemName = userInput.next();
    System.out.println("Enter item price: ");
    double itemPrice = userInput.nextDouble();
    System.out.println("Enter item quantity: ");
    int itemQuantity = userInput.nextInt();
    ShopItem shopItem1= new ShopItem(itemId, itemName, itemPrice, itemQuantity);
    this.shopItem.add(shopItem1);
	
	 Gson gson = new GsonBuilder().setPrettyPrinting().create();
    try (FileWriter writer = new FileWriter("items.json")) {
      gson.toJson(shopItem1, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
  }

  public void addInvoice(Invoice invoice) {
   
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

    Invoice invoice1 = new Invoice(invoiceId,date);
    this.invoices.add(invoice1);
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    try (FileWriter writer = new FileWriter("invoices.json")) {
      gson.toJson(invoice1, writer);
    } catch (IOException e) {
      e.printStackTrace();
  }
}
}
