package DTO;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 4/4/2016.
 */
public class OrderDTO {
    private ArrayList<ItemDTO> itemList;
    private double totalAmt;
    private int userId;
    private int pin;
    private int shopId;


    public OrderDTO(int userId, ArrayList<ItemDTO> itemList){
        this.userId = userId;
        this.itemList = itemList;
        totalAmt = 0;
        for(int i=0; i<itemList.size(); i++){
            totalAmt += itemList.get(i).getPrice();
        }

        //Configured
        shopId = 1;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public ArrayList<ItemDTO> getItemList() {
        return itemList;
    }

    public double getTotalAmt() {
        return totalAmt;
    }

    public int getUserId() {
        return userId;
    }

    public JSONArray getItemListToJsonArray(){
        JSONArray itemArray = new JSONArray();
        for(int i=0; i<itemList.size(); i++){
            itemArray.put(itemList.get(i).getId());
        }
        return itemArray;
    }
}
