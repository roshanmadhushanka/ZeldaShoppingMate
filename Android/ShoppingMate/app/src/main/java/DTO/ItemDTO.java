package DTO;

import android.widget.Toast;

import com.example.user.shoppingmate.ContextObject;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by User on 3/24/2016.
 */
public class ItemDTO {
    private int id;
    private int productId;
    private String name;
    private String description;
    private Double price;
    private String type;
    private String status;
    private int quantity;
    private int maxQuantity;

    public ItemDTO(){
        quantity = 1;
    }

    public ItemDTO(int id, int productId, String name, String description, Double price, String type, String status) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.status = status;
    }

    public ItemDTO(int productId,String name, String description, Double price, String type) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.status = "U";
    }

    public JSONObject getJsonObject(){
        JSONObject item = new JSONObject();
        try {
            item.put("id", id);
            item.put("productId", productId);
            item.put("name", name);
            item.put("description", description);
            item.put("price", price);
            item.put("type", type);
        } catch (JSONException e) {

        }
        return item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public void increaseQuantity(int increment){
        if((quantity+increment)<=maxQuantity){
            quantity += increment;
        }else{
            Toast.makeText(ContextObject.GetContext(), "You cannot buy " + name, Toast.LENGTH_SHORT).show();
        }
    }
}
