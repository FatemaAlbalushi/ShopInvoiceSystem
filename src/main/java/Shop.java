import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    this.shopItem.add(shopItem);
    
  }

  public void addInvoice(Invoice invoice) {
    this.invoices.add(invoice);
    
  }
}
