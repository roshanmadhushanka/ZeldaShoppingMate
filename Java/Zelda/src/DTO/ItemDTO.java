/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author User
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
    
    public void display(){
        System.out.println("ID          : " + String.valueOf(id));
        System.out.println("ProductId   : " + String.valueOf(productId));
        System.out.println("Name        : " + name);
        System.out.println("Description : " + description);
        System.out.println("Type        : " + type);
        System.out.println("Price       : " + String.valueOf(price));
        System.out.println("Status      : " + status);
    }
}
